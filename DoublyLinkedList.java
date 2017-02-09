// Doubly-link by Jacob Zimmerman
public class DoublyLinkedList {
	Node head;
	Node tail;
	int size = 0;
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	public void add(Object newThing) {
		Node newNode = new Node();
		newNode.data = newThing;
		newNode.next = null;
		size++;
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail; //new previous pointing to old tail
			tail.next = newNode; //old tail
			tail = newNode;      // this node becomes new tail
			}
	}
	public Object get(int i) throws LocationOutOfBounds {
		if (i < 0 || i > size) {
			throw new LocationOutOfBounds();
		}
		Node traverse = head;
		for (int j = 0; j < i; j++) {
			traverse = traverse.next;
		}
		return traverse.data;
	}
	public int size() {
		int size = 0;
		Node traverse = head;
		while (traverse != null) {
			size++;
			traverse = traverse.next;
		}
		return size;
	}
	public void insert(int i, Object itemToInsert) throws LocationOutOfBounds {
		if (i < 0 || i > size) {
			throw new LocationOutOfBounds();
		}
		Node traverse = new Node();
		Node insertionNode = new Node();
		insertionNode.data = itemToInsert;
		size++;
		if (i == 0) {
			traverse = head;
			insertionNode.next = traverse;
			head = insertionNode;
			traverse.prev = head;
		} else if (i == 1) {
			traverse = head;
			insertionNode.next = traverse.next;
			traverse.next = insertionNode;
			insertionNode.next.prev = insertionNode;
			insertionNode.prev = head;
		} else {
			traverse = head;
			for (int j = 0; j < i-2; j++) {
				traverse = traverse.next;
		}
			insertionNode.next = traverse.next.next;
			insertionNode.prev = traverse.next;
			traverse.next.next = insertionNode;
		}
	}
	public void delete(int i) throws LocationOutOfBounds {
		if (i < 0 || i > size) {
			throw new LocationOutOfBounds();
		}
		Node traverse = head;
		size--;
		for (int j = 0; j < i-1; j++) {
			traverse = traverse.next;
		}
		traverse.next.next.prev = traverse;
		traverse.next = traverse.next.next;
	}
	public void set(int i, Object itemToSet) throws LocationOutOfBounds {
		if (i < 0 || i > size) {
			throw new LocationOutOfBounds();
		}
		Node runner = head;
		for (int j = 0; j < i; j++) {
			runner = runner.next;
		}
		runner.data = itemToSet;
	}
	public void print() {
		Node traverse = head;
		while (traverse != null) {
			System.out.println(traverse.data);
			traverse = traverse.next;
		}
	}
    public void traverse() {
        System.out.println("** Starting traverse ***");
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            System.out.println(i + ": " +tmp.data);
            i++;
            tmp = tmp.next;
        }

        System.out.println("** going back ***");
        tmp = tail;
        i = size()-1;
        while (tmp != null) {
            System.out.println(i + ": " +tmp.data);
            i--;
            tmp = tmp.prev;
        } 
        System.out.println("** traverse done ***");
        System.out.println();
    }
}
