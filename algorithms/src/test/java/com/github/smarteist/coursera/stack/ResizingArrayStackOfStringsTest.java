package com.github.smarteist.coursera.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResizingArrayStackOfStringsTest {

    @Test
    public void isEmpty() {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        assertTrue(stack.isEmpty());
        stack.push("Hello");
        assertFalse(stack.isEmpty());
        assertEquals("Hello", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushPop() {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        assertTrue(stack.isEmpty());
        stack.push("Hello");
        stack.push("Mr");
        stack.push("World");
        assertEquals("World", stack.pop());
        assertEquals("Mr", stack.pop());
        assertEquals("Hello", stack.pop());
        assertTrue(stack.isEmpty());
    }
}