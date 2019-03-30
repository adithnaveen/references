package com.training;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


// to read and write the data to file in single liners 

public class ReadWriteFileEx04 {
	public static void main(String[] args) throws IOException {
        readFileContent();

//		Files.writeString(Path.of("NewSample.txt"), "Welcome Again"); 
	}

	private static void readFileContent() throws IOException {
		var data = Files.readString(Path.of("NewSample.txt"));
		System.out.println(data);
	}
}
