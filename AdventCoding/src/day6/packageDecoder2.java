package day6;

import java.io.IOException;
import java.util.HashMap;

import usefulshti.dataparser;

public class packageDecoder2 {

	public static void main(String[] args) {
		dataparser comDev = new dataparser("/src/day6/package.txt");
		int marker = 14;
		String line;
		HashMap<Character, Integer> messageStart = new HashMap<Character, Integer>();
		
		try {
			line = comDev.getdata().readLine();
			int parser = 0;
		
			for (int i = parser; i < line.length() - marker; i++) {
				messageStart.clear();
				for (int j = i; j < i + 14; j++) {
					messageStart.put(line.charAt(j), j);
					
				}
				if (messageStart.size() == marker) {
					System.out.println("broke");
					break;
				}
			}
			int ans = 0;
			for (Character c : messageStart.keySet()) {
				if (messageStart.get(c) > ans) {
					ans = messageStart.get(c);
				}
			}
			// Plus 1 because of inclusive counting
			System.out.println(ans + 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
