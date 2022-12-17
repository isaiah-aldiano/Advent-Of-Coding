package myDay7;

public class file {
	private String name;
	private long size;
	
	file(String name, long size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public long getSize() {
		return size;
	}
}
