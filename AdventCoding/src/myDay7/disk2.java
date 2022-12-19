package myDay7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import usefulshti.dataparser;

public class disk2 {

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
		
		long spaceLeft = 70_000_000 - allDir.get(0).getDirSize();
		
		long spaceNeeded = 30_000_000 - spaceLeft;
		
		System.out.println(spaceNeeded);
		
		long temp = Integer.MAX_VALUE;
		directory tempDir = null;
		for (int i = 0; i < allDir.size(); i++) {
			long tempDirSize = allDir.get(i).getDirSize();
			if ( tempDirSize < temp && tempDirSize > spaceNeeded) {
				tempDir = allDir.get(i);
				temp = tempDir.getDirSize();
			}
		}
		
//		ArrayList<directory> tempDir = new ArrayList<directory>();
//		
//		for (int i = 0; i < allDir.size(); i++) {
//			if (allDir.get(i).getDirSize() > spaceNeeded) {
//				System.out.println(allDir.get(i).getName() + " " + allDir.get(i).getDirSize());
//				tempDir.add(allDir.get(i));
//			}
//		}
		
		
		
		System.out.println(tempDir.getDirSize());
	}
}
