package calorieCounting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		ArrayList<Integer> Inventories = new ArrayList<Integer>();
		
		try {
			String line;
			int cals = 0;
			BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/calorieCounting/snacks.txt"));
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0) {
					cals += Integer.parseInt(line);
				} else if (line.length() <= 0) {
					Inventories.add(cals);
					cals = 0;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int temp = Integer.MIN_VALUE;
		int index = 0;
		for (int invs : Inventories) {
			if (invs > temp) {
				temp = invs;
				index = Inventories.indexOf(temp);
			}
		}
		System.out.println(index + " " + temp);
	}
}
