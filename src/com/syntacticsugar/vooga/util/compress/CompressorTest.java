package com.syntacticsugar.vooga.util.compress;

import java.io.File;


public class CompressorTest {
	public static void main(String args[]) {
		
		File selectedFile = new File("src/com/syntacticsugar/vooga/util/compress/Untitled.xml");
		System.out.println(selectedFile.getName());
		System.out.println(selectedFile.length());
		Compressor.compressTest(selectedFile);
	}
}
