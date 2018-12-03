package main;

import file.FileOperator;

public class Test {
	public static void main(String[] args) {
		String path = "C:/Users/Administrator/Desktop/打印机文件备份";
		
		FileOperator file_operator = new FileOperator();
		file_operator.TraverseFolder(path);
	}
}
