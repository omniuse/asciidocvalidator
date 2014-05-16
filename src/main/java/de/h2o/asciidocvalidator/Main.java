package de.h2o.asciidocvalidator;

public class Main {

	// public static void main(String[] args) {
	// IFileHandler fileHandler;
	//
	// if (fileHandler.getNumberOfLines() >= 5) {
	// fileHandler.getNthLine(5);
	// }
	//
	// }

	/**
	 * -r recursive<br>
	 * -p parent<br>
	 * -f force<br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		AsciidocValidatorTerminalParameter terminal = new AsciidocValidatorTerminalParameter(args);
		if (terminal.isRecursiveEnabled()) {
			System.out.println("do it recursive");
		}

		// terminal.verifyFileType(); // not necessary, because will be checked in getFile()

		FileHandler fileHandler = new FileHandler(terminal.getFile());

		String content = fileHandler.getFileContent();

		System.out.println("===============");
		System.out.println(content);

	}
}
