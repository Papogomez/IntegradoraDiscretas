package model;


public class HashMap<K, V> {
    private HMNode<K, V> first = null;

    public HashMap() {
    }

    public HMNode<K, V> getFirst() {
        return this.first;
    }

    public void put(K key, V value) {
        HMNode<K, V> newNode = new HMNode(key, value);
        if (this.first == null) {
            this.first = newNode;
        } else if (!this.containsKey(key) && !this.containsValue(value)) {
            this.assignPosition(newNode, this.first);
        }

    }

    private void assignPosition(HMNode<K, V> newNode, HMNode<K, V> current) {
        if (current.getNext() == null) {
            current.setNext(newNode);
            current.getNext().setPrev(current);
        } else {
            this.assignPosition(newNode, current.getNext());
        }

    }

    public V get(K key) {
        return this.first.getKey() == key ? this.first.getValue() : this.findValueByKey(key, this.first);
    }

    private V findValueByKey(K key, HMNode<K, V> current) {
        if (current != null) {
            return current.getKey() == key ? current.getValue() : this.findValueByKey(key, current.getNext());
        } else {
            return null;
        }
    }

    public boolean containsKey(K key) {
        if (this.first != null) {
            return this.first.getKey().equals(key) ? true : this.findIfKeyExists(key, this.first.getNext());
        } else {
            return false;
        }
    }

    private boolean findIfKeyExists(K key, HMNode<K, V> current) {
        if (current != null) {
            return current.getKey().equals(key) ? true : this.findIfKeyExists(key, current.getNext());
        } else {
            return false;
        }
    }

    public boolean containsValue(V value) {
        if (this.first != null) {
            return this.first.getValue() == value ? true : this.findIfValueExists(value, this.first.getNext());
        } else {
            return false;
        }
    }

    private boolean findIfValueExists(V value, HMNode<K, V> current) {
        if (current != null) {
            return current.getValue().equals(value) ? true : this.findIfValueExists(value, current.getNext());
        } else {
            return false;
        }
    }

    public void replace(K key, V value) {
        if (this.containsKey(key)) {
            if (this.first.getKey().equals(key)) {
                this.first.setValue(value);
            } else {
                this.findKeyOfValue(key, value, this.first.getNext());
            }
        }

    }

    private void findKeyOfValue(K key, V value, HMNode<K, V> current) {
        if (current.getKey().equals(key)) {
            current.setValue(value);
        } else {
            this.findKeyOfValue(key, value, current.getNext());
        }

    }

    public int size() {
        return this.count(this.first, 0);
    }

    private int count(HMNode<K, V> current, int count) {
        return current != null ? this.count(current.getNext(), count + 1) : count;
    }

    public String toString() {
        String line = "{";

        for (HMNode<K, V> current = this.first; current != null; current = current.getNext()) {
            line = line + current.toString();
            if (current.getNext() != null) {
                line = line + ", ";
            }
        }

        line = line + "}";
        return line;
    }
    public void setFirst(HMNode<K, V> first) {
        this.first = first;
    }


    public static class HMNode<K, V> {
        private K key;
        private V value;
        private HMNode<K, V> next;
        private HMNode<K, V> prev;

        public HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public HMNode<K, V> getNext() {
            return this.next;
        }

        public HMNode<K, V> getPrev() {
            return this.prev;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(HMNode<K, V> next) {
            this.next = next;
        }

        public void setPrev(HMNode<K, V> prev) {
            this.prev = prev;
        }

        public String nextAndPrev() {
            return "Next=" + this.next + ", Prev=" + this.prev;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}