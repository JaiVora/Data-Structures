/*
 * @author: Jai Vora
 * @version: 1.0
 * Data: September 17, 2020
 * Program Details: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Two Stacks Approach
 */
import javax.print.attribute.IntegerSyntax;
import java.util.Stack;

public class minStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>(); //minStack keeps track of the minimum element in the original stack.

    public void push(int data){
        stack.push(data);
        if(minStack.isEmpty() || minStack.peek() >=  data ){ // If an element with value lower than or equal to the minimum value is pushed
            minStack.push(data); // Element is pushed onto the min stack
        }
    }
    public int pop(){
        if(stack.isEmpty()){
            return -1;
        }
        if(stack.peek() == minStack.peek()){ //If the element to be popped is the min element of the stack
            stack.pop();
            return minStack.pop(); //pop the minStack too
        }
        return stack.pop();
    }
    public int top(){
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }


}
