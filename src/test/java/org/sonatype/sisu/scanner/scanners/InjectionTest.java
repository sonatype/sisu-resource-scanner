package org.sonatype.sisu.scanner.scanners;

import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;

import org.sonatype.sisu.litmus.testsupport.inject.InjectedTestSupport;
import org.sonatype.sisu.resource.scanner.Scanner;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class InjectionTest
    extends InjectedTestSupport
{

  @Inject
  @Named("fairness")
  private Scanner fairnessScanner;

  @Inject
  @Named("parallel")
  private Scanner parallelScanner;

  @Inject
  @Named("serial")
  private Scanner serialScanner;

  @Override
  public void configure(final Properties properties) {
    properties.setProperty("sisu.scanner.fairness.threads", "1");
    properties.setProperty("sisu.scanner.fairness.installmentSize", "1");

    properties.setProperty("scanner.parallel.threads", "1");
  }

  @Test
  public void testScannersAreInjected() throws Exception {
    assertThat("Fairness scanner", fairnessScanner, is(notNullValue()));
    assertThat("Parallel scanner", parallelScanner, is(notNullValue()));
    assertThat("Serial scanner", serialScanner, is(notNullValue()));
  }

}
