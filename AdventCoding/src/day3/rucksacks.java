package day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import usefulshti.dataparser;

public class rucksacks {
	
	

	public static void main(String[] args) {
		
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		List<char[]> alphaList = Arrays.asList(alphabet);
		
		List<String> alphaList = Arrays.asList(alphabet.split(""));
		
		
		
		dataparser sacks = new dataparser("/src/day3/allSacks.txt");
		String line, comp1, comp2;
		int lineSize, total = 0;
		String item;
		
		try {
			while((line = sacks.getdata().readLine()) != null) {
				lineSize = line.length();
				comp1 = line.substring(0, lineSize/2);
				comp2 = line.substring(lineSize/2, lineSize);
				
				List<String> comp1List = Arrays.asList(comp1.split(""));
				List<String> comp2List = Arrays.asList(comp2.split(""));
				
				for (int i = 0; i < comp1.length(); i++) {
					if (comp2List.contains(comp1List.get(i))) {
						item = comp1List.get(i);
						System.out.println(alphaList.indexOf(item) + " " + alphaList.get(alphaList.indexOf(item)));
						total += alphaList.indexOf(item) + 1;
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(total);
			
	}

}
