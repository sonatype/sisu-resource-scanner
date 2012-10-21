package org.sonatype.sisu.scanner.scanners;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.sonatype.sisu.resource.scanner.Scanner;
import org.sonatype.sisu.resource.scanner.scanners.ParallelScanner;

public class ParallelScannerTest
    extends AbstractScannerTest
{

    protected Scanner createScanner()
    {
        return new ParallelScanner( 2 );
    }

    @Test
    public void parallelisationStrategyNever()
    {
        assertThat( ParallelScanner.NEVER.shouldScanInParallel( util.getBaseDir() ), is( false ) );
    }

    @Test
    public void parallelisationStrategyEveryDirectory()
    {
        assertThat( ParallelScanner.EVERY_DIRECTORY.shouldScanInParallel( util.getBaseDir() ), is( true ) );
    }

}
