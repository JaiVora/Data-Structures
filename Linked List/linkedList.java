/*
 * @author: Jai Vora
 * @version: 1.0
 * Date: September 8, 2020
 * Program Details: The class LinkedList is an implementation of a Linked List with a data type int.
 */
public class linkedList {
    //Defining a Node class, that has an integer field to store data and a pointer to the next Node
    private class Node{
        Node next;
        int data;
        private Node(int data){
            this.data = data;
        }
    }
    private Node head; // Declaring the head Node globally

    /**
     * This method returns the size of the linked list
     * @return integer size of the list
     */
    public int getSize() {
        return size;
    }

    private int size = 0; // Size of the Linked List
    /**
     * This method is used to insert an element at the end of the linked list.
     * @param data This is the integer data that is to be inserted
     * @return void
     */
    public void insert(int data){
        if(head == null){ // Check if the linked list is empty
            head = new Node(data);
            size++;
            return;
        }
        Node current = head; // temporary reference to the head node
        while(current.next != null){ // current.next as we do not want current to point to null
            current = current.next; // that way we can link the next of the last element to the new element
        }
        current.next = new Node(data); //once we have found the last element, it's next pointer points towards the new element
        size++;
    }
    /**
     * The get method is used to get an element based on it's index.
     * @param index This is the integer index specified by the client
     * @return integer element at the specified index if index is less than size
     * @return -1 if index is out of bounds
     */
     public int get(int index){
        if(index >= size){ // index is 0 based, size is greater by 1
            return -1;
        }
        int i = 0;
        Node current = head;
        while(i < index){
            current = current.next;
            i++;
        }
        return current.data;
    }
    /**
     * This method is used to insert an element at the start of the linked list.
     * @param data This is the integer data that is to be inserted
     * @return void
     */
    public void insertAtHead(int data){
       if(head == null){
            head = new Node(data);
            size++;
            return;
        }
         Node newNode = new Node(data); // Allocate the Node and put the data
         newNode.next = head; // Setting the next pointer of the new Node to the head
         head = newNode; // Move the head to point to the new Node
        size++;
    }
    /**
     * This method is used to remove the first instance of a given element in the Linked List.
     * @param data This is the integer data that is to be removed
     * @return void
     * if the data is not found, a print statement is Displayed
     */
    public void remove(int data){
        if(head == null){
            return;
        }
        if(head.data == data){ // If head is null, simply point the head to the next Node
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
        System.out.println("Item Not found");
    }
    /**
     * This method is used to search a given element in the Linked List.
     * @param data This is the integer data that is to be searched
     * @return true if the element is found
     * @return false if element not found
     */
    public boolean contains(int data){
        if(head == null){
            return false;
        }
        Node current = head;
        while(current != null){
            if(current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
