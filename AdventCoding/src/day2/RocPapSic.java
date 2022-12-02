package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RocPapSic {

	static HashMap<Character, Integer> vals = new HashMap<Character, Integer>();
	

	/*
	 * A, X- rock
	 * B, Y - Paper 
	 * C, Z - Scissors
	 * 
	 * win - 6
	 * tie - 3
	 * loss - 0
	 */
	public static int compMoves(char elf, char you) {
		int tempRes = vals.get(elf) - vals.get(you);
		int yourHand = vals.get(you);
		System.out.println(elf + " - " + you + " = " + tempRes);
		
		switch (tempRes) {
		case -2:
		case 1:
			return yourHand;
		case 0:
			return yourHand + 3;
		case -1:
		case 2:
			return yourHand + 6;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String line;
		char elf, you;
		int score = 0;
		
		vals.put('A', 1);
		vals.put('B', 2);
		vals.put('C', 3);
		vals.put('X', 1);
		vals.put('Y', 2);
		vals.put('Z', 3);
		
		try {
			BufferedReader data = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/day2/StratGuide.txt"));
			while ((line = data.readLine()) != null) {
				elf = line.charAt(0); //Elf character
				you = line.charAt(2); //Your character
				score += compMoves(elf, you);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(score);

	}
	
	

}
