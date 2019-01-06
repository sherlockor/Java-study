package file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileOperator {
	//创建文件夹
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
	//删除
	public void Delete(String path) {
		File file = new File(path);
		if(!file.exists()) {
			System.out.printf("[%s] is not exist", path);
			return;
		}
		
		if(file.isFile()) {
			file.delete();
		} else if (file.isDirectory()) {
			File[] all_file = file.listFiles();
			for(File current_file : all_file) {
				Delete(current_file.getAbsolutePath());
			}
			/*for(int index = 0; index < all_file.length; index++) {
				File current_file = all_file[index];
				Delete(current_file.getAbsolutePath());
			}*/
		}
		file.delete();
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
	public void ReadFileContent(String file_name) {
		File file = new File(file_name);
		if(!file.exists()) {
			System.out.printf("[%s] is not exist", file_name);
			return;
		}
		if(!file.isFile()) {
			System.out.printf("[%s] is not file", file_name);
			return;
		}
		
		try {
			FileReader file_reader = new FileReader(file);
			BufferedReader buffered_reader = new BufferedReader(file_reader);
			
			String line_content = null;
			do {
				line_content = buffered_reader.readLine();
				if (line_content != null) {
					System.out.println(line_content);
				}
			} while (line_content != null);
			
			buffered_reader.close();
			file_reader.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//写文件
	public void WriteFileContent(String file_name, String write_content) {
		try {
			File file = new File(file_name);
			FileWriter file_writer = new FileWriter(file, true);//true表示追加
			BufferedWriter buffered_writer = new BufferedWriter(file_writer);
			PrintWriter out = new PrintWriter(buffered_writer);
			
			out.append(write_content);
			out.println();
			out.flush();//刷新缓存流，将数据立即写入，而不是等到缓存存满了再写入
			out.close();
			System.out.println("Finish write.");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	//console输入
	public void ConsoleInput() {
		System.out.println("Please put in:");
		Scanner scanner = new Scanner(System.in);
		
		String input_str = null;
		do {
			input_str = scanner.nextLine();
			if(input_str != null) {
				System.out.println(input_str);
				if (input_str.equals("end")) {
					break;
				}
			} 
		} while (input_str != null);
		System.out.println("Console end.");
	}

}
