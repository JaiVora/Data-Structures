/*
 * @author: Jai Vora
 * @version: 1.0
 * Date: September 10,2020
 * Program Details: The bst class is an implementation of a Binary Search Tree Data Structure
 */
public class bst {
    // Node class is wrapped in the bst class having a data field and pointers to the left and right elements
    private class Node{
        Node left,right;
        int data;
        private Node(int data){
            this.data = data;
        }
    }
    Node root; //root node of the tree

    /***
     * This method calls the insertAt() method to insert an element in the tree.
     * @param data This is the element to be inserted
     */
    public void insert(int data){
        insertAt(root,data);
    }

    /***
     * This method calls the searchAt() method internally to find an element in the tree
     * @param data
     * @return boolean Returns true if found, else false
     */
    public boolean search(int data){
        return searchAt(data,root);
    }
    /***
     * This method inserts a new element to the tree according to it's value.
     * If the value of the new element is greater than the root, the element is inserted in the right subtree.
     * If the value of the new element is less than or equal to the root, the element is inserted in the left subtree.
     * @param root This is the root node of the tree
     * @param data This is the integer to be inserted in the tree
     * @return Node This is the root node of the tree
     */
    private Node insertAt(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data <= root.data){
            root.left = insertAt(root.left,data);
        }
        if(data > root.data){
            root.right = insertAt(root.right, data);
        }
        return root;
    }
    /***
     * This method looks for a particular item in the Binary search tree and returns true if found
     * @param data This is the element to be searched
     * @param root This is the root node of the tree
     * @return true if element is found else false
     */
    private boolean searchAt(int data, Node root){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        if(data < root.data){
            return searchAt(data,root.left);
        }
        if(data > root.data){
            return searchAt(data,root.left);
        }
        return false;
    }


}
