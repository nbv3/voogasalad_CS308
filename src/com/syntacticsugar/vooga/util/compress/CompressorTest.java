package com.syntacticsugar.vooga.util.compress;

import java.io.File;
import java.nio.file.Files;

public class CompressorTest {
	public static void main(String args[]) {

		File selectedFile = new File("src/com/syntacticsugar/vooga/util/compress/Untitled.xml");
		
		String inputString = readFile(selectedFile);
		System.out.printf("%30s: %8d\n", "Input string size", inputString.length());
		String compressed = Compressor.compress(inputString);
		System.out.printf("%30s: %8d\n", "Compressed string size", compressed.length());
		String uncompressed = Compressor.decompress(compressed);
		System.out.printf("%30s: %8d\n", "Uncompressed string size", uncompressed.length());
		System.out.printf("%30s: %8b\n", "Equal", inputString.equals(uncompressed));
	}

	private static String readFile(File f) {
		try {
			byte[] inputBytes = Files.readAllBytes(f.toPath());
			return new String(inputBytes);
		} catch (Exception e) {

		}
		return "";
	}
}
