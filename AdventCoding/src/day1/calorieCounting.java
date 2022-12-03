package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class calorieCounting {

	public static void main(String[] args) {
		ArrayList<Integer> invs = new ArrayList<Integer>();
		int maxCals = 0, index = 0;
		try {
			String line;
			int temp = 0;
			BufferedReader data = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/day1/inventories.txt"));
			while ((line = data.readLine()) != null) {
				if (line.length() > 0) {
					temp += Integer.parseInt(line);
				} else if (line.length() <= 0) {
					invs.add(temp);
					temp = 0;
				}
			}
			
//			for (int cals : invs) {
//				if (cals > maxCals) {
//					maxCals = cals;
//					index = invs.indexOf(cals);
//				}
//			}
			invs.sort(null);
			
			for (int j = invs.size() - 1; j > invs.size() - 4; j--) {
				maxCals += invs.get(j);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(maxCals + " " + index);
		System.out.println(maxCals);
	}

}
