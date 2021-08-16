public class DoublyLinkedList {
	public class Node {
		int item;

		Node previous;
		Node next;

		public Node(int item) {
			this.item = item;
		}
	}

	private Node head = null;
	private Node tail = null;

	public void addNode(int item) {
		Node newNode = new Node(item);

		if(head == null) {
			head = newNode;
			tail = newNode;

			head.previous = null;
			tail.next = null;
		
		} else {
			tail.next = newNode;
			newNode.previous = tail;
			
			tail = newNode;
			tail.next = null;
		}
	}

	public void insertNode(int newNode, int leftBound, int rightBound) {
		Node temp = head;	

		while (temp.next != null) {
			if (temp.item == leftBound && temp.next.item == rightBound) {
				Node node = new Node(newNode);
				node.previous = temp;
				node.next = temp.next;

				return;
			}  

			temp = temp.next;
		}
	}

	public String toString() {
		Node temp = head;
		String text;

		text = "[null, (" + temp.item + "), " + temp.next.item + "], ";
		temp = temp.next;

		while(temp.next != null) {
			text += "[" + temp.previous.item + ", (" + temp.item + "), " + temp.next.item + "], ";
			temp = temp.next;
		}

		text += "[" + temp.previous.item + ", (" + temp.item +  "), null]"; 
		return text;
	}

}
