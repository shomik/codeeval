package com.muhitm.hard.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Permutations {
	private static String recPermutation(String sofar, String rest, String res) {
		if(rest.length() == 0) {
			res += sofar + ",";
		} else {
			int len = rest.length();
			for(int i = 0; i < len; i++) {
				String next = sofar + rest.charAt(i);
				String remains = rest.substring(0, i) + rest.substring(i + 1);
				res = recPermutation(next, remains, res);
			}
		}
		return res;
	}
	
	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            char[] chars = line.toCharArray();
            Arrays.sort(chars);
            line = new String(chars);
            String res = recPermutation("", line, "");
            int len = res.length();
            if(len > 0) 
            	System.out.println(res.substring(0, len - 1));
        }
    }
}