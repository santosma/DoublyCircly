/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Miguel S
 */
class ArrayDeque<T> implements Deque<T> {
	private T data[];
	private int front, rear, size, capacity;

	public ArrayDeque() {
		capacity = 1000;
		data = (T[]) new Object[capacity];
		front = size = 0;
		rear = 1;
	}

	public ArrayDeque(int c) {
		capacity = c;
		data = (T[]) new Object[capacity];
		front = size = 0;
		rear = 1;
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size == 0;
	}

	public void addFront(T x) throws Exception {
		if (size() == capacity)
			throw new Exception("Deque Full");
		data[front--] = x;
		if (front < 0)
			front = capacity - 1;
		size++;
	}

	public void addRear(T x) throws Exception {
		if (size() == capacity)
			throw new Exception("Deque Full");
		data[rear++] = x;
		if (rear == capacity)
			rear = 0;
		size++;
	}

	public T removeFront() throws Exception {
		if (empty())
			throw new Exception("Deque Empty");
		front = front + 1;
		if (front == capacity)
			front = 0;
		size--;
		return data[front];
	}

	public T removeRear() throws Exception {
		if (empty())
			throw new Exception("Deque Empty");
		rear = rear - 1;
		if (rear == -1)
			rear = capacity - 1;
		size--;
		return data[rear];
	}

	// methods for testing purposes
	public String toString() {
		int i, j;
		String ans = "";
		for (i = 0, j = front + 1; i < size; i++, j++) {
			if (j == capacity)
				j = 0;
			ans += data[j];
			if (i < size - 1) ans += " -> ";
		}
		return ans;
	}

}