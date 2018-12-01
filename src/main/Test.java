package main;

import java.io.File;
import java.io.FileInputStream;

public class Test {
	public static void main(String[] args) {
		String pathname = "C:/Users/sherlock/Desktop/11.txt";
		File file = new File(pathname);
		try {
			FileInputStream file_stream = new FileInputStream(file);
			byte[] all = new byte[(int)file.length()];
			file_stream.read(all);
			for(int index = 0; index < all.length; index++) {
				System.out.print(all[index]);
			}
			file_stream.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("File is not exist");
			e.printStackTrace();
		}
	}
}
