package com.syntacticsugar.vooga.util.compress;

import org.xerial.snappy.Snappy;

public class Compressor {

	public static void compressTest() {
		try {
			String input = "Hello snappy-java! Snappy-java is a JNI-based wrapper of "
					+ "Snappy, a fast compresser/decompresser.";
			System.out.println(input);
			
			byte[] compressed = Snappy.compress(input.getBytes("UTF-8"));
			System.out.println(new String(compressed, "UTF-8"));
			
			byte[] uncompressed = Snappy.uncompress(compressed);
			String result = new String(uncompressed, "UTF-8");
			System.out.println(result);
		} catch (Exception e) {

		}
	}

}
