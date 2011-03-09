package org.sonatype.sisu.scanner.scanners;

import org.sonatype.sisu.scanner.Scanner;

public class ParallelScannerTest
    extends AbstractScannerTest
{

    protected Scanner createScanner()
    {
        return new ParallelScanner( 2 );
    }
    
}
