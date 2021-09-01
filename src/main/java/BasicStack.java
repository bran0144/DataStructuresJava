public class BasicStack <X> {
    private X[] data;
    private int pointer;

    public BasicStack() {
        data = (X[]) new Object[1000];
        pointer = 0;
    }

    public void push(X newItem) {
        data[pointer++] = newItem;
    }

    public X pop() {
        if (pointer == 0) {
            throw new IllegalStateException("no more items in stack");
        }
        return data[--pointer];
    }

    public boolean contains(X item) {
        boolean found = false;
        for (int i = 0; i < pointer; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(X item) {
        while (pointer > 0) {
            X tempItem = pop();
            if (item.equals(tempItem)) {
                return tempItem;
            }
        }
        throw new IllegalArgumentException("Could not find item in stack");
    }
    public int size() {
        return pointer;
    }
}



// Stacks are LIFO (last in first out)
// Push (place data on top of stack) O(1)
// Pop (take data from top of stack) O(1)
// Search  O(n) (linear performance)
// Access O(n)
