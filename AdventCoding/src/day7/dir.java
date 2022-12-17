package day7;

import java.util.ArrayList;
import java.util.HashMap;

public class dir extends file{
	private dir parent;
	private HashMap<String, file> content = new HashMap<String, file>();
	
	dir(String Name, dir Parent) {
		super(Name, 0);
		parent = Parent;
	}
	
	public dir getParent() {
		return parent;
	}

	public void setParent(dir parent) {
		this.parent = parent;
	}
	
	public dir getDir(String dirName) {
		return (dir) content.get(dirName);
	}
	
	public void addItem(String fileName, file fe) {
		content.put(fileName, fe);
	}
	
	public long size() {
		long count = 0;
		for (String fe : content.keySet()) {
			count += content.get(fe).getSize();
		}
		return count;
	}
	
	
}
