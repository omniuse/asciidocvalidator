package de.h2o.asciidocvalidator;

import java.io.File;

/**
 * this class has methods for verifying parameters and files
 * 
 * @author omniuse
 * 
 */
public class AsciidocValidatorTerminalParameter extends TerminalParameter {

	public AsciidocValidatorTerminalParameter(String[] args) {
		super(args);
	}

	public boolean isRecursiveEnabled() {
		return super.hasParameter("-r");
	}

	public boolean isParentEnabled() {
		return super.hasParameter("-p");
	}

	public boolean isForceEnabled() {
		return super.hasParameter("-f");
	}

	/**
	 * this method evaluates, if given arg is in the argument list
	 * 
	 * @param arg
	 *            the arg to find
	 * 
	 * @return true, if parameter is in the list, false if not
	 */
	public boolean hasParameterNot(String parameter) {
		return !super.hasParameter(parameter);
	}

	/**
	 * this method verifies, if the files from the argument list have the file extension '.txt' or '.adoc'
	 * 
	 * @return void, result will be printed with System.out.println
	 */
	public boolean verifyFileType() {
		for (String arg : args) {
			File file = new File(arg);
			if (file.isFile()) {
				if ((arg.contains(".txt") || arg.contains(".adoc"))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * this method verifies that there is only one file selected and the file format is correct.
	 * 
	 * @return the file, otherwise an error message which states the error reason
	 */
	public File getFile() {

		if (super.getNumberOfFiles() > 1) {
			System.out.println("too many files selected");
			System.out.println();
			return null;
		}
		if (super.getNumberOfFiles() == 0) {
			System.out.println("no file selected");
			System.out.println();
			return null;
		}
		if (!verifyFileType()) {
			System.out.println("file type is wrong\n");
			return null;
		}

		System.out.println("selected file: " + super.getFileNames()[0]);

		File file = new File(super.getFileNames()[0]);
		return file;

	}

}
