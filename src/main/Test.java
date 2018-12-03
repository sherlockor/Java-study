package main;

import java.io.IOException;

import file.FileOperator;

public class Test {
	public static void main(String[] args) throws IOException {
		String path = "E:/Note/README.md";
		
		FileOperator file_operator = new FileOperator();
		file_operator.ReadFileContent(path);
	}
}
