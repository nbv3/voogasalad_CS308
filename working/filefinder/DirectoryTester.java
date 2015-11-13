package filefinder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DirectoryTester {
	public static void main(String args[]) throws IOException {
		Directory d = new Directory("images");
		List<File> allFiles = d.getFiles();
		for (int i=0; i<allFiles.size(); i++) {
			System.out.println(allFiles.get(i));
		}
		//List<String> gd.getFilePathsByExtension(".jpg"));
		System.out.println(d.getFilesByContains("path"));
	}
}
