package algo_09_20195138;

public class Queue {
	private int front; 
	private int back; 
	private int[] data; 
	private final static int MAX = 100;
	
	public Queue() {
		data = new int[MAX]; 
		front = back = 0;
	}
	
	public int size() { 
		if (back >= front) {
			return (back - front); 
		}
		else {
			return (MAX + back - front);
		}
	}
	
	public boolean isEmpty() {
		return (front == back);
	}
	
	public void enqueue(int x) {
		back = (back + 1) % MAX; 
		if (back == front) {
		}
		data[back] = x;
	}
	
	public int dequeue() {
		front = (front + 1) % MAX;
		return data[front];
	}
	
	public int front() {
		return data[(front + 1) % MAX];
	}
}