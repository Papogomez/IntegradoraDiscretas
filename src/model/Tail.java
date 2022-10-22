package model;


public class Tail<Q> {
    private QNode<Q> head = null;

    public Tail() {
    }

    public void add(Q q) {
        QNode<Q> tail = new QNode(q);
        if (this.head == null) {
            this.head = tail;
        } else {
            this.add(this.head, tail);
        }

    }

    private void add(QNode<Q> current, QNode<Q> tail) {
        if (current != null) {
            if (current.getNext() == null) {
                current.setNext(tail);
                tail.setPrev(current);
            } else {
                this.add(current.getNext(), tail);
            }
        }

    }

    public Q element() {
        return this.head != null ? this.head.getQ() : null;
    }

    public QNode<Q> getHead() {
        return this.head;
    }

    public void setHead(QNode<Q> head) {
        this.head = head;
    }

    public static class QNode<Q> {
        private Q q;
        private QNode<Q> next;
        private QNode<Q> prev;

        public QNode(Q q) {
            this.q = q;
            this.next = null;
            this.prev = null;
        }

        public Q getQ() {
            return this.q;
        }

        public QNode<Q> getNext() {
            return this.next;
        }

        public QNode<Q> getPrev() {
            return this.prev;
        }

        public void setQ(Q q) {
            this.q = q;
        }

        public void setNext(QNode<Q> next) {
            this.next = next;
        }

        public void setPrev(QNode<Q> prev) {
            this.prev = prev;
        }
    }
}