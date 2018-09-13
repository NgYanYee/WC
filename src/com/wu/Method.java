package com.wu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Method {
	public static void charCount(String filePath) {
		int count = 0;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
			BufferedReader bReader = new BufferedReader(isr);
			while(bReader.read()!= -1) {
				String string = bReader.readLine();
				count += string.length();
			}
			isr.close();
			System.out.println("char count: " + count);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void wordCount(String filePath) {
		int count = 0;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
			BufferedReader bReader = new BufferedReader(isr);
			while(bReader.read()!= -1) {
				String string = bReader.readLine();
				count += string.split(" ").length;
			}
			isr.close();
			System.out.println("word count: " + count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void lineCount(String filePath) {
		int count = 0;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
			BufferedReader bReader = new BufferedReader(isr);
			while(bReader.read()!= -1) {
				String string = bReader.readLine();
				count++;
			}
			isr.close();
			System.out.println("line count: " + count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
