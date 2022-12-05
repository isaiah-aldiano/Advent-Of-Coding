package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RocPapSic {

	static HashMap<Character, Integer> vals = new HashMap<Character, Integer>();
	static HashMap<Character, node> nodeList = new HashMap<Character, node>();
	

	/*
	 * A, X- rock
	 * B, Y - Paper 
	 * C, Z - Scissors
	 * 
	 * win - 6
	 * tie - 3
	 * loss - 0
	 * 
	 * pt 2 
	 * 
	 * A - rock
	 * B - Paper 
	 * C - Scissors
	 * 
	 * X - loose 0
	 * Y - draw 3
	 * Z - win 6
	 */
	public static int compMoves(char elf, char end) {
		int tempRes = 0;
//		int yourHand = vals.get(you);
//		int turnVal = vals.get(end);
		
	
//		System.out.println(vals.get(nodeList.get(elf).getL()));

//		System.out.println(elf + " " + end);
		
//		switch (tempRes) {
//		case -2:
//		case 1:
//			return yourHand;
//		case 0:
//			return yourHand + 3;
//		case -1:
//		case 2:
//			return yourHand + 6;
//		}
//		return 0;
		
		
		switch (end) {
		case 'X': 
			tempRes = vals.get(nodeList.get(elf).getW());
			break;
		case 'Y':
			tempRes = vals.get(nodeList.get(elf).getT());
			break;
		case 'Z':
			tempRes = vals.get(nodeList.get(elf).getL());
			break;
		}
		return tempRes + vals.get(end);
	}
	
	public static void main(String[] args) {
		String line;
		char elf, end;
		int score = 0;
		
		node A = new node ('C', 'B', 'A');
		node B = new node ('A', 'C', 'B');
		node C = new node ('B', 'A', 'C');
		
		nodeList.put('A', A);
		nodeList.put('B', B);
		nodeList.put('C', C);
		
		
		vals.put('A', 1);
		vals.put('B', 2);
		vals.put('C', 3);
		vals.put('X', 0);
		vals.put('Y', 3);
		vals.put('Z', 6);
		
		try {
			BufferedReader data = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/day2/StratGuide.txt"));
			while ((line = data.readLine()) != null) {
				elf = line.charAt(0); //Elf character
				end = line.charAt(2); //Round character
				score += compMoves(elf, end);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(score);

	}
}
