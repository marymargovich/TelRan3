package telran.list.model;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import telran.list.interfaces.IList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList <E>  implements IList <E> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this(10); //пустой констуктор - чтобы обезопасить
        //от создания пустого эрея
    }

    public MyArrayList(int intialCapasity) {
        if (intialCapasity < 0)
            throw new IllegalArgumentException("Illegal capacity : " + intialCapasity);
        if (intialCapasity > MAX_ARRAY_SIZE)
            intialCapasity = MAX_ARRAY_SIZE;
        this.elements = new Object[intialCapasity];

    }


    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index);
        ensureCapacity();
        if (index < size)
            System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
        return true;
    }

    private void ensureCapacity() {
        if (size == MAX_ARRAY_SIZE)
            throw new OutOfMemoryError();
        if (size == elements.length) {
            int newCapacity = elements.length + elements.length / 2;
            if (newCapacity > MAX_ARRAY_SIZE || newCapacity < 0)
                newCapacity = MAX_ARRAY_SIZE;
            elements = Arrays.copyOf(elements, newCapacity);
        }

    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index);

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i]))
                    return i;

            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element == (elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        if (element != null) {
            for (int i = size-1; i >=0; i--) {
                if (element.equals(elements[i]))
                    return i;

            }
        } else {
            for (int i = size-1; i >=0; i--) {
                if (element == (elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        int numMoved = size - index -1;
        if( numMoved > 0){
            System.arraycopy(elements, index+1, elements, index, numMoved);
        }
        elements[size-1] = null;
        size--;
        return oldValue;
    }

    @Override
    public void clear() {

    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                if( !hasNext())
                    throw new NoSuchElementException();
                return (E)elements[cursor++];
            }
        };
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

