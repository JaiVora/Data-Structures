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
        root = insertAt(root,data);
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

    /***
     * This method prints the tree in order: Root -> left -> right
     * @param root This is the root of the tree
     * @return nothing
     */
    private void preOrder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /***
     * This method calls the preOrder private method to print the tree in preOrder manner
     * @return nothing
     */
    public void preOrder(){
        preOrder(root);
    }
    /***
     * This method prints the tree in the order: left -> root -> right
     * @param root This is the root of the tree
     * @return nothing
     */
    private void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    /***
     * This method calls the inOrder private method to print the tree in inOrder manner
     * @return nothing
     */
    public void inOrder(){
        inOrder(root);
    }
    /***
     * This method prints the tree in order:  left -> right -> root
     * @param root This is the root of the tree
     * @return nothing
     */
    private void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    /***
     * This method calls the preOrder private method to print the tree in preOrder manner
     * @return nothing
     */
    public void postOrder(){
        postOrder(root);
    }


    public void delete(int data){
        root = delete(root,data);
    }
    /***
     * This method deletes a specified node in the BST, if found.
     * @param data This is the value of the node to be deleted
     * @param root This is the root of the tree
     */
    private Node delete(Node root, int data){
        if(root == null) return root;
        if(data < root.data){
            root.left = delete(root.left,data);
        }
        else if(data > root.data){
            root.right = delete(root.right,data);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            root.data = minValue(root.right);
            delete(root.right,root.data);
        }
        return root;
    }

    /***
     * This is a helper method to find the element with the minimum value in the BST
      * @param root This is the root of the subtree, passed by the private method delete
     * @return int This is the minimum element in the BST
     */
    private int minValue(Node root)
    {
        int min = root.data;
        while (root.left != null)
        {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
}
