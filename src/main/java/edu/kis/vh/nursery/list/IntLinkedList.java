package edu.kis.vh.nursery.list;

public class IntLinkedList {

    private static class Node {

        private final int value;
        private Node prev;
        private Node next;

        public Node(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node last;
    private int i;

    /**
     * Metoda isEmpty() sprawdza czy lista jest pusta.
     *
     * @return true, jeżeli lista jest pusta, w przeciwnym wypadku false.
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * Metoda isFull() sprawdza czy lista jest pełna.
     *
     * @return false, ponieważ lista nie ma określonego limitu elementów wewnątrz niej.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Metoda top() zwraca wartość z ostatniego węzła na liście.
     *
     * @return wartość z ostatniego węzła, jeżeli lista nie jest pusta, w przeciwnym wypadku -1.
     */
    public int top() {
        if (isEmpty()) return -1;
        return last.getValue();
    }

    /**
     * Metoda pop() usuwa i zwraca wartość z ostatniego węzła na liście.
     *
     * @return wartość z ostatniego węzła, jeżeli lista nie jest pusta, w przeciwnym wypadku -1.
     */
    public int pop() {
        if (isEmpty()) return -1;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }

    //    Dodatkowa metoda do dodawania elementów

    /**
     * Metoda push(value) dodaje nowy węzeł z podaną wartością na koniec listy.
     *
     * @param value wartość, która ma zostać nadana w nowo-powstałym elemencie listy.
     */
    public void push(int value) {
        if (isEmpty()) last = new Node(value);
        else last.setPrev(new Node(value));
    }
}
