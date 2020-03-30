package linkedlist;

import java.util.Scanner;

class node{
	int data;node next;
	node(int d){
		data=d;
		next=null;
	}
}

public class SumOfLinkedLists {
	node head;
	
	public void insert(node n) {
		if(head==null) {
			head=n;
		}
		else {
			node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
	void print() {
		node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
			
		}
		
	}
	
	public void reverse() {
		
		node prev=null;
		node current=head;
		node next=null;
		
		while(current!=null) {
			
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			
		}
		
		head=prev;
		
	}
	
	public node sumList(node l1,node l2) {
		int carry=0;
		node newHead=null;
		node tempNodeForIteration=null;
		int sum=0,first=0;
		while(l1!=null || l2!=null) {
			first++;
			sum=carry;
			if(l1!=null) {
				sum=sum+l1.data;
				l1=l1.next;
			}
			if(l2!=null) {
				sum=sum+l2.data;
				l2=l2.next;
			}
			carry=sum/10;
			sum=sum%10;
			if(first==1) {
				tempNodeForIteration=new node(sum);
				newHead=tempNodeForIteration;	
			}
			else {
				node tempSumNode=new node(sum);
				tempNodeForIteration.next=tempSumNode;
				tempNodeForIteration=tempNodeForIteration.next;
				
			}
		}
		if(carry!=0) {
			node tempSumNode=new node(carry);
			tempNodeForIteration.next=tempSumNode;
			
		}
		return newHead;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch,ele,c;
		Scanner sc=new Scanner(System.in);
		SumOfLinkedLists l1=new SumOfLinkedLists();
		SumOfLinkedLists l2=new SumOfLinkedLists();
		do {
			
			System.out.println("enter 1.insert 2.display 3.sumOflinkedLists 4.exit");
			ch=sc.nextInt();
			switch(ch) {
				case 1:System.out.println("enter the list number:");
						c=sc.nextInt();
						if(c==1) {
							System.out.println("enter the element to be inserted:");
							ele=sc.nextInt();
							l1.insert(new node(ele));
						}
						else if(c==2) {
							System.out.println("enter the element to be inserted:");
							ele=sc.nextInt();
							l2.insert(new node(ele));
						}
						else
							System.out.println("not valid");
						break;
						
				case 2:System.out.println("enter the list number:");
						c=sc.nextInt();
						if(c==1) {
							l1.print();
						}
						else if(c==2) {
							l2.print();
						}
						else
							System.out.println("not valid");
						break;
				case 3:SumOfLinkedLists ll=new SumOfLinkedLists();
						l1.reverse();l2.reverse();
						ll.head=ll.sumList(l1.head,l2.head);
						ll.reverse();l1.reverse();l2.reverse();
						System.out.println("sum:");ll.print();
						break;
						
				case 4:break;
				
				}
			}while(ch!=4);
		

	}

}
