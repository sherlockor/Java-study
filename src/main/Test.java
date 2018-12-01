package main;

import java.io.File;
import java.io.FileInputStream;

public class Test {
	public static void main(String[] args) {
		String pathname = "C:/Users/Administrator/Desktop/11.txt";
		File file = new File(pathname);
		try {
			FileInputStream file_stream = new FileInputStream(file);
			byte[] all = new byte[(int)file.length()];
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
