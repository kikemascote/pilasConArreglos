package stack;

import java.lang.reflect.Array;
import java.util.Iterator;

public class Stack <T extends Comparable<T>> implements iStack<T>,Iterable<T> {
    private T[]data         = null;
    private Class<T> type   = null;
    private int cont        = 0;
    private int top         = -1;
    private int count       = 0;

    public Stack(Class<T> type){
        data = (T[]) Array.newInstance(type, 10);
        this.type = type;
    }
    public Stack(Class<T> type, int size){
        data = (T[])Array.newInstance(type,size);
        this.type=type;
    }


    @Override
    public Iterator iterator() {

        return new Iterator<T>() {
            int _count = top;
            @Override
            public boolean hasNext() {
                return _count>=0;
            }

            @Override
            public T next() {
                return data[_count--];
            }
        };
    }


    @Override
    public T pop() throws StackEmptyException {
        if (isEmpty()) throw new StackEmptyException("Pila vacia pariente!");
        T tmp = data[top--];
        //top--;
        count--;
        return tmp;
    }

    @Override
    public void push(T value) throws StackFullException {
        if (isFull()) throw new StackFullException("Pila llena primon!");
        data[++top] = value;
        count++;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public boolean isFull() {
        return (count==data.length);
    }

    @Override
    public T peek() throws StackEmptyException {
        if (isEmpty()) throw new StackEmptyException("Pila vacia pariente!");
        return data[top];

    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        top = -1;
        count =0;
    }


    @Override
    public T search(T value) throws StackEmptyException {
        if (isEmpty()) throw new StackEmptyException("Pila vacia viejon!");
        for(T a :data){
            if (a.equals(value))
                return a;
        }
        return null;
    }
}

