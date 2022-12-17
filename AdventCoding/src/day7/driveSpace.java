package day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import usefulshti.dataparser;

/*
 * $ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
 */


//Find all directories with file sizes of <= 100,000 
//Directories that hold directories add the file size to their own

public class driveSpace {

	public static void main(String[] args) {
		dataparser files = new dataparser("/src/day7/files.txt");
		String line, input = "";
		try {
			while((line = files.getdata().readLine()) != null) {
				input += line + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(input);
		String[] cmd = input.split("\n");
		
		
		
		
		
		
		dir rootDir = new dir("/", null);
		dir workingDir = rootDir;
		ArrayList<dir> allDirectories = new ArrayList<dir>();
		
		for (String s : cmd) {
			String[] lineCmd = s.split(" ");
//			System.out.println(Arrays.toString(lineCmd));
			
			
			if (lineCmd[0].contains("$")) {
				if ("cd".equals(lineCmd[1])) {
					if ("/".equals(lineCmd[2])) {
						workingDir = rootDir;
					} else if ("..".equals(lineCmd[2])) {
						workingDir = workingDir.getParent();
					} else {
						workingDir = workingDir.getDir(lineCmd[1]);
					}
				} 
			} else if (lineCmd[0].contains("dir")) {
				dir newDir = new dir(lineCmd[1], workingDir);
				workingDir.addItem(lineCmd[1], newDir);
				allDirectories.add(newDir);
			} else {
			}
		}
	}
}
