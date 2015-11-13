package filefinder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DirectoryTester {
	public static void main(String args[]) throws IOException {
		Directory d = new Directory("working/resources/tiles", 0);
		List<File> allFiles = d.getFiles();
		print(allFiles);

		List<File> pngFiles = d.getFilesByExtension(".png");
		print(pngFiles);

		List<File> pngFiles2 = d.getFilesByExtension("png");
		print(pngFiles2);

		List<String> allFilePaths = d.getFilePaths();
		printPaths(allFilePaths);

		List<String> pngFilePaths = d.getFilePathsByExtension(".png");
		printPaths(pngFilePaths);

		List<String> pngFilePaths2 = d.getFilePathsByExtension("png");
		printPaths(pngFilePaths2);
	}

	private static void print(List<File> list) {
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}

	private static void printPaths(List<String> list) {
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}
}
