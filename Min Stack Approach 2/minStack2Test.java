import static org.junit.jupiter.api.Assertions.*;

class minStack2Test {
    minStack2 minstack = new minStack2();
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