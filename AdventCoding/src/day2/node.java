package day2;

public class node {
	private char W;
	private char L;
	private char T;
	node(char win, char loss, char tie) {
		W = win;
		L = loss;
		T = tie;
	}
	public char getW() {
		return W;
	}
	public char getL() {
		return L;
	}
	public char getT() {
		return T;
	}
}
