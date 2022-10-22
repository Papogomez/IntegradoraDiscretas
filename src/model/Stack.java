package model;

public class Stack<S> {
    private SNode<S> head = null;

    public Stack() {
    }

    public SNode<S> peek() {
        return this.head != null ? this.head : null;
    }

    public S pop() {
        if (this.head != null) {
            SNode<S> aux = this.head;
            this.head = this.head.getNext();
            return aux.getS();
        } else {
            return null;
        }
    }

    public void push(S s) {
        if (this.head == null) {
            this.head = new SNode(s);
        } else {
            SNode<S> aux = this.head;
            SNode<S> newNode = new SNode(s);
            this.head = newNode;
            this.head.setNext(aux);
            aux.setPrev(this.head);
        }

    }

    public int size() {
        if (this.head == null) {
            return 0;
        } else if (this.head.getNext() == null) {
            return 1;
        } else {
            int i = 2;
            return this.count(this.head.getNext(), i);
        }
    }

    private int count(SNode<S> current, int i) {
        if (current != null) {
            return current.getNext() == null ? i : this.count(current.getNext(), i + 1);
        } else {
            return 0;
        }
    }

    public String toString() {
        String line = "[";
        if (this.head != null) {
            line = line + this.head.toString();
            SNode<S> current = this.head.getNext();
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

    public SNode<S> getHead() {
        return this.head;
    }

    public void setFirst(SNode<S> head) {
        this.head = head;
    }


    public static class SNode<S> {
        private S s;
        private SNode<S> next;
        private SNode<S> prev;

        public SNode(S s) {
            this.s = s;
            this.next = null;
            this.prev = null;
        }

        public S getS() {
            return this.s;
        }

        public SNode<S> getNext() {
            return this.next;
        }

        public SNode<S> getPrev() {
            return this.prev;
        }

        public void setS(S s) {
            this.s = s;
        }

        public void setNext(SNode<S> next) {
            this.next = next;
        }

        public void setPrev(SNode<S> prev) {
            this.prev = prev;
        }

        public String toString() {
            return this.s.toString();
        }
    }
}