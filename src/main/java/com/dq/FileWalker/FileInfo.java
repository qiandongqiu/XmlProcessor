package com.dq.FileWalker;

public class FileInfo {
	String directory;
	String name;
	String fullName;
	
	public FileInfo(String directory, String name, String fullName) {
		this.directory = directory;
		this.name = name;
		this.fullName = fullName;
	}
	
	public String getDirectory() {
		return this.directory;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFullName() {
		return this.fullName;
	}
}
