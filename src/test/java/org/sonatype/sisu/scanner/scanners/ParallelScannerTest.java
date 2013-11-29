package org.sonatype.sisu.scanner.scanners;

import org.sonatype.sisu.resource.scanner.Scanner;
import org.sonatype.sisu.resource.scanner.scanners.ParallelScanner;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ParallelScannerTest
    extends AbstractScannerTest
{

  protected Scanner createScanner() {
    return new ParallelScanner(2);
  }

  @Test
  public void parallelisationStrategyNever() {
    assertThat(ParallelScanner.NEVER.shouldScanInParallel(util.getBaseDir()), is(false));
  }

  @Test
  public void parallelisationStrategyEveryDirectory() {
    assertThat(ParallelScanner.EVERY_DIRECTORY.shouldScanInParallel(util.getBaseDir()), is(true));
  }

}
