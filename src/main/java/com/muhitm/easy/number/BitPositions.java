package com.muhitm.easy.number;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BitPositions {
	
	private static boolean getBit(int num, int bit) {
		bit--;
		return (num & (1 << bit)) != 0; 
	}
	
	private static boolean compare(String line) {
		List<String> inputs = Arrays.asList(line.split(","));
		return getBit(Integer.parseInt(inputs.get(0)), Integer.parseInt(inputs.get(1))) == 
				getBit(Integer.parseInt(inputs.get(0)), Integer.parseInt(inputs.get(2)));
	}
	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(line.length() > 0)
            	System.out.println(compare(line));
        }
    }
}