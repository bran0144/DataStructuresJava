package dataStructures;

public class BasicQueue<X> {
    private X[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(1000);
    }

    public BasicQueue(int size) {
        this.front = -1;
        this.end = -1;
        data = (X[])new Object[size];
    }

    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    public void enQueue(X item) {
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("Queue is full");
        } else if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        } else {
            end++;
            data[end] = item;
        }
    }

    public X deQueue() {
        X item = null;
        if (size() == 0) {
            throw new IllegalArgumentException("Queue is empty");
        } else if (front == end) {
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(X item) {
        boolean present = false;
        if (size() == 0) {
            return present;
        }
        for (int i = front; i < end; i++) {
            if (data[i].equals(item)) {
                present = true;
                break;
            }
        }
        return present;
    }

    public X access(int position) {
        if (size() == 0) {
            throw new IllegalArgumentException("Queue is empty");
        } else if (position > size()) {
            throw new IllegalArgumentException("Position does not exist in Queue");
        } else {
            int trueIndex = 0;
            for (int i = front; i < end; i++) {
                if (trueIndex == position) {
                    return data[i];
                }
                trueIndex++;
            }
            throw new IllegalArgumentException("Could not get item at position");
        }

    }
}

//FIFO - ordered line or sequence
//enQueue O(1)
//deQueue O(1)
//Search O(n)
//Access O(n)

//TODO: Create Queue Interface & implement
//TODO: Try using an ArrayList instead of array (ListQueue)
//TODO: Change Snowbird app code to use interface and ListQueue
