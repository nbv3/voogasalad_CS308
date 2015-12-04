package com.syntacticsugar.vooga.util.compress;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Arrays;

import org.xerial.snappy.Snappy;

public class Compressor {

	public static void compressTest(File selectedFile) {
		try {
			if (selectedFile != null) {
				byte[] inputBytes = Files.readAllBytes(selectedFile.toPath());
				System.out.println("Input size: " + inputBytes.length);
				byte[] compressed = Snappy.compress(inputBytes);

				System.out.println("Output size: " + compressed.length);
				byte[] uncompressed = Snappy.uncompress(compressed);

				System.out.println("Are equal: " + Arrays.equals(inputBytes, uncompressed));
			}

		} catch (Exception e) {

		}
	}
	
	public static byte[] compress(String input) {
		try {
			byte[] compressed = Snappy.compress(input.getBytes("UTF-8"));
			return compressed;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[0];
	}
	
	public static String uncompress(byte[] input) {
		try {
			System.out.println(input.length);
			byte[] uncompressed = Snappy.uncompress(input);
			return new String(uncompressed, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
