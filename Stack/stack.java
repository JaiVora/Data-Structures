/*
 * @author: Jai Vora
 * @version: 1.0
 * Date: September 9, 2020
 * Program Details: The stack class is an implementation of the Stack Data Structure that stores an int data type using a Linked List
 */
public class stack {
    // Node class is wrapped in the stack class having a data field and a pointer to the next element
    private class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
        }
    }
    private Node top;
    /***
     * This method is used to push an element to the top of the stack
     * @param data is the integer data to be pushed to the stack
     * @return Nothing.
     */
    public void push(int data){
        if(top == null){
            top = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    /***
     * This method is used to removes an item from the stack.
     * The items are popped in the reversed order in which they are pushed.
     * @return int This returns top of the stack if stack is not empty
     * @return int Returns Integer.MIN_VALUE if stack is null.
     *
     */
    public int pop(){
        if(top == null){
            return Integer.MIN_VALUE;
        }
        int result = top.data;
        top = top.next;
        return result;
    }
    /***
     * This method returns top element of stack.
     * @return int This returns top element of the stack if stack is not empty
     * @return int Returns Integer.MIN_VALUE if stack is null.
     *
     */
    public int peek(){
        if(top == null){
            return Integer.MIN_VALUE;
        }
        return top.data;
    }
    /***
     * This method returns true if stack is empty, else false.
     * @return boolean True or False based on whether the stack is empty or not
     *
     */
    public Boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

}
