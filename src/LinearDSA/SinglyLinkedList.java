package LinearDSA;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {

	private static ListNode head;

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void print(ListNode head) {
		System.out.print("\n");
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + "---->");
			current = current.next;
		}
		System.out.print("null");
	}

	private int length(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	private void addNodeAtBegining(ListNode newNode) {
		System.out.println("\n....");
		newNode.next = head;
		head = newNode;
	}

	private void addNodeLast(ListNode newNode) {
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		if (current.next == null) {
			current.next = newNode;
			newNode.next = null;
		}
	}

	private void addNodeAtGivenPosition(int position, ListNode newNode) {
		if (position == 1 && head.next == null) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}

			ListNode current = previous.next;
			newNode.next = current;
			previous.next = newNode;

		}
	}

	public ListNode deleteFirst() {
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return head;
	}

	public ListNode deleteLastNode() {
		if (head == null && head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		while (current.next != null) {
			previous = current;
			current = current.next;

		}
		previous.next = null;
		return current;
	}

	public void deleteAtPosition(int position) {
		if (position == 1) {
			head = head.next;
		} else {
			int count = 1;
			ListNode previous = head;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
		}
	}

	public boolean find(int value) {

		ListNode current = head;
		if (head == null) {
			return false;
		}
		while (current != null) {
			if (current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public ListNode middle() {
		ListNode slow = head;
		ListNode first = head;

		while (first != null && first.next != null) {
			slow = slow.next;
			first = first.next.next;
		}
		return slow;
	}

	public ListNode reverse() {
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public void removeDuplicationFromSortedLinkedList() {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}

	public void removeElementByValue(int value) {
		ListNode current = head;
		ListNode temp = null;

		while (current != null && current.next != null) {
			if (current.data != value) {
				temp = current;
				current = current.next;
			} else {
				temp.next = current.next;
				current = current.next.next;
			}
		}
	}

	public void insertNodeInSortedList(ListNode newNode) {
		ListNode previous = null;
		ListNode current = head;
		while (current != null && current.data < newNode.data) {
			previous = current;
			current = current.next;
		}
		newNode.next = current;
		previous.next = newNode;
	}

	public int binaryToDecimal() {

		List<Integer> binList = new ArrayList<>();

		ListNode current = head;
		int i = 0;
		while (current != null) {
			binList.add(current.data);
			current = current.next;
		}

		int dec = 0;
		int k = 0;

		for (int p = binList.size() - 1; p >= 0; p--) {
			dec += binList.get(p) * Math.pow(2, k);
			k++;
		}
		return dec;
	}

	public boolean hasLoop() {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static ListNode mergeTwoSortedLinkedList(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while (list1 != null && list2 != null) {
			if (list1.data <= list2.data) {
				tail.next = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}
		if (list1 == null) {
			tail.next = list2;
		} else {
			tail.next = list1;
		}
		return dummy.next;
	}

	public ListNode addTwoLinkedList(ListNode l1, ListNode l2) {

		int carry = 0;
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int sum = 0;

		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.data : 0;
			int y = (l2 != null) ? l2.data : 0;

			sum = x + y + carry;

			carry = sum / 10;

			tail.next = new ListNode(sum % 10);
			tail = tail.next;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}

		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		SinglyLinkedList sl1 = new SinglyLinkedList();
		sl1.head = new ListNode(1);// 1-next=null

		ListNode second = new ListNode(4);// 2-next=null

		ListNode third = new ListNode(8);

		head.next = second;
		second.next = third;
		third.next = null;

		// ListNode fourth = new ListNode(4);

		// ListNode fifth = new ListNode(5);

		// now connect them all

//		sl.head.next = second;
//		second.next = third;
		// third.next = fourth;
		// fourth.next = fifth;
		// third.next = fifth;
		// fifth.next = null;
		// third.next = null;

		// third.next = null;
		// sl.print(head);

//		ListNode sixth = new ListNode(0);
//		sl.addNodeAtBegining(sixth);
//		sl.print(head);
//
//		ListNode seventh = new ListNode(7);
//		sl.addNodeLast(seventh);
//		sl.print(head);
//
//		ListNode eighth = new ListNode(8);
//		sl.addNodeLast(eighth);
//		sl.print(head);
//
//		ListNode newNode = new ListNode(10);
//		sl.addNodeAtGivenPosition(5, newNode);
//		sl.print(head);
//
//		sl.deleteFirst();
//		sl.print(head);
//
//		sl.deleteLastNode();
//		sl.print(head);
//
//		sl.deleteAtPosition(5);
//		sl.print(head);
//
//		if (sl.find(100)) {
//			System.out.println("\nfound");
//		} else {
//			System.out.println("\nNo data found");
//		}
//
//		ListNode middle = sl.middle();
//		System.out.println("middle node :" + middle.data);
//
//		ListNode head = sl.reverse();
//		sl.print(head);

//		ListNode node1 = new ListNode(2);
//		sl.addNodeAtGivenPosition(3, node1);
//		
//		sl.print(head);
//		
//		ListNode node2 = new ListNode(2);
//		sl.addNodeAtGivenPosition(5, node2);
//		sl.print(head);

//		sl.removeDuplicationFromSortedLinkedList();
//		sl.print(head);

//		sl.removeElementByValue(4);
//		sl.print(head);

//		sl.removeElementByValue(2);
//		sl.print(head);

//		ListNode newNode = new ListNode(4);
//		sl.insertNodeInSortedList(newNode);
//		sl.print(head);

//		int binaryToDecimal = sl.binaryToDecimal();
//		System.out.println(binaryToDecimal);
		sl1.print(head);

		SinglyLinkedList sl2 = new SinglyLinkedList();
		sl2.head = new ListNode(3);
		ListNode ln2 = new ListNode(6);
		sl2.head.next = ln2;
		ln2.next = null;

		sl2.print(sl2.head);

	}
}
