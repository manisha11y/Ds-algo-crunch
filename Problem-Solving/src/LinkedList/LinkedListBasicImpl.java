package LinkedList;

public class LinkedListBasicImpl {

	Node head = null;
	
	public void insert(int value) {
		if(head == null)
			head = new Node(value);
		else {
			Node ptr = head;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = new Node(value);
		}
	}
	
	public void insertAtBegining(int value) {
		if(head == null)
			head = new Node(value);
		else {
			Node newNode = new Node(value);
			newNode.next = head;
			head = newNode;
		}
	}
	
	 public void removeDuplicatesFromLinkedList(Node linkedList) {
		    Node ptr = linkedList;
		    Node ptr2 = linkedList.next;
				while(ptr != null && ptr2 != null){
				 if(ptr.value == ptr2.value){
					  ptr.next =  ptr2.next;
					  ptr2 = ptr2.next;
				 }	
					if (ptr2 != null) {
						ptr = ptr2;
						ptr2 = ptr2.next;
					}

				}
		    head = linkedList;
		  }
	 
	
	public void traverse(Node head) {
		while(head != null) {
			System.out.print(head.value + " -> ");
			head = head.next;
		
		}
		
	}
	
	
	public static void main(String[] args) {
		LinkedListBasicImpl ll = new LinkedListBasicImpl();
		ll.insert(1);
		ll.insert(1);
		ll.insert(3);
		ll.insert(4);
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);
		
//		ll.insertAtBegining(90);
		ll.removeDuplicatesFromLinkedList(ll.head);
		
		
		ll.traverse(ll.head);
		
		

	}

}
