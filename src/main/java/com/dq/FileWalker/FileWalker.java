package com.dq.FileWalker;

import java.io.File;

public class FileWalker {

    public void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                //System.out.println( "Dir:" + f.getAbsoluteFile() );
                System.out.println( "Dir:" + f.getName() );
            }
            else {
                System.out.println( "File:" + f.getAbsoluteFile() );
                System.out.println( "File:" + f.getName() );
            }
        }
    }

    public static void main(String[] args) {
        FileWalker fw = new FileWalker();
        fw.walk("." );
    }

}