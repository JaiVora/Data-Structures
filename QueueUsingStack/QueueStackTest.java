import static org.junit.jupiter.api.Assertions.*;

class QueueStackTest {
    QueueStack qs = new QueueStack();
    @org.junit.jupiter.api.Test
    void enqueue() {
        qs.enqueue(2);
        qs.enqueue(4);
        qs.enqueue(5);
        assertEquals(2,qs.dequeue());
        assertEquals(4,qs.dequeue());
        assertEquals(5,qs.dequeue());
    }

    @org.junit.jupiter.api.Test
    void dequeueEmptyQueue() {
        qs.enqueue(2);
        qs.enqueue(4);
        qs.enqueue(5);
        assertEquals(2,qs.dequeue());
        assertEquals(4,qs.dequeue());
        assertEquals(5,qs.dequeue());
        assertEquals(-1,qs.dequeue());
    }
}