import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class Container<E> {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] data;
    private int size;

    public Container() {
        this.data = EMPTY_ELEMENTDATA;
    }

    public Container(int initialSize) {
        if (initialSize > 0) {
            this.data = new Object[initialSize];
        } else if (initialSize == 0) {
            this.data = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal size: "+ initialSize);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E elem) {
        add(elem, this.data, this.size);
        return true;
    }

    private void add(E elem, Object[] data, int size) {
        if (size == data.length)
            data = increase(size + 1);
        data[size] = elem;
        this.size += 1;
    }

    private Object[] increase(int capacity) {
        if (data.length > 0 || data != EMPTY_ELEMENTDATA) {
            return data = Arrays.copyOf(data, capacity);
        } else {
            return data = new Object[1];
        }
    }

    @Nullable
    public E get(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Illegal index: "+ index);
        if (index >= size)
            return null;
        return (E) this.data[index];
    }

    @Nullable
    public E delete(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Illegal index: "+ index);
        if (index >= size)
            return null;
        E value = (E) data[index];
        final int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(data, index + 1, data, index, newSize - index);
        data[size = newSize] = null;
        return value;
    }

    public void print() {
        System.out.println("Size: " + size);
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}
