package de.h2o.asciidocvalidator;

import java.io.File;

/**
 * this class has low level methods for parameters and files
 * 
 * @author omniBook
 * 
 */
public class TerminalParameter {
	protected String[] args;

	// Constructor
	public TerminalParameter(String[] args) {
		this.args = args;
	}

	public boolean hasParameter(String parameter) {
		for (String arg : args) {
			if (parameter.equals(arg)) { // String immer .equals
				return true;
			}
		}
		return false;
	}

	/**
	 * this method evaluates, if there is a parameter (starting with '-') in the argument list
	 * 
	 * @param args
	 *            the args to check
	 * 
	 * @return true, if at least found one parameter, false if not
	 */
	public boolean hasParameter() {
		return getNumberOfParameters() > 0;
	}

	public int getNumberOfParameters() {
		int numberOfParameters = 0;

		for (String arg : args) {
			if (arg.contains("-")) {
				numberOfParameters++;
			}
		}
		return numberOfParameters;

	}

	/**
	 * this method shows the parameters from the argument list which start with -
	 * 
	 * @param args
	 *            the args to check
	 * 
	 * @return void, parameters will be showed with System.out.println
	 */
	public void showParameters() {
		for (String arg : args) {
			if (arg.contains("-")) {
				System.out.println(arg);
			}
		}
	}

	/**
	 * this method counts the number of files from the argument list
	 * 
	 * @param args
	 *            the args to check
	 * 
	 * @return number of files found as int
	 */
	public int getNumberOfFiles() {
		int numberOfFiles = 0;

		for (String arg : args) {
			File file = new File(arg);
			if (file.isFile()) {
				numberOfFiles++;
			}
		}
		return numberOfFiles;
	}

	public String[] getFileNames() {
		String[] fileName = new String[getNumberOfFiles()];
		int i = 0;

		for (String arg : args) {
			File file = new File(arg);
			if (file.isFile()) {
				fileName[i] = arg;
				i++;
			}
		}
		return fileName;
	}

}
