package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int NUMBERS_SIZE = 12;
    private static final int MINUS_ONE = -1;
    private static final int NUMBERS_CAPACITY = 11;
    private final int[] numbers = new int[NUMBERS_SIZE];

    public int getTotal() {
        return total;
    }

    private int total = MINUS_ONE;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == MINUS_ONE;
    }

    public boolean isFull() {
        return total == NUMBERS_CAPACITY;
    }

    protected int peekaboo() {
        if (callCheck())
            return MINUS_ONE;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return MINUS_ONE;
        return numbers[total--];
    }

}
