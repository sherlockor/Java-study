package main;

import java.io.IOException;

import file.FileOperator;

public class Test {
	public static void main(String[] args) throws IOException {
		String path = "C:/Users/Administrator/Desktop/111.txt";
		
		FileOperator file_operator = new FileOperator();
		file_operator.WriteFileContent(path, "22222");
	}
}
