package myDay7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import usefulshti.dataparser;

public class disk {

	public static void main(String[] args) throws IOException {
		dataparser input = new dataparser("/src/myDay7/files.txt");
		String line;
		long sum = 0;
		
		ArrayList<directory> allDir = new ArrayList<directory>();
		
		directory rootDir = new directory("/", null);
		directory workingDir = rootDir;
		
		while((line = input.getdata().readLine()) != null) {
			String[] splitLine = line.split(" ");
//			System.out.println(line + "          " + Arrays.toString(splitLine));
			
			if ("$".equals(splitLine[0])) {
				if ("cd".equals(splitLine[1])) {
					if ("/".equals(splitLine[2])) {
						workingDir = rootDir;
						allDir.add(workingDir);
					} else if ("..".equals(splitLine[2])) {
						workingDir = workingDir.getParent();
					} else {
						workingDir = workingDir.getNextDir(splitLine[2]);
						allDir.add(workingDir);
					}
				}
			} else {
				if ("dir".equals(splitLine[0])) {
					directory newDir = new directory(splitLine[1], workingDir);
					workingDir.addItem(splitLine[1], newDir);
				} else {
					file newFile = new file(splitLine[1], Long.parseLong(splitLine[0]));
					workingDir.addItem(splitLine[1], newFile);
					
				}
			}
		}
		
		for (int i = 0; i < allDir.size(); i++) {
			 HashMap<String, file> temp = allDir.get(i).getContent();
			 for (String s : temp.keySet()) {
				 if (temp.get(s) instanceof directory) {
					 long temp2 = ((directory) temp.get(s)).getDirSize();
					 System.out.println(s + " " + ((directory) temp.get(s)).getDirSize());	 
					 if (temp2 <= 100_000) {
						 sum += temp2;
					 }
				 }
			 }
		}
		
		
		System.out.println(sum);
	}
}
