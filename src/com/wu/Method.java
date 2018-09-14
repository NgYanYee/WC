package com.wu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import sun.management.counter.Variability;

public class Method {
	public static void charCount(String filePath) {
		int count = 0;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf-8");
			BufferedReader bReader = new BufferedReader(isr);
			String string = null;
			while((string = bReader.readLine()) != null) {
				string = string.trim();
				count += string.length();
			}
			isr.close();
			System.out.println("字符数: " + count);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void wordCount(String filePath) {
		int count = 0;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf-8");
			BufferedReader bReader = new BufferedReader(isr);
			boolean blank = true;
			String string = null;
			while((string = bReader.readLine()) != null) {
				string = string.trim();
				for (char c : string.toCharArray()) {
		            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
		                if (blank){
		                    blank = false;
		                    count++;
		                }
		            }else if (
		            	c == '-' && !blank){
		            }else {
		                blank = true;
		            }
		        }
			}
			isr.close();
			System.out.println("词数: " + count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void lineCount(String filePath) {
		int count = 0;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf-8");
			BufferedReader bReader = new BufferedReader(isr);
			while(bReader.read()!= -1) {
				String string = bReader.readLine();
				count++;
			}
			isr.close();
			System.out.println("行数: " + count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void codeCount(String filePath) {
		int code = 0;
		int codeComments = 0;
		int codeBlanks = 0;
		
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
			BufferedReader bReader = new BufferedReader(isr);
			boolean comm = false;
			String s = null;
			while((s = bReader.readLine()) != null) {
				if(s.startsWith("/*") && s.endsWith("*/")) {
					codeComments++;
				} else if(s.trim().startsWith("//")) {
					codeComments++;
				} else if(s.startsWith("/*") && !s.endsWith("*/")) {
					codeComments++;
					comm = true;
				} else if(!s.startsWith("/*") && s.endsWith("*/")) {
					codeComments++;
					comm = false;
				} else if(comm) {
					codeComments++;
				} else if(s.trim().length() < 1) {
					codeBlanks++;
				} else {
					code++;
				}	
			}
			
			isr.close();
			System.out.println("代码行数: " + code);
			System.out.println("注释行数: " + codeComments);
			System.out.println("空行数: " + codeBlanks);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
