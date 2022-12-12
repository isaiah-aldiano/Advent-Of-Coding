package day6;

import java.io.IOException;
import java.util.HashMap;

import usefulshti.dataparser;

public class packageDecoder {

	public static void main(String[] args) {
		dataparser comDev = new dataparser("/src/day6/package.txt");
		String line;
		HashMap<Character, Integer> packageStart = new HashMap<Character, Integer>();
		
		try {
			line = comDev.getdata().readLine();
			int a = 0, b = 1, c = 2, d = 3;
			packageStart.put(line.charAt(a), a);
			packageStart.put(line.charAt(b), b);
			packageStart.put(line.charAt(c), c);
			packageStart.put(line.charAt(d), d);
			while (packageStart.size() < 4) {
				packageStart.clear();
				a++;
				b++;
				c++;
				d++;
				packageStart.put(line.charAt(a), a);
				packageStart.put(line.charAt(b), b);
				packageStart.put(line.charAt(c), c);
				packageStart.put(line.charAt(d), d);
			}
			System.out.println(d + 1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
