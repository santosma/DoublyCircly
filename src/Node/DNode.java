/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Node;

/**
 *
 * @author Miguel S
 */
public class DNode<E> {
    private E data;
    private DNode<E> prev, next;

    public DNode(E data, DNode<E> prev, DNode<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public DNode<E> getNext() {
        return next;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }

    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }
}
