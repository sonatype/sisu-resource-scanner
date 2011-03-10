package org.sonatype.sisu.scanner.scanners;

import org.sonatype.sisu.resource.scanner.Scanner;
import org.sonatype.sisu.resource.scanner.scanners.SerialScanner;

public class SerialScannerTest
    extends AbstractScannerTest
{

    protected Scanner createScanner()
    {
        return new SerialScanner();
    }

}
