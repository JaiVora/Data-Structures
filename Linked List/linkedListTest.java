import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class linkedListTest {

    linkedList ll = new linkedList();

    @Test
    void getSize() {
        ll.insert(2);
        ll.insert(3);
        Integer result = 2;
        Assert.assertEquals((Integer)ll.getSize(),result);
    }
    @Test
    void getSizeZero() {
        Integer result = 0;
        Assert.assertEquals((Integer)ll.getSize(),result);
    }
    @Test
    void getSizeOne() {
        ll.insert(1);
        Integer result = 1;
        Assert.assertEquals((Integer)ll.getSize(),result);
    }
    @Test
    void insert() {
        ll.insert(1);
        ll.insert(2);
        Integer actual = ll.get(1);
        Integer expected = 2;
        Assert.assertEquals(expected,actual);
    }
    @Test
    void insertOne() {
        ll.insert(1);
        Integer actual = ll.get(0);
        Integer expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    void get() {
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        Integer actual = ll.get(3);
        Integer expected = 5;
        Assert.assertEquals(expected,actual);
    }
    @Test
    void getOutOfBounds() {
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        Integer actual = ll.get(4);
        Integer expected = -1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    void insertAtHead() {
        ll.insertAtHead(1);
        ll.insertAtHead(2);
        Integer actual = ll.get(1);
        Integer expected = 1;
        Assert.assertEquals(expected,actual);
    }
    @Test
    void insertAtHeadBiggerList() {
        ll.insertAtHead(1);
        ll.insertAtHead(2);
        ll.insertAtHead(3);
        Integer actual = ll.get(2);
        Integer expected = 1;
        Assert.assertEquals(expected,actual);
    }
    @Test
    void insertAtHeadSmallList() {
        ll.insertAtHead(1);
        Integer actual = ll.get(0);
        Integer expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    void remove() {
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.remove(5);
        Integer expected = 3;
        Integer actual = ll.getSize();
        Assert.assertEquals(expected,actual);
    }
    @Test
    void removeHead() {
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.remove(2);
        Integer expected = 3;
        Integer actual = ll.getSize();
        Assert.assertEquals(expected,actual);
        Assert.assertEquals((Integer)ll.get(0),(Integer) 3);
    }
    @Test
    void removeAll() {
        ll.insert(2);
        ll.remove(2);
        Integer expected = 0;
        Integer actual = ll.getSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    void contains() {
        ll.insert(5);
        ll.insert(20);
        Assert.assertTrue(ll.contains(20));
    }
    @Test
    void containsFalse() {
        ll.insert(5);
        ll.insert(20);
        Assert.assertFalse(ll.contains(220));
    }

}