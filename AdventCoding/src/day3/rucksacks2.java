package day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import usefulshti.dataparser;

public class rucksacks2 {
	public static void main(String[] args) {
		dataparser sacks = new dataparser("/src/day3/allSacks.txt");
		
		String line, comp1, comp2;
		int lineSize, total = 0;
		String item;
		
		ArrayList<List<String>> groupBags = new ArrayList<List<String>>();
		int groups = 0, sack1 = 1, sack2 = 2;
		
		
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";		
		List<String> alphaList = Arrays.asList(alphabet.split(""));
		
		try {
			while((line = sacks.getdata().readLine()) != null) {
//				lineSize = line.length();
//				comp1 = line.substring(0, lineSize/2);
//				comp2 = line.substring(lineSize/2, lineSize);
//				
//				List<String> comp1List = Arrays.asList(comp1.split(""));
//				List<String> comp2List = Arrays.asList(comp2.split(""));
//				
//				for (int i = 0; i < comp1.length(); i++) {
//					if (comp2List.contains(comp1List.get(i))) {
//						item = comp1List.get(i);
//						System.out.println(alphaList.indexOf(item) + " " + alphaList.get(alphaList.indexOf(item)));
//						total += alphaList.indexOf(item) + 1;
//						break;
//					}
//				}
				
				List<String> sack = Arrays.asList(line.split(""));
				groupBags.add(sack);
				
				if (groupBags.size() == 3) {
					groupBags.sort(Comparator.comparing(List<String>::size));
					List<String> sack0 = groupBags.get(0);
//					for (List<String> elfSack : groupBags) {
//						System.out.println(elfSack.toString());
//					}
					
					for (int i = 0; i < groupBags.get(0).size(); i++) {
						if (groupBags.get(sack1).contains(sack0.get(i)) == true && groupBags.get(sack2).contains(sack0.get(i)) == true) {
							String badge = sack0.get(i);
							total += alphaList.indexOf(badge) + 1;
							break;
						}
					}
					groupBags.clear();
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(total);
			
	}

}
