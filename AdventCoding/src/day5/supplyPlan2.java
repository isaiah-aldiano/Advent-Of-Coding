package day5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

import usefulshti.dataparser;

public class supplyPlan2 {

	public static void main(String[] args) {
		dataparser supplyPlan = new dataparser("/src/day5/supplyPlan.txt");
		HashMap<Integer, ArrayList<Character>> shipping = new HashMap<Integer, ArrayList<Character>>();
		String line;
		
		try {
			while((line = supplyPlan.getdata().readLine()) != null) {
				if (!line.contains("move")) {
					line = line.replaceAll("\\[|\\]", " ");
					line = line.replaceAll("\s\s\s", " ");
					line = line.trim();
					for (int i = 0; i < line.length(); i += 2) {
						if (line.charAt(i) == ' ' || Character.isDigit(line.charAt(i))) {
							continue;
						} else if (shipping.containsKey(i)) {
							shipping.get(i).add(line.charAt(i));
						} else {
							ArrayList<Character> newQueue = new ArrayList<Character>();
							newQueue.add(line.charAt(i));
							shipping.put(i, newQueue);
						}
					}
				} else {
					int move, from, to;
					char temp;
					line = line.replaceAll("\\D", " ");
					line = line.replaceAll("\\s+", " ");
					line = line.trim();
					String[] orders = line.split(" ");
					Stack<Character> crane9001 = new Stack<Character>();
//					System.out.println(Arrays.toString(orders));
					
					move = Integer.parseInt(orders[0]);
					from = Integer.parseInt(orders[1]);
					to = Integer.parseInt(orders[2]);
					
					from = (from - 1) * 2;
					to = (to -1) * 2;
					
					for (int j = 0; j < move; j++) {
						temp = shipping.get(from).remove(0);
						crane9001.push(temp);
					}
					
					for (int k = 0; k < move; k++) {
						temp = crane9001.pop();
						shipping.get(to).add(0, temp);
					}
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i : shipping.keySet()) {
			System.out.println(i / 2 + 1 + " " + shipping.get(i));
		}
		
//		GGNPJBTTR
	}
}
