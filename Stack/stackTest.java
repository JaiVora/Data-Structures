import static org.junit.jupiter.api.Assertions.*;

class stackTest {

    stack s = new stack();
    @org.junit.jupiter.api.Test
    void push() {
        s.push(3);
        s.push(5);
        Integer actual = (Integer)s.peek();
        Integer expected = 5;
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void pushBigList() {
        s.push(3);
        s.push(55);
        s.push(4);
        s.push(222);
        Integer actual = (Integer)s.peek();
        Integer expected = 222;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void pop() {
        s.push(3);
        s.push(55);
        s.push(4);
        s.push(222);
        Integer actual = (Integer)s.pop();
        Integer expected = 222;
        assertEquals(expected,actual);

    }
    @org.junit.jupiter.api.Test
    void popOneElement() {
        s.push(222);
        Integer actual = (Integer)s.pop();
        Integer expected = 222;
        assertEquals(expected,actual);
        assertTrue(s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void popEmptyStack() {
        Integer actual = (Integer) s.pop();
        Integer expected = Integer.MIN_VALUE;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void peek() {
        s.push(3);
        s.push(55);
        Integer actual = (Integer)s.peek();
        Integer expected = 55;
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void peekEmptyStack() {
        Integer actual = (Integer)s.peek();
        Integer expected = Integer.MIN_VALUE;
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyWithPushPop() {
        s.push(7);
        s.push(8);
        s.pop();
        s.pop();
        assertTrue(s.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyFalse() {
        s.push(7);
        s.push(8);
        s.pop();
        assertFalse (s.isEmpty());
    }
}