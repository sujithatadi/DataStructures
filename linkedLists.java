package linkedlist;


import java.util.Scanner;

class LinkedList{
	
	static node head;
	
	static class node{
		
		int data;node next;
		
		node(int d){
			data=d;
			next=null;
		}
	}
	public node reverse(node head) {
		
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
		return head;
	}
	
	public node reverseGroup(node head,int k) {
		node prev=null;
		node current=head;
		node next=null;
		int count=0;
		while(current!=null && count<k) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		
		
		if(next!=null) {
			head.next=reverseGroup(next,k);
		}
		
		return prev;
	}
	
	public void insert(int ele) {
		
		if(head==null) {
			head=new node(ele);
			
		}
		else {
				node n=head;
				while(n.next!=null) {
					n=n.next;
				}
				n.next=new node(ele);
		}
		
    }
	
	public node getMiddle(){
		
		node small=head;
		node large=head;
		
		if(head!=null) {
			
			while(large!=null && large.next!=null) {
				large=large.next.next;
				small=small.next;
			}
		}
		
		return small;
	}
	
	public boolean detectLoop() {
		node small=head;
		node large=head;
		
		if(head!=null) {
			
			while(large!=null && large.next!=null) {
				large=large.next.next;
				small=small.next;
				if(large==small)
					return true;
			}
		}
		/*to get the starting point of the loop node
		 	small=head;
		 	while(small!=large){
		 		small=small.next;
		 		large=large.next;
		 	}
		 	small is the starting node of loop
		 */
		return false;
	}
	
	public boolean Palindrome() {
		node middle=getMiddle();node first=head;
		node second=middle.next;
		middle.next=null;
		node revSecond=reverse(second);
		while(head!=null && revSecond!=null) {
			if(head.data!=revSecond.data) {
				head=first;
				middle.next=reverse(second);
				return false;
			}
			head=head.next;
			revSecond=revSecond.next;
		}
		head=first;
		middle.next=reverse(second);
		return true;

	}
	
	public void endNth(int n) {
		node a=head;node b=head;
		int c=0;
		if(head!=null) {
			while(c<n) {
				if(b==null) {
					System.out.println("insufficient nodes");
					return;
				}
				b=b.next;c++;
			}
			while(b!=null){
				a=a.next;
				b=b.next;
			}
			System.out.println(n+"th element from end is"+a.data);
		}
	}
    public void print(){
    	
       node n=head;
       
        while (n!= null) { 
        	
            System.out.print(n.data + " "); 
            n = n.next; 
        } 
    }
}
public  class linkedLists{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		Scanner sc=new Scanner(System.in);int ch;int ele,k;
		
		do {
			
			System.out.println("Enter 1.insert 2.reverse 3.display 4.reverse with k nodes 5.getMiddle 6.detectLoop 7.endNth 8.exit");
			ch=sc.nextInt();
			switch(ch) {
			
				case 1:System.out.println("enter the element to be inserted:");
						ele=sc.nextInt();  
						ll.insert(ele); 
						break;
						
				case 2:ll.reverse(ll.head);
						System.out.print("Reversed list:");
						ll.print();
						System.out.println();
						break;
						
				case 3:ll.print();System.out.println();
						break;
						
				case 4:System.out.println("enter k:");
						k=sc.nextInt();
						ll.head=ll.reverseGroup(ll.head,k);
						ll.print();
						break;
						
				case 5:System.out.println("middle element:"+ll.getMiddle().data);
						break;
						
				case 6:if(ll.detectLoop())
					  		System.out.println("Loop is present");
					   else
						   System.out.println("Loop is not present");
						
					 break;
					 
				case 7:System.out.println("enter n from the end:");
						k=sc.nextInt();
						ll.endNth(k);
						break;
						
				case 8:if(ll.Palindrome()) {
							System.out.println("Yes! It is a Palindrome");
						}
						else
							System.out.println("No! It is not a Palindrome");
						break;
						
				case 9:break;
			}
			
		}while(ch!=9);

	}

}
