package com.gw.myalgo.datastructure;

import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Single Linked list
 * @author hsden
 */
public class SingleLinkedList<E> implements List<E> {

    /**
     * size of the linked list, the default size is 0
     */
    private transient int size = 0;

    /**
     * head node of the linked list
     */
    private Node<E> headNode;

    /**
     * tail node of the linked list
     */
    private Node<E> tailNode;

    public SingleLinkedList(){

    }

    public SingleLinkedList(E firstItem) {
        Node<E> firstNode = new Node<E>(firstItem,null);
        this.headNode = firstNode;
        this.tailNode = firstNode;
        this.size += 1;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        boolean result = false;
        if(null == e){
            return result;
        } else {
            Node<E> newNode = new Node<E>(e,null);
            if(size == 0){
                this.headNode = newNode;
                this.tailNode = newNode;
            } else {
                this.tailNode.next = newNode;
                this.tailNode =newNode;
            }

            this.size += 1;
        }


        return result;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    /**
     * 正序打印List
     */
    public void printList() {
        if(this.size > 0) {
            Node<E> tmpNode = this.headNode;

            while(null != tmpNode) {
                System.out.print(tmpNode.item + "   ");
                tmpNode = tmpNode.next;
            }
            System.out.println();
        }
    }

    /**
     * 倒序打印列表， 递归实现
     */
    public void printListByRecursion() {
        if(this.size <= 0) {
            return;
        }

        printRecursion(this.headNode);
        System.out.println();
    }

    public void printRecursion(Node<E> head) {
        if(null == head) {
            return;
        }

        if(head.next != null) {
            printRecursion(head.next);
        }

        System.out.print(head.item + "  ");

    }


    /**
     * reverse the list
     * head->1->2->3->4->6->7，after reverse
     * head->7->6->5->4->3->2->1
     */
    public void simpleReverseList() {
        if(this.size <= 1) {
            return;
        }

        Node<E> newTailNode = headNode, tempHeadNextNode, tempTailNextNode;
        while(newTailNode.next != null){
            newTailNode = newTailNode.next;
        }

        while(headNode != newTailNode) {
            tempHeadNextNode = headNode.next;

            tempTailNextNode = newTailNode.next;
            newTailNode.next = headNode;
            newTailNode.next.next = tempTailNextNode;
            headNode = tempHeadNextNode;
        }
    }

    /**
     * reverse the list  就地逆序,需要记忆pre
     * head->1->2->3->4->6->7，after reverse
     * head->7->6->5->4->3->2->1
     */
    public void localReverseList() {
        if(size <= 1) {
            return;
        }

        Node<E> cur = headNode.next, pre = headNode, next;
        pre.next = null;
        while(cur!= null) {
            next = cur.next;

            headNode = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

    }

    /**
     * reverse the list by recursion  递归逆序
     * head->1->2->3->4->6->7，after reverse
     * head->7->6->5->4->3->2->1
     */
    public Node<E> recurseReverse(Node<E> head) {
            Node<E> newHead;
            if(null != head && head.next != null) {
                newHead = recurseReverse(head.next);

                head.next.next = head;
                head.next = null;

            } else {
                newHead = head;
            }

            return newHead;
    }


    public void recurseReverseList() {
        if(this.size <= 1) {
            return;
        }

        headNode =recurseReverse(headNode);
    }


    /**
     * reverse the list  插入逆序，每次插入最前面
     * head->1->2->3->4->6->7，after reverse
     * head->7->6->5->4->3->2->1
     */
    public void insertReverseList() {
        if(this.size <= 1) {
            return;
        }

        Node<E> cur = headNode.next, next;
        headNode.next = null;
        while(cur != null) {
            next = cur.next;

            cur.next = headNode;
            headNode = cur;
            cur = next;
        }
    }

    /**
     * 给定一个没有排序的链表，去掉其重复项 ， 并保留原顺序，
     * 例如链表 1->3->1->5->5->7,
     * 去掉重复项后变为 1->3->5->7
     */
    public void removeRepeatItemFromUnorderedListM1(){
        if(this.size <= 1) {
            return;
        }

        Node<E> cur = headNode.next, innerCur, pre = headNode;
        while(null != cur) {
            E curItem = cur.item;

            innerCur = headNode;
            while(null != innerCur && cur != innerCur) {
                if(innerCur.item.equals(curItem)) {
                    break;
                } else {
                    innerCur = innerCur.next;
                }
            }

            if(innerCur != null && cur != innerCur && innerCur.item.equals(cur.item)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

    }


    /**
     * 给定一个没有排序的链表，去掉其重复项 ， 并保留原顺序，
     * 例如链表 1->3->1->5->5->7,
     * 去掉重复项后变为 1->3->5->7
     *
     * 递归法
     */
    public void removeRepeatItemFromUnorderedListM2(){
        if(size <= 1) {
            return;
        }

        removeRepeatItemByRecursion(this.headNode);
    }

    public void removeRepeatItemByRecursion(Node<E> node) {
        if(null == node || null == node.next ) {
            return;
        } else {
            removeRepeatItemByRecursion(node.next);

            Node<E> next = node.next, pre=node;
            while(null != next) {
                if(node.item.equals(next.item)) {
                    pre.next = next.next;
                    break;
                }

                pre = next;
                next = next.next;
            }
        }
    }


    /**
     * 给定一个有序的链表，去掉其重复项 ， 并保留原顺序，
     * 例如链表 1->3->3->5->5->7,
     * 去掉重复项后变为 1->3->5->7
     *
     */
    public void removeRepeatItemFromOrderedListM1(){
        if(this.size <= 1) {
            return;
        }

        Node<E> cur = headNode.next, pre= headNode;
        while(cur != null) {
            if(cur.item.equals(pre.item)) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
    }
    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList<>(2);

        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(7);
        list.add(7);

        list.printList();
        list.removeRepeatItemFromOrderedListM1();
        list.printList();
    }


}

