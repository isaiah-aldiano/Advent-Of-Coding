package myDay7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class directory extends file{
	private HashMap<String, file> content = new HashMap<String, file>();
	private Queue<directory> dirs = new LinkedList<directory>();
	private directory parent;
	
	directory(String name, directory parent) {
		super(name, 0);
		this.parent = parent;
	}

	public HashMap<String, file> getContent() {
		return content;
	}

	public directory getParent() {
		return parent;
	}
	
	public void addItem(String fileName, file fe) {
		content.put(fileName, fe);
		if (fe instanceof directory) {
			dirs.add((directory) fe);
		}
	}
	
	public long getDirSize() {
		long size = 0;
		for (String f : content.keySet()) {
			
			if (content.get(f) instanceof directory) {
				size += ((directory) content.get(f)).getDirSize();
			} else if (content.get(f) instanceof file) {
				size += content.get(f).getSize();
			} 
		}
		return size;
	}
	
	public directory getNextDir(String dir) {
		return (directory) content.get(dir);
	}
	
}
