package de.h2o.asciidocvalidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHandler {
	private File file;

	public FileHandler(File file) {
		this.file = file;
	}

	/**
	 * this method returns the whole content of the file
	 * 
	 * @return String
	 */
	public String getFileContent() throws Exception {

		if (!file.isFile()) {
			return "not a file!";
		}

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		br.close();
		return sb.toString();
	}

}
