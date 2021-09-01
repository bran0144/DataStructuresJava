public class BasicStack <X> {
    private X [] data;

    public BasicStack() {
        data = (X[]) new Object[1000];

    }
}


// Stacks are LIFO (last in first out)
// Push (place data on top of stack) O(1)
// Pop (take data from top of stack) O(1)
// Search  O(n) (linear performance)
// Access O(n)
