package model;

public class Array<T> {
    private ALNode<T> first = null;

    public Array() {
    }

    public void add(T t) {
        if (this.first == null) {
            this.first = new ALNode(t);
        } else {
            this.first = this.addValue(t, this.first);
        }

    }

    private ALNode<T> addValue(T t, ALNode<T> current) {
        if (current.getNext() == null) {
            ALNode<T> node = new ALNode(t);
            current.setNext(node);
            current.getNext().setPrev(current);
            return current;
        } else {
            return this.addValue(t, current);
        }
    }

    public void removeAll() {
        if (this.first != null) {
            if (this.first.getNext() == null) {
                this.first = null;
            } else {
                this.first = this.removeNode(this.first);
            }
        }
    }

    private ALNode<T> removeNode(ALNode<T> current) {
        if (current.getNext() != null) {
            ALNode<T> next = current.getNext();
            current = null;
            return this.removeNode(next);
        } else {
            return null;
        }
    }

    public int size() {
        if (this.first != null && this.first.getNext() == null) {
            return 1;
        } else {
            int i = 2;
            return this.first != null ? this.count(this.first.getNext(), i) : 0;
        }
    }

    private int count(ALNode<T> current, int i) {
        if (current != null) {
            return current.getNext() == null ? i : this.count(current.getNext(), i + 1);
        } else {
            return 0;
        }
    }

    public T get(int pos) {
        if (this.first != null) {
            return pos == 0 ? this.first.getT() : this.getElement(this.first.getNext(), pos, 1);
        } else {
            return null;
        }
    }

    private T getElement(ALNode<T> current, int pos, int i) {
        if (current != null) {
            return pos == i ? current.getT() : this.getElement(current.getNext(), pos, i + 1);
        } else {
            return null;
        }
    }

    public String toString() {
        String line = "[";
        if (this.first != null) {
            line = line + this.first;
            ALNode<T> current = this.first.getNext();
            boolean canContinue = true;

            while (canContinue) {
                if (current != null) {
                    line = line + ", " + current;
                    current = current.getNext();
                } else {
                    canContinue = false;
                }
            }
        }

        line = line + "]";
        return line;
    }

    public static class ALNode<T> {
        private T t;
        private ALNode<T> next;
        private ALNode<T> prev;

        public ALNode(T t) {
            this.t = t;
            this.next = null;
            this.prev = null;
        }

        public T getT() {
            return this.t;
        }

        public ALNode<T> getNext() {
            return this.next;
        }

        public ALNode<T> getPrev() {
            return this.prev;
        }

        public void setT(T t) {
            this.t = t;
        }

        public void setNext(ALNode<T> next) {
            this.next = next;
        }

        public void setPrev(ALNode<T> prev) {
            this.prev = prev;
        }

        public String toString() {
            return this.t.toString();
        }
    }
}