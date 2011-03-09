package org.sonatype.sisu.scanner.scanners;

import org.sonatype.sisu.scanner.Scanner;

public class SerialScannerTest
    extends AbstractScannerTest
{

    protected Scanner createScanner()
    {
        return new SerialScanner();
    }

}
