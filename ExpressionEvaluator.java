/*
* Author: Jai Vora
* Date: July 30,2020
* Postfix Expression Calculator Program
* */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ExpressionEvaluator {
    //Initiating by Reading the File in the main method
    public static void main(String[] args) throws FileNotFoundException {
       // Scanner sc= new Scanner(System.in);
        System.out.println("Please specify the path of your text file: ");
      //  String path = sc.nextLine();
        String path = "/home/jai/jai.txt";
        File file = new File(path);
        Scanner inputFile = new Scanner(file); //Throws FileNotFoundException if the path is invalid/ not// fou//// nd
        ProgramStack<Integer> stack = new ProgramStack<Integer>();
        inputQueue queue = new inputQueue();

        while (inputFile.hasNextLine())
        {
            boolean flag = false;
            Scanner words = new Scanner(inputFile.nextLine());
            while(words.hasNext()){
                String word = words.next();
                System.out.print(word + " ");
                queue.Enqueue(word);
            }
            int size = queue.size;
            //Main logic of the program
            //Keep going until the entire queue is empty
            //If operator --> pop two elements
            //If string's first character is integer then push to stack
            while(size != 0){
                String in = queue.Dequeue();
                char c = in.charAt(0);
              //  System.out.println(c);
                if(Character.isDigit(in.charAt(0))){
                    int i = Integer.parseInt(in);
                    stack.push(i);
                }
                else if(c == '+' || c == '-' || c == '/' || c == '*' || c =='^'){
                   // System.out.println("Coming here");
                    try{
                        int operand_1 = stack.pop();
                        int operand_2 = stack.pop();
                        switch (in){
                            case "+":
                                stack.push(operand_2+operand_1);
                                break;
                            case "-":
                                stack.push(operand_2-operand_1);
                                break;
                            case "*":
                                stack.push(operand_2*operand_1);
                                break;
                            case "/":
                                stack.push(operand_2/operand_1);
                                break;
                            case "^":
                                double ans = Math.pow(operand_2,operand_1);
                                int ans2 = (int)ans;
                                stack.push(ans2);
                                break;
                            default:
                                System.out.println("Cant process that operator yet");
                                break;
                        }
                    }
                    catch (NullPointerException e){
                        flag = true;
                        break;
                    }
                }
                else if(Character.isLetter(c)){
                    //Implement a Hash Table
                    //Add values to the hash table
                    //in variable is the key
                }
                size--;

            }

            if(flag){
                System.out.println(": Invalid Expression");
            }
            else{
                System.out.println(": "+stack.peek());
            }
            stack.clear();
        }

    }
    //Queue Implementation using Linked List
    public static class inputQueue{
        private class Node {
            Node next;
            String data;

            public Node(String data) {
                this.data = data;
            }
        }
        private int size = 0;
        private Node head;
        private Node tail;
        public void Enqueue(String word){
            Node newNode = new Node(word);
            if(tail != null){
                tail.next = newNode;
            }
            tail = newNode;
            if(head == null){
                head = newNode;
            }
            size++;
        }

        public int getSize() {
            return size;
        }

        public String Dequeue(){
            if(head == null){
                return null;
            }
            String data = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
            return data;
        }
    }

    //Stack implementation of Generic type using Linked List
    public static class ProgramStack<T>{
        private class Node{
            T data;
            Node next;
            public Node(T data){
                this.data = data;
            }
        }
        private Node top;
        public void push(T obj){
            Node newNode = new Node(obj);
            if(top != null){
               newNode.next = top;
            }
            top = newNode;
        }
        public T pop(){
            if(top == null){
                return  null;
            }
            T data = top.data;
            top = top.next;
            return data;
        }
        public T peek(){
            if(top == null){
                return null;
            }
            return top.data;
        }
        public void clear(){
            top = null;
        }
    }
}
