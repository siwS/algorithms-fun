package algos.data_structures;

import org.junit.Test;

import static org.junit.Assert.*;


public class StackTest {

    @Test
    public void testPushAndSize() throws StackFullException {
        Stack stack = new Stack(5);
        stack.push("element-1");
        stack.push("element-2");
        assertEquals(stack.size(), 2);
    }

    @Test
    public void testIsEmpty() throws StackFullException {
        Stack stack = new Stack(5);
        assertTrue(stack.isEmpty());
        stack.push("element");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop() throws StackFullException {
        Stack stack = new Stack(5);
        assertEquals(stack.pop(), null);

        stack.push("element-1");
        stack.push("element-2");

        assertEquals(stack.pop(), "element-2");
        assertEquals(stack.pop(), "element-1");
    }

    @Test
    public void testIsFull() throws StackFullException {
        Stack stack = new Stack(5);
        assertFalse(stack.isFull());
        stack.push("element");
        stack.push("element");
        stack.push("element");
        stack.push("element");
        stack.push("element");
        assertTrue(stack.isFull());
    }

    @Test(expected = StackFullException.class)
    public void testIfIsFullWillThrowException() throws StackFullException {
        Stack stack = new Stack(5);
        stack.push("element");
        stack.push("element");
        stack.push("element");
        stack.push("element");
        stack.push("element");
        stack.push("element");
    }

}
