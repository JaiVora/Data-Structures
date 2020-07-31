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
        Scanner sc= new Scanner(System.in);
        System.out.println("Please specify the path of your text file: ");
        String path = sc.nextLine();
        File file = new File(path);
        Scanner inputFile = new Scanner(file); //Throws FileNotFoundException if the path is invalid/ not found
        inputQueue queue = new inputQueue();
        while (inputFile.hasNextLine())
        {
            Scanner words = new Scanner(inputFile.nextLine());
            while(words.hasNext()){
                String word = words.next();
                queue.Enqueue(word);
            }

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
    public class ProgramStack<T>{
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
               top = top.next;
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
