package com.muhitm.moderate.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Line implements Comparable<Line> {
	private String text;
	public Line(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	@Override
	public int compareTo(Line o) {
		int len1 = text.length();
		int len2 = o.text.length();
		if(len1 == len2)
			return 0;
		if(len1 > len2)
			return -1;
		return 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
}
public class LongestLines {
	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        List<Line> lines = new ArrayList<>();
        int count = -1;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(count == -1) {
            	count = Integer.parseInt(line);
            	continue;
            }
            if(line.length() > 0) {
            	lines.add(new Line(line));
            }
        }
        Collections.sort(lines);
        for(Line l : lines) {
        	if(count == 0)
        		return;
        	System.out.println(l.getText());
        	count--;
        }
    }
}
