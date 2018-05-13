package com.company.watcher;

public class WatcherFactory {
	
	public static FlatFileWatcher newFlatFileWatcher() {
		return new FlatFileWatcherImpl();
	}
}
