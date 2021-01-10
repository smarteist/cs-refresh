package com.github.smarteist.coursera.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTest {

    @Test
    public void isEmpty() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("Hi");
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueueDequeue() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("Hi");
        queue.enqueue("Hello");
        queue.enqueue("World");
        assertEquals("Hi", queue.dequeue());
        assertEquals("Hello", queue.dequeue());
        assertEquals("World", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

}