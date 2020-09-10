/*
 * @author: Jai Vora
 * @version: 1.0
 * Date: September 10, 2020
 * Program Details: The queue class is an implementation of the Queue Data Structure that stores an int data type using a Linked List
 */
public class queue {
    // Node class that has a pointer to the next node and an integer data field
    private class Node{
        Node next;
        int data;
        private Node(int data){
            this.data = data;
        }
    }
    private int size = 0;
    Node head; // To keep track of the element to be DeQueued
    Node tail; // To keep track of the last element (address where a new elements is enqueued)
    /***
     * This method returns the size of the queue
     * @return int This is the size of the queue
     */
    public int getSize() {
        return size;
    }

    /***
     * This methods checks if the queue is empty
     * @return boolean Returns true if queue is empty else returns false
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    /***
     * This method is used to insert an item at the rear of the queue
     * @param data is the element to be inserted
     * @return nothing
     */
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    /***
     * This method removes the integer from the front of the queue
     * @return int This is the integer at the front of the queue if queue is not empty, if empty--> returns -1
     */
    public int dequeue(){
        if(head == null)
            return -1;
        int result = head.data;
        head = head.next; // Moving the head to the next element in the Queue
        if(head == null){
            tail = null;
        }
        size--;
        return result;
    }
    /***
     * This method returns the integer element at the front of the queue without removing it
     * @return int This is the integer at the front of the queue if queue is not empty, if empty--> returns -1
     */
    public int peek(){
        if(head == null){
            return -1;
        }
        return head.data;
    }
}
