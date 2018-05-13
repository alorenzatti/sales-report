package com.company.watcher;

import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;

import org.junit.Before;
import org.junit.Test;

public class FlatFileWatcherTest {
	
	private FlatFileWatcher flatFileWatcher;
	
	@Before
	public void setup() {
		this.flatFileWatcher = WatcherFactory.newFlatFileWatcher();
	}
	
	@Test
	public void test() {
		this.flatFileWatcher.watch(Paths.get("data/in"), Paths.get("data/out"), new String[] {"dat"}, new WatchEvent.Kind[] {StandardWatchEventKinds.ENTRY_MODIFY});
	}

}
