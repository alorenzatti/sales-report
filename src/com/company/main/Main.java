package com.company.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;

import com.company.watcher.FlatFileWatcher;
import com.company.watcher.WatcherFactory;

public class Main {

	public static void main(String[] args) {
		
		final String homepath = System.getenv("HOMEPATH");
		final Path inDir = Paths.get(homepath + "/data/in");
		final Path outDir = Paths.get(homepath + "/data/out");
		
		final FlatFileWatcher flatFileWatcher = WatcherFactory.newFlatFileWatcher();
		flatFileWatcher.watch(inDir, outDir, new String[] {"dat"}, new WatchEvent.Kind[] {StandardWatchEventKinds.ENTRY_MODIFY});
	}
}
