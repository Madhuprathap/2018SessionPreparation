package com.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FolderRead {
	public static void main(String[] args) throws IOException {
		System.out.println(UUID.randomUUID().toString());
		
		List<String> filenames = new ArrayList<>();
		
		try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("./com/random");
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String resource;

            while ((resource = br.readLine()) != null) {
                filenames.add(resource);
                System.out.println(resource);
            }
        }
        System.out.println(filenames.size());
	}
}
