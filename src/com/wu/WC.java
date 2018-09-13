package com.wu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.io.File;

import sun.management.counter.Variability;
import sun.security.util.Length;

public class WC {
	public static void main(String[] args) throws IOException {
		System.out.println("\n----------------------3216005169 WC程序----------------------");
        System.out.println("|                                                           |");
        System.out.println("|                    下方为命令格式参考                         |");
        System.out.println("|            -c [文件路径]  返回文件字符数                  |");
        System.out.println("|            -w [文件路径]  返回文件词的数目                |");
        System.out.println("|            -l [文件路径]  返回文件行数                    |");
        System.out.println("|            -s [文件夹路径]  搜索文件名/*.文件后缀        |");
        System.out.println("|            -a [文件路径]  统计代码行/空行/注释行          |");
        System.out.println("|                                                           |");
        System.out.println("|  例：-c -w E:/filename.txt  得到文件字符数和词数                          |");
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("请输入命令： ");
        Scanner command = new Scanner(System.in);
        String commandList[] = command.nextLine().split("\\s");
        
        boolean hasSArg = Arrays.asList(args).stream().anyMatch(s -> s.equals("-s"));
        if(hasSArg) {
        	String pathname = commandList[commandList.length - 2];
        	String fileFilter = commandList[commandList.length - 1];
        	List<String> paths = new ArrayList<String>();
        	paths = getAllFilePaths(new File(pathname), paths, fileFilter);
        	operation(paths.size(), paths);
        } else {
        	String pathname = commandList[commandList.length - 1];
        	List<String> paths = new ArrayList<String>();
        	paths.add(pathname);
        	operation(1, paths);
        }

        
	}
	
	public static void operation(int len, List<String> paths) {
		if(len == 1) {
			String filepath = paths.get(0);
		} else {
			
		}
		for(int i = 0; i < commandList.length; i++) {
        	switch (commandList[i]) {
			case "-c":
				Method.charCount(pathname);
				break;
			case "-w":
				Method.wordCount(pathname);
				break;
			case "-l":
				Method.lineCount(pathname);
				break;
			
			default:
				break;
			}
        }
	}
	
	private static List<String> getAllFilePaths(File basePath,List<String> filePaths,String fileFilter){	
		File[] files = basePath.listFiles();
		if(files == null) {
			System.out.println("该目录下无文件");
			return filePaths;
		}
		for(File f:files) {
			if(f.isDirectory()) {
				//找到文件夹
				filePaths.add(f.getPath());
				getAllFilePaths(f, filePaths, fileFilter);
			} else {
				if((f.getName() == fileFilter) || f.getName().endsWith(fileFilter)) {
					filePaths.add(f.getPath());
				}
			}
		}
		return filePaths;
	}
	
	public static List<String> get
}
