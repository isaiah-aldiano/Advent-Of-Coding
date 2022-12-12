package day4;

import java.io.IOException;
import java.util.ArrayList;

import usefulshti.dataparser;

public class cleanup2 {

	public static void main(String[] args) {
		dataparser sections = new dataparser("/src/day4/sections.txt");
		String line;
		int count = 0;
		
		try {
			while ((line = sections.getdata().readLine()) != null) {
				String[] lineArray;
				ArrayList<String> elf1 = new ArrayList<String>();
				ArrayList<String> elf2 = new ArrayList<String>();
				int A, B, C, D, dash1, dash2;
				lineArray = line.split(",");
				dash1 = lineArray[0].indexOf("-");
				dash2 = lineArray[1].indexOf("-");
				A = Integer.parseInt(lineArray[0].substring(0, dash1));
				B = Integer.parseInt(lineArray[0].substring(dash1 + 1));
				C = Integer.parseInt(lineArray[1].substring(0, dash2));
				D = Integer.parseInt(lineArray[1].substring(dash2 + 1));
								
				for (int i = A; i <= B; i++) {
					elf1.add(Integer.toString(i));
				}
				
				for (int j = C; j <= D; j++) {
					elf2.add(Integer.toString(j));
				}
				
				int k;
				boolean doesContain = false;
				if (elf1.size() <= elf2.size()) {
					for (k = 0; k < elf1.size(); k++) {
						if (elf2.contains(elf1.get(k))) {
							doesContain = true;
						}
					}
				} else if (elf2.size() < elf1.size()) {
					for (k = 0; k < elf2.size(); k++) {
						if (elf1.contains(elf2.get(k))) {
							doesContain = true;
						}
					}
				}
				
				if (doesContain) {
					count++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
}
