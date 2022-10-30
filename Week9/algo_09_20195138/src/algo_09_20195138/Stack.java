package algo_09_20195138;

public class Stack {
	private int top;
	private int[] data;
	private final static int MAX = 100;
	
	public Stack() {
		data = new int[MAX]; 
		top = -1;
	}
	
	public int size() { 
		return top + 1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void push(int x) {
		top = top + 1; 
		data[top] = x;
	}
	
	public int pop() {
		top = top -1;
		return data[top+1];
	}
	
	public int peek() {
		return data[top];
	}
}