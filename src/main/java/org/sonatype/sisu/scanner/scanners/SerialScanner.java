/*******************************************************************************
 * Copyright (c) 2010-2011 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * The Apache License v2.0 is available at
 *   http://www.apache.org/licenses/LICENSE-2.0.html
 * You may elect to redistribute this code under either of these licenses.
 *******************************************************************************/
package org.sonatype.sisu.scanner.scanners;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.sisu.scanner.Listener;
import org.sonatype.sisu.scanner.Scanner;

@Named( "serial" )
@Singleton
public class SerialScanner
    implements Scanner
{

    public void scan( File directory, Listener listener )
    {
        if ( listener == null )
        {
            return;
        }
        listener.onBegin();
        recurse( directory, listener );
        listener.onEnd();
    }

    private void recurse( File dir, Listener listener )
    {
        if ( !dir.exists() )
        {
            return;
        }
        listener.onEnterDirectory( dir );
        File[] files = dir.listFiles();
        if ( files != null )
        {
            for ( final File file : files )
            {
                if ( file.isDirectory() )
                {
                    recurse( file, listener );
                }
                else
                {
                    listener.onFile( file );
                }
            }
        }
        listener.onExitDirectory( dir );
    }

}
