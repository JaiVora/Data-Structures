/*
 *Author: Jai Vora
 *Date: 12/17/2019
 *The Table class is an address book implementation, that stores a name and the address associated with the name. 
 *The program presents the user a menu with a choice of operations:add a contact(name and address) look  up a contact(displaying  the  associated  address)
 *Update the address for a contact ,delete a contact,display all contacts, and quit.
 *Furthermore, the program will allow a user to send a text message to a contact and to display all messages to a contact.
 *The program implements a Dynamic Array and a LinkedList to provide the specified functionality. 
*/

import java.util.Scanner;

public class Table {

    public static void main(String[] args){
        Table table = new Table();
        String input="";
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        do{
            System.out.println();
            System.out.println("Add a contact (a)");
            System.out.println("Send a text message (m)");
            System.out.println("Look up a contact (l)");
            System.out.println("Update Address (u)");
            System.out.println("Delete a contact (dc)");
            System.out.println("Delete a text message (dm)");
            System.out.println("Display all contacts (ac)");
            System.out.println("Display all messages (am)");
            System.out.println("Quit (q)");
            System.out.println("");
            input = scan.nextLine();
            if(input.equals("a")){
                System.out.println("Please enter a name: " );
                String name = scan.nextLine();
                System.out.println("Please enter the address");
                String address = scan.nextLine();
                table.insert(name,address);
            }
            else if(input.equals("m")){
                System.out.println("Please enter the name to send the message");
                String name = scan.nextLine();
                System.out.println("Please enter your message");
                String msg = scan.nextLine();
                table.sendMessage(name,msg);
            }
            else if(input.equals("l")){
                System.out.println("Please enter the name to lookup");
                String name = scan.nextLine();
                String address = table.lookUp(name);
                System.out.println("Address for "+name+" is "+address);
            }
            else if(input.equals("u")){
                System.out.println("Please enter the name to update");
                String name = scan.nextLine();
                System.out.println("Please enter updated address");
                String address = scan.nextLine();
                table.update(name,address);
            }
            else if(input.equals("dc")){
                System.out.println("Enter the name to be deleted");
                String name = scan.nextLine();
                table.deleteContact(name);
            }
            else if(input.equals("dm")){
                System.out.println("Enter the contact to which messages are to be deleted");
                String name = scan.nextLine();
                table.deleteMessages(name);
            }
            else if(input.equals("ac")){
                table.displayAll();

            }
            else if(input.equals("am")){
                table.displayMessages();
            }
            else if(input.equals("q")){
                break;
            }
            else {
                System.out.println("Please enter a valid input");
            }

        }while(!(input.equals("q")));

    }
    private class Node{
        private String key;
        private String value;
        Node next;
        DynamicArray<String> msgs = new DynamicArray<String>();
        private Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
    Node head;
    private Node mark;
    public boolean markToStart(){
        if(head != null){
            mark = head;
            return  true;
        }
        else{
            return false;
        }
    }
    public boolean advanceMark(){
        if(mark == null){
            mark = head;
            return true;
        }
        if(mark.next != null){
            mark = mark.next;
            return true;
        }
        return false;
    }
    public String keyAtMark(){
        if(mark != null){
            return mark.key;
        }
        return null;
    }
    public String valueAtMark(){
        if(mark != null){
            return mark.value;
        }
        return null;
    }

    public boolean insert(String key, String value){
        Node newNode = new Node(key, value);
        if(head == null){
            head = newNode;
            System.out.println("Head node");
        }
        else
        {
            Node current = head;
            if(current.key.equals(key)){
                System.out.println("Duplicate Key: Insertion Unsuccessful "+key);
                return false;
            }
            while(current.next != null){
                if(current.key.equals(key)){
                    System.out.println("Duplicate Key: Insertion Unsuccessful "+key);
                    return false;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Insertion Successful");
        return true;
    }
    public String lookUp(String key){
        Node current = head;
        while (current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public boolean deleteContact(String key){
        if(head.key.equals(key)){
            head = head.next;
            System.out.println("Head node deleted");
            return true;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.key.equals(key)){
                current.next = current.next.next;
                System.out.println("Deletion Successful");
                return  true;
            }
            current = current.next;
        }
        if(current.key.equals(key)){
            current = null;
            System.out.println("Deletion Successful");
            return true;
        }
        System.out.println("Could not find the given input name");
        return false;
    }
    public boolean update(String key, String newValue){
        Node current = head;
        while(current != null){
            if(current.key.equals(key)){
                current.value = newValue;
                System.out.println("Updated Successfully");
                return true;
            }
            current = current.next;
        }
        System.out.println("Could not find the given input name");
        return false;
    }
    
    public int displayAll(){
        int count = 0;
        Node current = head;
        while(current != null){
            System.out.println("Name: " + current.key );
            System.out.println("Address: " + current.value );
            System.out.println();
            current = current.next;
            count++;
        }
        return count;
    }
    public boolean sendMessage(String key, String msg){
        Node current = head;
        while(current != null){
            if(current.key.equals(key)){
                current.msgs.add(msg);
                System.out.println("Message sent");
                return true;
            }
            current = current.next;
        }
        System.out.println("Name: "+key+ " not found");
        return false;
    }
    public boolean deleteMessages(String key){
        Node current = head;
        while(current != null){
            if(current.key.equals(key)){
                current.msgs.remove();
                System.out.println("Messages Deleted");
                return true;
            }
            current = current.next;
        }
        System.out.println("Could not find the given input name");
        return false;
    }
    public int displayMessages(){
        int size = 0;
        Node current = head;
        while(current != null){
            System.out.println("Messages for "+current.key);
            for(int i = 0; i < current.msgs.getSize(); i++){
                System.out.println(current.msgs.get(i));
            }
            size += current.msgs.getSize();
            current = current.next;
        }
        return size;
    }

    public class DynamicArray<T>{
        private T[] arr = (T[])new Object[2];
        private int capacity = 2;
        private int size = 0;

        public void add(T obj){
            if(size >= capacity){
                resize();
            }
            arr[size] = obj;
            size++;
        }
        private void resize(){
            capacity *= 2;
            T[] newArr = (T[])new Object[capacity];
            for(int i = 0; i < arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        public void remove(){
            for(int i = 0; i < arr.length; i++){
                arr[i] = null;
            }
            size = 0;
            if(size < capacity/3){
                capacity = capacity/2;
                T[] newArr = (T[])new Object[capacity];
                arr = newArr;
            }
        }
        public int getSize(){
            return size;
        }
        public T get(int index){
            return arr[index];
        }

    }
}
