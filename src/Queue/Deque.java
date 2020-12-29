/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

interface Deque<T> {
    public T removeFront() throws Exception;

    public T removeRear() throws Exception;

    public void addFront(T x) throws Exception;

    public void addRear(T x) throws Exception;

    public boolean empty();

    public int size();
}