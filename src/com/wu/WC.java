package com.wu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.File;

import sun.management.counter.Variability;
import sun.security.util.Length;

public class WC {
	public static void main(String[] args) throws IOException {
		while(true) {
			System.out.println("\n--------------------3216005169 WC程序----------------------");
	        System.out.println("                                                           ");
	        System.out.println("            -c [文件路径]  返回文件字符数                  ");
	        System.out.println("            -w [文件路径]  返回文件词的数目                ");
	        System.out.println("            -l [文件路径]  返回文件行数                    ");
	        System.out.println("            -s [文件夹路径]  搜索文件名/.文件后缀        ");
	        System.out.println("            -a [文件路径]  统计代码行/空行/注释行          ");
	        System.out.println("                                                           ");
	        System.out.println("        例：-c -w E:/filename.txt  得到文件字符数和词数                     ");
	        System.out.println("        -s -c -w E:/fileFolder filename/.filetype                     ");
	        System.out.println("-------------------------------------------------------------");
	        
	        System.out.println("请输入命令： ");
	        Scanner command = new Scanner(System.in);
	        String commandList[] = command.nextLine().split("\\s");
	        
	        boolean hasSArg = Arrays.asList(commandList).stream().anyMatch(s -> s.equals("-s"));
	        if(hasSArg) {
//	        	System.out.println("含有s");
	        	String pathname = commandList[commandList.length - 2];
	        	String fileFilter = commandList[commandList.length - 1];
	        	List<String> paths = new ArrayList<String>();
	        	paths = getAllFilePaths(new File(pathname), paths, fileFilter);
	        	if(paths != null) {
	        		for(int i = 0; i < paths.size(); i++) {
	            		operation(paths.get(i), commandList);
	            	}
	        	}
	        	
	        } else {
//	        	System.out.println("不含有s");
	        	operation(commandList[commandList.length - 1], commandList);
	        }
		}

        
	}
	
	public static void operation(String filePath, String arr[]) {
		System.out.println("\n");
		System.out.println("filePath is :" + filePath);
		for(int i = 0; i < arr.length - 1; i++) {
//			System.out.println(arr[i]);
			switch (arr[i]) {
			case "-c":
				Method.charCount(filePath);
				break;
			case "-w":
				Method.wordCount(filePath);
				break;
			case "-l":
				Method.lineCount(filePath);
				break;
			case "-a":
				Method.codeCount(filePath);
				break;
			default:
				break;
			}
		}
        
	}
	
	private static List<String> getAllFilePaths(File basePath,List<String> filePaths,String fileFilter){	
		File[] files = basePath.listFiles();
		if(files == null) {
			System.out.println("该目录下无文件,请检查命令格式");
			return filePaths;
		}
		for(File f:files) {
			if(f.isDirectory()) {
//				找到文件夹，继续寻找下一目录
				getAllFilePaths(f, filePaths, fileFilter);
			} else {
				if((f.getName() == fileFilter) || f.getName().endsWith(fileFilter)) {
					//找到匹配文件，添加到路径数组
					filePaths.add(f.getPath());
				}
			}
		}
		return filePaths;
	}
	
}
