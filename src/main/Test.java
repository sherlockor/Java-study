package main;

import java.io.IOException;



import file.FileOperator;

public class Test {
	public static void main(String[] args) throws IOException {
		String path = "E:\\MyCode\\Java\\111";
		
		FileOperator file_operator = new FileOperator();
		file_operator.Delete(path);
	}
}
