package filefinder;

import java.io.IOException;

public class DirectoryTester {
	public static void main(String args[]) throws IOException {
		Directory d = new Directory("images");
		System.out.println(d.getFiles());
	}
}
