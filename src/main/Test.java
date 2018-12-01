package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		String pathname = "C:/Users/Administrator/Desktop/11.txt";
		File file = new File(pathname);
		new FileInputStream(file);
	}
}
