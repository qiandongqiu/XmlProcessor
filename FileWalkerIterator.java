package com.dq.FileWalker;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class FileWalkerIterator implements Iterable<FileInfo>{
	
	List<FileInfo> files; // = new ArrayList<FileInfo>();
	public FileWalkerIterator(String path) {
		files = new ArrayList<FileInfo>();
		walk(path, files);
		System.out.println(files.size());
	}
	
	
	 private void walk( String path, List<FileInfo> files ) {

	        File root = new File( path );
	        File[] list = root.listFiles();

	        if (list == null) return;

	        for ( File f : list ) {
	            if ( f.isDirectory() ) {
	                walk(f.getAbsolutePath(), files);
	            }
	            else {
	            	files.add(new FileInfo(path, f.getName(), f.getAbsolutePath()));
	            }
	        }
	 }

	@Override
	public Iterator<FileInfo> iterator() {
		// TODO Auto-generated method stub
		return files.iterator();
	}
	

	public static void main(String[] args) {
		FileWalkerIterator fwit = new FileWalkerIterator(".");
		Iterator<FileInfo> it = fwit.iterator();
		while(it.hasNext()) {
		    FileInfo fi = it.next();
		    System.out.println(fi.getDirectory() +" ==> " + fi.getFullName());
		    
		}
	}
	
}
