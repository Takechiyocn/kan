package container.collection.queuebase;

import org.jetbrains.annotations.NotNull;
import org.omg.CosTrading.Link;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列:接口与实现分离
 *   接口：Queue<E>
 *   实现：
 *     a. 循环数组。高效，循环数组是一个有界集合，即容量有限。
 *     b. 链表。容量无限。
 */
public class QueueClass {

    public static void main(String[] args) {

        Queue<String> el = new LinkedList<>();
        // 尾端插入元素
        //  a. add:列表满了，抛出异常NoSuchElementException
        //  b. offer:列表满了，返回false
        el.add("e1");
        el.add("e2");
        el.add("e3");
        // 尾端插入元素
        el.offer("e4");
        System.out.println(el);

        // 前端删除元素：
        //  a. remove:列表为空，抛出异常NoSuchElementException
        //  b. poll:列表为空，返回null
        System.out.println(el.remove());
        System.out.println(el.poll());
        System.out.println(el);

        // 查找元素:从表前端
        //  a. element:列表为空，抛出异常NoSuchElementException
        //  b. peek:列表为空，返回null
        System.out.println(el.element());
        System.out.println(el);
        System.out.println(el.peek());
        System.out.println(el);

        el.poll();
        el.poll();
        el.poll();
        // 查找元素: element, 列表为空，抛出异常NoSuchElementException
        System.out.println(el.element());
    }
}

/**
 * 循环数组实现队列
 * @param <E>
 */
class CircleArrayQueue<E> implements Queue<E> {
    private int head;
    private int tail;
    private E[] elements;

    CircleArrayQueue(int capacity) {}

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}

/**
 * 链表实现队列
 * @param <E>
 */
class LinkedListQueue<E> implements Queue<E> {
    private Link head;
    private Link tail;

    LinkedListQueue() {}

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
