package file;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class FileOperator {
	//常见文件夹
	public boolean CreateFolder(String folder_path, boolean is_absolute) {
		File file = new File(folder_path);
		if (file.isFile()) {
			return false;
		}
		if(file.exists()) {
			return true;
		}
		boolean b_status = false;
		if(is_absolute) {
			b_status = file.mkdirs();
		} else {
			b_status = file.mkdir();
		}
		return b_status;
	}
	//遍历文件夹
	public void TraverseFolder(String folder) {
		File file = new File(folder);
		if (!file.exists()) {
			System.out.println("Folder is not exist.");
			return;
		} else if(!file.isDirectory()) {
			System.out.println("Path is not directory.");
			return;
		}
		
		
		File[] all_files = file.listFiles();
		for(int index = 0; index < all_files.length; index++) {
			File current_file = all_files[index];
			if (current_file.isFile()) {	//是否文件
				System.out.println(current_file.getAbsolutePath());
			} else if (current_file.isDirectory()) {	//是目录
				TraverseFolder(current_file.getAbsolutePath());
			}
		}
	}
	//读文件
	public void ReadFileContent(String file_name) throws IOException {
		File file = new File(file_name);
		if(!file.exists()) {
			System.out.printf("[%s] is not exist", file_name);
			return;
		}
		if(!file.isFile()) {
			System.out.printf("[%s] is not file", file_name);
			return;
		}
		BufferedReader buffered_reader = (new InputStreamReader(new FileInputStream(file), "gbk")); 
		String line_content = null;
		do {
			line_content = buffered_reader.readLine();
			System.out.println(line_content);
		} while(line_content.length() != 0);
	}
}
