package com.syntacticsugar.vooga.util.compress;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

import org.xerial.snappy.Snappy;

public class Compressor {

	public static void compressTest(File selectedFile) {
		try {
			if (selectedFile != null) {
				byte[] inputBytes = Files.readAllBytes(selectedFile.toPath());
				System.out.println("Input size: "+inputBytes.length);
				byte[] compressed = Snappy.compress(inputBytes);
		
				
				
				System.out.println("Output size: "+compressed.length);
				//byte[] uncompressed = Snappy.uncompress(compressed);
				//String result = new String(uncompressed, "UTF-8");
				// System.out.println(result);
				
				Arrays.equals(inputBytes, outputBytes);
			}


			//byte[] uncompressed = Snappy.uncompress(compressed);
			//String result = new String(uncompressed, "UTF-8");
			// System.out.println(result);
		} catch (Exception e) {

		}
	}

}
