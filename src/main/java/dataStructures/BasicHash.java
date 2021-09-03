package dataStructures;

public class BasicHash <X, Y> {
    private HashEntry[] data;
    private int capacity;
    private int size;

    public BasicHash(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    public Y get(X key) {
        int hash = calculateHash(key);
        if(data[hash] == null) {
            return null;
        }
        else {
            return (Y)data[hash].getValue();
        }
    }

    public void put(X key, Y value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry<X, Y>(key, value);
        size++;
    }
    public int size() {
        return this.size;
    }

    private int calculateHash(X key) {
        int hash = (key.hashCode() % this.capacity);
        while (data[hash] != null && !data[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    private class HashEntry<X, Y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }
        public void setKey(X key) {
            this.key = key;
        }
        public Y getValue() {
            return value;
        }
        public void setValue(Y value) {
            this.value = value;
        }
    }
}

//No order (no indexing)
//Not, LIFO, FIFO
//Creates a map of key-values
//Keys are unique (using a hashcode)
//hashCode() method lets you make a unique hashCode
//

