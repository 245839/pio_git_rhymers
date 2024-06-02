package edu.kis.vh.nursery;

import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Wszystkie testy poniżej przeszły pomyślnie
public class RhymersJUnitTest {

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    private IntLinkedList list;

    @Before
    public void setUp() {
        list = new IntLinkedList();
    }

    @Test
    public void testIsEmptyInitially() {
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyAfterAddingNodes() {
        list.push(1);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyAfterPoppingAllNodes() {
        list.push(1);
        list.pop();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testTopWhenEmpty() {
        Assert.assertEquals(-1, list.top());
    }

    @Test
    public void testTopAfterPoppingNodes() {
        list.push(1);
        list.push(2);
        list.pop();
        Assert.assertEquals(2, list.top());
    }

    @Test
    public void testPopWhenEmpty() {
        Assert.assertEquals(-1, list.pop());
    }

    @Test
    public void testPopAfterAddingNodes() {
        list.push(1);
        Assert.assertEquals(1, list.pop());
    }

    @Test
    public void testPopAfterPoppingAllNodes() {
        list.push(1);
        list.push(2);
        list.pop();
        list.pop();
        Assert.assertEquals(-1, list.pop());
    }
}
