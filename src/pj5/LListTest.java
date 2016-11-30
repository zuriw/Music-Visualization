package pj5;

import java.util.Comparator;
import student.TestCase;

/**
 * @author zuriw,usmana
 * @version 2016.11.27
 */
public class LListTest extends TestCase
{
    private StringComparator strCompare;
    private LList<String>    str;


    /**
     * creates a LinkedList<String> and String COmparator Object for testing
     */
    public void setUp()
    {
        strCompare = new StringComparator();
        str = new LList<String>();
    }


    /**
     * test method size to get the number of elements in the list
     */
    public void testgetLength()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertEquals(3, str.getLength());
    }


    /**
     * test method add when the object is null
     */
    public void testAddNull()
    {
        String input1 = null;

        try
        {
            str.add(input1);
        }
        catch (Exception e)
        {
            assertTrue(e instanceof IllegalArgumentException);
        }

    }


    /**
     * test method add when location is not specified
     */
    public void testAdd()
    {
        str.add("a");
        str.add("b");
        assertEquals(2, str.getLength());
    }


    /**
     * test method isEmpty when the list is empty
     */
    public void testIsEmptyT()
    {
        assertTrue(str.isEmpty());
    }


    /**
     * test method isEmpty when the list is not empty
     */
    public void testIsEmptyF()
    {
        str.add("a");
        str.add("b");
        assertFalse(str.isEmpty());
    }


    /**
     * test method remove when an object is successfully removed; first node is
     * not null, and first node equals to object needed to be removed
     */
    public void testRemoveFirstNodeT()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertNotNull(str.getEntry(1));
        assertEquals("a", str.getEntry(1));
        assertTrue(str.remove("a"));
        assertEquals(2, str.getLength());
        assertFalse(str.contains("a"));
        assertEquals("{b, c}", str.toString());
    }


    /**
     * test method remove when the the list is empty so the first node is null
     */
    public void testRemoveFirstNodeEmpty()
    {
        assertFalse(str.remove("a"));
    }


    /**
     * test method remove when the list is greater than 2 and the object is
     * found and removed
     */
    public void testRemove2nUpFoundRemoved()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");
        str.add("e");
        assertTrue(str.remove("c"));
        assertFalse(str.contains("c"));
        assertEquals(4, str.getLength());
    }


    /**
     * test method remove when the list is greater than 2 and the the object is
     * not found in the list
     */
    public void testRemove2NupNotFound()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");
        str.add("e");
        assertFalse(str.remove("f"));
        assertEquals(5, str.getLength());
        assertFalse(str.contains("f"));
    }


    /**
     * test method remove when an object is Not successfully removed
     */
    public void testRemoveF()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertFalse(str.remove("d"));
        assertEquals(3, str.getLength());

    }


    /**
     * test method remove at a certain location when there is no element at that
     * index
     */
    public void testRemoveIndNoEle()
    {
        str.add("a");
        str.add("b");
        try
        {
            str.remove(3);
        }
        catch (Exception e)
        {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }


    /**
     * test method remove at a certain location when the removal is successful
     */
    public void testRemoveIndT()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertEquals("a", str.remove(1));
        assertEquals(2, str.getLength());
    }


    /**
     * test method get when there is no node at the given index
     */
    public void testGetNoNode()
    {
        try
        {
            str.getEntry(0);
        }
        catch (Exception e)
        {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }


    /**
     * test method get when the index is less than zero
     */
    public void testGetIndLessThanZero()
    {
        try
        {
            str.getEntry(-1);
        }
        catch (Exception e)
        {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }


    /**
     * test method get when the index is greater than the size
     */
    public void testGetIndGreaterThangetLength()
    {
        str.add("a");
        str.add("b");
        str.add("c");

        try
        {
            str.getEntry(4);
        }
        catch (Exception e)
        {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }


    /**
     * test method get to return a specific object at the given index
     */
    public void testgetEntry()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertEquals("a", str.getEntry(1));
    }


    /**
     * test method contains when the object exists
     */
    public void testContainsT()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertTrue(str.contains("a"));
    }


    /**
     * test method contains when the object does not exist
     */
    public void testContainsF()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertFalse(str.contains("d"));
    }


    /**
     * test method clear
     */
    public void testClearNotEmpty()
    {
        str.add("a");
        str.add("b");
        str.add("c");
        assertNotNull(str.getEntry(1));
        str.clear();
        assertTrue(str.isEmpty());
        assertEquals(0, str.getLength());
    }


    /**
     * test method clear when list is empty
     */
    public void testClearEmpty()
    {
        assertTrue(str.isEmpty());
        str.clear();
        assertEquals(0, str.getLength());
    }


    /**
     * test method toString that returns elements in the list in "A, B, C"
     * format
     */
    public void testToString()
    {
        str.add("b");
        str.add("a");
        str.add("c");
        str.insertSort(strCompare);
        assertEquals("{a, b, c}", str.toString());
    }


    /**
     * This private class creates a StringComparator object to test the sorting
     * abilites in the linked list
     * 
     * @author usmana
     * @version 11/30/2016
     */
    private class StringComparator implements Comparator<String>
    {
        /**
         * @param str1
         *            is the first String
         * @param str2
         *            is the second String being compared to
         * @return if the String lengths are not the same it will return the
         *         differences in length otherwise it will return This method
         *         returns a negative integer, zero, or a positive integer as
         *         the specified String is greater than, equal to, or less than
         *         this String, ignoring case considerations.
         */
        public int compare(String str1, String str2)
        {
            if (str1.length() != str2.length())
            {
                return str1.length() - str2.length();
            }
            else
            {
                return str1.compareToIgnoreCase(str2);
            }
        }
    }
}
