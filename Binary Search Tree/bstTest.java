import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bstTest {
    bst tree =new bst();
    @Test
    void testInsert() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(11);
        tree.preOrder();
    }

    @Test
    void testSearchTrue() {
        tree.insert(4);
        tree.insert(7);
        tree.insert(8);
        assertTrue(tree.search(4));
    }
    @Test
    void testSearchFalse() {
        tree.insert(4);
        tree.insert(7);
        tree.insert(8);
        assertFalse(tree.search(20));
    }

    @Test
    void preOrder() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(11);
        tree.preOrder();

    }

    @Test
    void inOrder() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(11);
        tree.inOrder();
    }

    @Test
    void postOrder() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(11);
        tree.postOrder();
    }

    @Test
    void deleteWorstCase() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(11);
        tree.insert(15);
        tree.insert(14);
        tree.insert(18);
        tree.delete(11);
        assertFalse(tree.search(11));
        tree.inOrder();
    }
    @Test
    void deleteLeaf() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(11);
        tree.insert(15);
        tree.insert(14);
        tree.insert(18);
        tree.delete(18);
        assertFalse(tree.search(18));
        tree.inOrder();
    }
    @Test
    void deletewithOneChild() {
        tree.insert(7);
        tree.insert(3);
        tree.insert(5);
        tree.insert(11);
        tree.insert(15);
        tree.insert(14);
        tree.insert(18);
        tree.delete(3);
        assertFalse(tree.search(3));
        tree.inOrder();
    }
}