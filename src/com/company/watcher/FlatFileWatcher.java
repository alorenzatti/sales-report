package com.company.watcher;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

public interface FlatFileWatcher {
	
	public void watch(Path inDir, Path outDir, String[] fileExtensions, WatchEvent.Kind[] watchEvents);
}
