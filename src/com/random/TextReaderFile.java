package com.random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReaderFile {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\Personal\\workspace\\2018SessionPreparation\\src\\com\\random\\fiels.txt"))) {
		  
		  String st; 
		  while ((st = br.readLine()) != null) 
		    System.out.println(st); 
		  } 
	}
	}
