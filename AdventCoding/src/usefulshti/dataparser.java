package usefulshti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dataparser {
	private BufferedReader data;
	
	public dataparser(String file) {
		try {
			data = new BufferedReader(new FileReader(System.getProperty("user.dir") + file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedReader getdata() {
		return data;
	}
	
//	try {
//		BufferedReader data = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/day2/StratGuide.txt"));
//		while ((line = data.readLine()) != null) {
//			elf = line.charAt(0); //Elf character
//			end = line.charAt(2); //Round character
//			score += compMoves(elf, end);
//		}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
