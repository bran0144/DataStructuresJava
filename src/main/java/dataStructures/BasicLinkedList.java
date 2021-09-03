package dataStructures;

public class BasicLinkedList <X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }
    public void add(X item) {
        if(first == null) {
            first = new Node(item);
            last = first;
        }
        else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount ++;
    }
    public void insert(X item, int position) {
        if(size() < position) {
            throw new IllegalStateException("Linked list is too short, cannot insert");
        }
        Node currentNode = first;
        for(int i=1; i<position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }
        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }
    public X removeAt(int position) {
        if(first == null) {
            throw new IllegalStateException("Linked list is empty");
        }
        Node currentNode = first;
        Node previousNode = last;
        for(int i=1; i<position && currentNode != null; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        X nodeItem = currentNode.getNodeItem();
        previousNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }
    public X remove() {
        if(first == null) {
            throw new IllegalArgumentException("Linked List is empty");
        }
        else {
            X nodeItem = first.getNodeItem();
            first = first.getNextNode();
            nodeCount--;
            return nodeItem;
        }
    }
    public X get(int position) {
        if(first == null) {
            throw new IllegalStateException("Linked list is empty");
        }
        Node currentNode = first;
        for(int i = 1; i< size() && currentNode !=null; i++) {
            if( i == position) {
                return currentNode.getNodeItem();
            }
            else {
                currentNode = currentNode.getNextNode();
            }
        }
        return null;
    }
    public int find(X item) {
        if(first == null) {
            throw new IllegalStateException("Linked list is empty");
        }
        Node currentNode = first;
        for(int i = 1; i < size() && currentNode != null; i ++) {
            if(currentNode.getNodeItem().equals(item)) {
                return i;
            }
            else{
                currentNode = currentNode.getNextNode();
            }
        }
        return -1;
    }
    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node curNode = first;
        while(curNode != null) {
            contents.append(curNode.getNodeItem());
            curNode = curNode.getNextNode();
            if(curNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }
    public int size() {
        return nodeCount;
    }
    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item) {
            this.nextNode = null;
            this.nodeItem = item;
        }
        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
        public Node getNextNode() {
            return nextNode;
        }
        public X getNodeItem() {
            return nodeItem;
        }
    }


}

//IN/OUT - anything goes (can be LIFO, FIFO, or in the middle)
//Duplicates are okay
//add O(1)
//remove O(1)
// insert O(n)
// removeAT O(n)
// find O(n)
// get O(n)

//TODO: Create a timer for linked list
//TODO: Use ArrayList instead of linkedlist and compare times
//TODO: find = indexOf

