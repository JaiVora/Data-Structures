import java.util.Stack;

/*
 * @author: Jai Vora
 * @version: 1.0
 * Date: September 17,2020
 * Program Details: Design a Queue using Stack Data Structure that supports Enqueue and Dequeue operations
 */
public class QueueStack {
    //We use two Stacks to design the solution
    private Stack<Integer> pushStack = new Stack<>();  // Elements are enqueued(pushed) on this stack
    private Stack<Integer> popStack = new Stack<>();   // Elements are dequeued(popped) from this stack

    public void enqueue(int data){
        pushStack.push(data);
    }

    public int dequeue(){
        if(popStack.isEmpty()){
            if(pushStack.isEmpty()){
                return -1;
            }
            else {
                pushElements();
            }
        }
        return popStack.pop();
    }
    //Helper method to push all the elements from the push stack to the pop stack for Dequeue-ing
    private void pushElements(){
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }
}
