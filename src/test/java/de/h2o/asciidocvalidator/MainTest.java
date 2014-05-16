package de.h2o.asciidocvalidator;

import org.junit.Test;

public class MainTest {

	// @Test
	// public void theTestNameIsLoggedSuccessfully() {
	// log("theTestNameIsLoggedSuccessfully"); // TODO create this method, replace all other occurences, linie 1 zeichen länger als überschrift
	// assertTrue(true);
	// }

	/**
	 * this method shows some info about each test on the terminal
	 * 
	 * @param testName
	 */
	private void log(String testName) {
		System.out.println("==> TEST '" + testName + "' started");
		for (int i = 0; i < testName.length() + 20; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	@Test
	public void mainMethodIsSuccessfulIfFileNameIsPassed() throws Exception {
		log("IsSuccessfulIfFileNameIsPassed");
		Main.main(new String[] { "tmp/foo.txt" });
	}

	@Test
	public void mainMethodIsSuccessfulIfFileNameAndOtherThingsArePassed() throws Exception {
		log("IsSuccessfulIfFileNameAndOtherThingsArePassed");
		Main.main(new String[] { "tmp/x.foo", "-p", "-e", "-r" });
	}

	@Test(expected = IllegalStateException.class)
	public void mainMethodThrowsExceptionIfNoArgumentIsPassed() throws Exception {
		log("ThrowsExceptionIfNoArgumentIsPassed");
		Main.main(new String[] {});
	}

	@Test(expected = IllegalStateException.class)
	public void mainMethodThrowsExceptionThereAreMoreThanOneFileIsPassed() throws Exception {
		log("ThrowsExceptionThereAreMoreThanOneFileIsPassed");
		Main.main(new String[] { "tmp/foo.txt", "tmp/xxx.txt", "tmp/x.foo" });
	}

	@Test(expected = IllegalStateException.class)
	public void mainMethodThrowsExceptionIfNoFileNameIsPassedButOtherArgument() throws Exception {
		log("ThrowsExceptionIfNoFileNameIsPassedButOtherArgument");
		Main.main(new String[] { "-f", "-x", "-i" });
	}

}
