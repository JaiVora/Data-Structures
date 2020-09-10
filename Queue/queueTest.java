import static org.junit.jupiter.api.Assertions.*;

class queueTest {

    queue q = new queue();
    @org.junit.jupiter.api.Test
    void getSize() {
        q.enqueue(4);
        q.enqueue(5);
        Integer expected = 2;
        Integer actual = q.getSize();
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void getSizeWithDeq() {
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        Integer expected = 1;
        Integer actual = q.getSize();
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void getSizeWithZeroElements() {
        Integer expected = 0;
        Integer actual = q.getSize();
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void isEmptyTrue() {
        assertTrue(q.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyFalse() {
        q.enqueue(3);
        assertFalse(q.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(8);
        assertEquals(2,q.dequeue());
        assertEquals(5,q.dequeue());
        assertEquals(8,q.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueEmptyQueue() {
        assertEquals(-1,q.dequeue());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        assertEquals(3,q.peek());

    }
}