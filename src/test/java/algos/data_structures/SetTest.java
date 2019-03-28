package algos.data_structures;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


public class SetTest {

    @Test
    public void testAdd() {
        Set set = new Set();

        // first element is added
        assertTrue(set.add("3"));

        // element is not added again for the second time
        assertFalse(set.add("3"));
    }

    @Test
    public void testIsEmpty() {
        Set set = new Set();

        assertTrue(set.isEmpty());

        // add an element so that it won't be empty
        set.add("3");

        assertFalse(set.isEmpty());
    }

    @Test
    public void testRemove() {
        Set set = new Set();
        assertFalse(set.remove("3"));

        set.add("3");
        assertTrue(set.remove("3"));
    }

    @Test
    public void testIterate() {
        Set set = new Set();

        // add 3 elements to iterate over
        set.add("3");
        set.add("4");
        set.add("5");

        Iterator iterator = set.iterator();

        // assert that iteration works
        assertEquals(iterator.next(), "3");
        assertEquals(iterator.next(), "4");
        assertEquals(iterator.next(), "5");
    }
}
