/*
 * @author: Jai Vora
 * @version: 1.0
 * Date: September 18,2020
 * Program Details: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Approach #2: Using an extra field in the Node class
 */
public class minStack2 {
    //Node class with the a pointer to the next element, data field and min field to keep track of the minimum element in the stack.
    private class Node{
        Node next;
        int data;
        int min;
        private Node(int data, int min){
            this.data = data;
            this.min = min;
        }
    }
    Node top; // Top of the stack

    //Push the element to the stack
    public void push(int data){
        if(top == null){
            top = new Node(data,data);
            return;
        }
        Node newNode;
        if(data < top.min){   //If the element to be inserted is less than the minimum of the stack
            newNode = new Node(data,data); //The minimum of the Stack changes
        }
        else{ // If the new element to be pushed is greater than the current minimum
            newNode = new Node(data,top.min); // Minimum of the stack remains unchanged
        }
        newNode.next = top;
        top = newNode;
        return;
    }

    //Pop the top of the stack. If stack is empty, return -1
    public int pop(){
        if(top == null){
            return -1;
        }
        int result = top.data;
        top = top.next;
        return result;
    }
    public int getMin(){
        if(top == null)  return -1;
        return top.min;
    }
}
