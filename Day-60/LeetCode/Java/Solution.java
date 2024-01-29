/**
 * Problem: Implement Queue using Stacks
 * Description: Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 */
class MyQueue {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public MyQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void push(int x) {
        enqueueStack.push(x);
    }

    public int pop() {
        if (empty())
            throw new IllegalStateException("Queue is empty");

        transferIfNecessary();
        return dequeueStack.pop();
    }

    public int peek() {
        if (empty())
            throw new IllegalStateException("Queue is empty");

        transferIfNecessary();
        return dequeueStack.peek();
    }

    public boolean empty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    private void transferIfNecessary() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */