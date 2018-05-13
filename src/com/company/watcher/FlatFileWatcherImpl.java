package com.company.watcher;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.io.FlatFileReader;
import com.company.io.FlatFileReportWriter;
import com.company.io.IOFactory;
import com.company.model.FlatFile;
import com.company.model.FlatFileReport;
import com.company.reporter.FlatFileReporter;
import com.company.reporter.ReporterFactory;

/**
 * Code based on the following example: https://docs.oracle.com/javase/tutorial/essential/io/examples/WatchDir.java
 *
 */
class FlatFileWatcherImpl implements FlatFileWatcher {
	
	@SuppressWarnings("unchecked")
    private static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>) event;
    }
	
	@Override
	public void watch(Path inDir, Path outDir, String[] fileExtensions, WatchEvent.Kind[] watchEvents) {
		
		try {
			
			final WatchService watcher = FileSystems.getDefault().newWatchService();
			final Map<WatchKey,Path> keys = this.register(inDir, watcher, watchEvents);
			
			this.processEvents(watcher, keys, outDir, fileExtensions);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private Map<WatchKey,Path> register(Path inDir, WatchService watcher, WatchEvent.Kind[] watchEvents) throws IOException {
		
		final Map<WatchKey,Path> keys = new HashMap<>();
		final WatchKey watchKey = inDir.register(watcher, watchEvents);
		keys.put(watchKey, inDir);
		
		return keys;
	}

	public void processEvents(WatchService watcher, Map<WatchKey,Path> keys, Path outDir, String[] fileExtensions) {
		
		final List<String> fileExtensionsList = Arrays.asList(fileExtensions);
		
        while(true) {

            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            final Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> pollEvent : key.pollEvents()) {
                final WatchEvent.Kind kind = pollEvent.kind();
                
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
                
                final WatchEvent<Path> event = cast(pollEvent);
                final Path name = event.context();
                final Path flatFile = dir.resolve(name);
                
                try {
                	Thread.sleep(1000); // In order to avoid concurrency problems over the same flat file
                } catch(InterruptedException e) {
                	e.printStackTrace();
                }
                
                if(flatFile.toFile().exists()) {
                	
                	final String flatFileName = flatFile.toString();
                	final String flatFileExtension = flatFileName.toLowerCase().substring(flatFileName.length() - 3, flatFileName.length());
                	
                	if(fileExtensionsList.contains(flatFileExtension)) {
                		
                		final FlatFileReader flatFileReader = IOFactory.newFlatFileReader("ç");
                		final FlatFile flatFileModel = flatFileReader.getFlatFile(flatFile);
                		final FlatFileReporter flatFileReporter = ReporterFactory.newFlatFileReporter();
                		final FlatFileReport flatFileReport = flatFileReporter.getReport(flatFileModel);
                		final FlatFileReportWriter flatFileReportWriter = IOFactory.newFlatFileReportWriter();
                		flatFileReportWriter.writeFlatFileReport(flatFileReport, outDir.toFile());
                	}
                }
            }

            // reset key and remove from set if directory no longer accessible
            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);

                // all directories are inaccessible
                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }

}
