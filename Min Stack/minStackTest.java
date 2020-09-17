import static org.junit.jupiter.api.Assertions.*;

class minStackTest {
    minStack minstack = new minStack();
    @org.junit.jupiter.api.Test
    void pushAndPop() {
        minstack.push(3);
        minstack.push(4);
        minstack.push(5);
        assertEquals(5,minstack.pop());
        assertEquals(4,minstack.pop());
        assertEquals(3,minstack.pop());

    }

    @org.junit.jupiter.api.Test
    void emptyPop() {
        minstack.push(3);
        minstack.push(4);
        minstack.push(5);
        assertEquals(5,minstack.pop());
        assertEquals(4,minstack.pop());
        assertEquals(3,minstack.pop());
        assertEquals(-1,minstack.pop());

    }

    @org.junit.jupiter.api.Test
    void top() {
        minstack.push(3);
        minstack.push(4);
        minstack.push(5);
        assertEquals(5,minstack.top());
        minstack.pop();
        assertEquals(4,minstack.top());
        minstack.pop();
        assertEquals(3,minstack.top());
    }
    @org.junit.jupiter.api.Test
    void emptyStackTop() {
        minstack.push(3);
        minstack.push(4);
        minstack.push(5);
        assertEquals(5,minstack.top());
        minstack.pop();
        assertEquals(4,minstack.top());
        minstack.pop();
        assertEquals(3,minstack.top());
        minstack.pop();
        assertEquals(-1,minstack.top());

    }

    @org.junit.jupiter.api.Test
    void getMin() {
        minstack.push(3);
        minstack.push(4);
        minstack.push(5);
        assertEquals(3,minstack.getMin());

    }
    @org.junit.jupiter.api.Test
    void getMinWithPop() {
        minstack.push(5);
        minstack.push(4);
        minstack.push(3);
        minstack.pop();
        assertEquals(4,minstack.getMin());
    }
}