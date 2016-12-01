package pj5;

import java.util.Comparator;

/**
 * A class that implements the ADT list by using a chain of linked nodes that
 * has a head reference.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 * @param <T>
 *            type of Objects being added to the LinkedList
 */

public class LList<T>
{
    private Node firstNode;      // Reference to first node of chain
    private int  numberOfEntries;


    /**
     * Default Constructor of LinkedList
     */
    public LList()
    {
        initializeDataFields();
    } // end default constructor


    /**
     * clears the LinkedList
     */
    public void clear()
    {
        initializeDataFields();
    } // end clear


    /**
     * adds a new item into the LinkedList
     * 
     * @param newEntry
     *            the entry being added
     */
    public void add(T newEntry) // OutOfMemoryError possible
    {
        Node newNode = new Node(newEntry);

        if (isEmpty())
        {
            firstNode = newNode;
        }
        else // Add to end of non-empty list
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
        } // end if

        numberOfEntries++;
    } // end add


    /**
     * Removes the instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(T obj)
    {
        Node current = firstNode;

        // account for matching head
        if ((null != firstNode) && (obj.equals(current.data)))
        {
            firstNode = firstNode.next;
            numberOfEntries--;
            return true;
        }

        // account for 2+ size
        while (numberOfEntries >= 2 && (current.next.next != null))
        {
            if ((obj.equals(current.next.data)))
            {
                if (current.next.next != null)
                {
                    current.setNextNode(current.next.next);
                }
                else
                {
                    current.next.setNextNode(null);
                }
                numberOfEntries--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * removes an object from the LinkedList
     * 
     * @param givenPosition
     *            the entry at where the object to be removed is located
     * @return the Object that was removed the LinkedList
     */
    public T remove(int givenPosition)
    {
        T result = null; // Return value

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert !isEmpty();

            if (givenPosition == 1) // Case 1: Remove first entry
            {
                result = firstNode.getData(); // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            }
            else // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData(); // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter); // Remove entry
            } // end if

            numberOfEntries--; // Update count
            return result; // Return removed entry
        }
        else
        {
            throw new IndexOutOfBoundsException(
                "Illegal position given to remove operation.");
        }
    } // end remove


    /**
     * Gets the entry at the given position
     * 
     * @param givenPosition
     *            the entry at where the object is located
     * @return the Object located at the given position
     */
    public T getEntry(int givenPosition)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert !isEmpty();
            return getNodeAt(givenPosition).getData();
        }
        else
        {
            throw new IndexOutOfBoundsException(
                "Illegal position given to getEntry operation.");
        }
    } // end getEntry


    /**
     * Copies the entires in the LinkedList and puts them into an Array
     * 
     * @return an array of Objects that contains the same entries as the
     *         LinkedList
     */
    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while

        return result;
    } // end toArray


    /**
     * Checks to see if an entry is containted in the LinkedList
     * 
     * @param anEntry
     *            the Object to be searched for in the LinkedList
     * @return true if the entry is in the list else false if it is not in the
     *         list
     */
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        } // end while

        return found;
    } // end contains


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString()
    {
        String result = "{";

        Node current = firstNode;
        while (current != null)
        {
            result += "" + current.data;
            current = current.next;
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * gets the amount of entries in the LinkedList
     * 
     * @return int the amount of entires in the LinkedList
     */
    public int getLength()
    {
        return numberOfEntries;
    } // end getLength


    /**
     * checks to see if the LinkedList is Empty
     * 
     * @return true if LinkedList is empty false if it is not
     */
    public boolean isEmpty()
    {
        boolean result;

        if (numberOfEntries == 0) // Or getLength() == 0
        {
            assert firstNode == null;
            result = true;
        }
        else
        {
            assert firstNode != null;
            result = false;
        } // end if

        return result;
    } // end isEmpty


    /**
     * Initializes the class's data fields to indicate an empty list.
     */
    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields


    /**
     * gets a Node at the given position
     * 
     * @param givenPosition
     *            the position where the Node is located / 1 <= givenPosition <=
     *            numberOfEntries.
     * @return a refrence to the Node at a given position while the LinkedList
     *         is not empty
     */
    private Node getNodeAt(int givenPosition)
    {
        assert !isEmpty() && (1 <= givenPosition)
            && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;

        // Traverse the chain to locate the desired node
        // (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++)
        {
            currentNode = currentNode.getNextNode();
        }

        assert currentNode != null;

        return currentNode;
    } // end getNodeAt


    /**
     * adds Nodes into the LinkedList in order
     * 
     * @param nodeToInsert
     *            the Node being inserted into the LinkedList
     * @param comparator
     *            the type of comparator that is being used
     */
    private void insertInOrder(
        Node nodeToInsert,
        Comparator<? super T> comparator)
    {
        T item = nodeToInsert.getData();
        Node currentNode = firstNode;
        Node previousNode = null;

        while ((currentNode != null) && (comparator.compare(item, currentNode
            .getData()) > 0))
        {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        if (previousNode != null)
        {
            previousNode.setNextNode(nodeToInsert);
            nodeToInsert.setNextNode(currentNode);
        }
        else
        {
            nodeToInsert.setNextNode(firstNode);
            firstNode = nodeToInsert;
        }
    }


    /**
     * Sorts the LinkedList based on the type of comparator being used
     * 
     * @param comparator
     *            the type of comparator being used to sort the LinkedList
     */
    public void insertSort(Comparator<? super T> comparator)
    {
        if (getLength() > 1)
        {
            Node unsortedPart = firstNode.getNextNode();
            firstNode.setNextNode(null);

            while (unsortedPart != null)
            {
                Node nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNextNode();
                insertInOrder(nodeToInsert, comparator);
            }
        }
    }


    /**
     * This class creates a Node Object to be used in LinkedList Each Node
     * contains Data and a Link to the next Node
     * 
     * @author usmana
     * @version 11/30/2016
     */
    private class Node
    {
        private T    data; // Entry in list
        private Node next; // Link to next node


        /**
         * Constructor for Node class with a data Item
         * 
         * @param dataPortion
         *            the data contained in the Node
         */
        private Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end constructor


        /**
         * Constructor for Node class with a data Item and a Link to the next
         * Node
         * 
         * @param dataPortion
         *            the data contained in the Node
         * @param nextNode
         *            Link to the next Node
         */
        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor


        /**
         * gets the data in the Node
         * 
         * @return the data contained in the Node
         */
        private T getData()
        {
            return data;
        } // end getData


        /**
         * gets the next Node
         * 
         * @return gets the Node that is pointed to
         */
        private Node getNextNode()
        {
            return next;
        } // end getNextNode


        /**
         * sets the new refrences for the next Node
         * 
         * @param nextNode
         *            the new Node that next refrences
         */
        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node
} // end LList

