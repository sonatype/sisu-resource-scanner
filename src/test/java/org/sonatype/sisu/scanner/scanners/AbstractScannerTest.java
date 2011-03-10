package org.sonatype.sisu.scanner.scanners;

import java.io.File;

import org.junit.Test;
import org.sonatype.sisu.resource.scanner.Listener;
import org.sonatype.sisu.resource.scanner.Scanner;

import static org.mockito.Mockito.*;

import org.mockito.Matchers;

public abstract class AbstractScannerTest
{

    /**
     * Scan a directory and checks that listener is called.
     */
    @Test
    public void filesAreScanned()
        throws Exception
    {
        Listener listener = mock( Listener.class );

        File dir = new File( "src/test/data" );

        Scanner scanner = createScanner();
        scanner.scan( dir, listener );

        verify( listener ).onBegin();
        verify( listener ).onEnterDirectory( dir );
        verify( listener ).onFile( new File( dir, "file1" ) );
        verify( listener ).onExitDirectory( dir );
        verify( listener ).onEnterDirectory( new File( dir, "dir1" ) );
        verify( listener ).onExitDirectory( new File( dir, "dir1" ) );
        verify( listener ).onFile( new File( dir, "dir1/file11" ) );
        verify( listener ).onFile( new File( dir, "dir1/file12" ) );
        verify( listener ).onEnterDirectory( new File( dir, "dir2" ) );
        verify( listener ).onExitDirectory( new File( dir, "dir2" ) );
        verify( listener ).onEnd();
    }

    /**
     * Checks that onEnter/onExit directory are not called for an inexistent file.
     */
    @Test
    public void onEnterAndOnExitAreNotCalledForInexistingDir()
        throws Exception
    {
        Listener listener = mock( Listener.class );

        File dir = new File( "src/test/fake" );

        Scanner scanner = createScanner();
        scanner.scan( dir, listener );

        verify( listener ).onBegin();
        verify( listener, never() ).onEnterDirectory( Matchers.any( File.class ) );
        verify( listener, never() ).onFile( Matchers.any( File.class ) );
        verify( listener, never() ).onExitDirectory( Matchers.any( File.class ) );
        verify( listener ).onEnd();
    }

    protected abstract Scanner createScanner();

}
