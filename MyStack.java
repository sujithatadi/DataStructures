package linkedlist;

public class MyStack {
	private int size;
	private int top;
	private int [] arr;
	
	
	
	public MyStack(int i) {
		this.size=i;
		this.top=-1;
		this.arr=new int[i];
	}
	public void push(int i) {
		arr[++top]=i;
	}
	public int pop() {
		return arr[top--];
	}
	public boolean isFull() {
		return top==size-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public int peek() {
		return arr[top];
	}
	
	

}
