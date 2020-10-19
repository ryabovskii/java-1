import org.jetbrains.annotations.Nullable;

import java.util.Arrays;


/**
 * Класс контейнер, позволяющий хранить произвольное количество объектов, реализованный через массив
 * @autor Дмитрий Рябовский
 * @version 1.0
 */
public class Container<E> {

    /** Константа пустого массива */
    private static final Object[] EMPTY_DATA = {};

    /** Поле массив */
    private Object[] data;
    /** Поле размер */
    private int size;

    /**
     * Конструктор - создание нового объекта
     * @see Container#Container(int)
     */
    public Container() {
        this.data = EMPTY_DATA;
    }

    /**
     * Конструктор - создание нового объекта с определенной емкостью
     * @param initialSize - начальная емкость
     * @see Container#Container()
     */
    public Container(int initialSize) {
        if (initialSize > 0) {
            this.data = new Object[initialSize];
        } else if (initialSize == 0) {
            this.data = EMPTY_DATA;
        } else {
            throw new IllegalArgumentException("Illegal size: "+ initialSize);
        }
    }

    /**
     * Функция получения значения поля {@link Container#size}
     * @return возвращает размер
     */
    public int size() {
        return size;
    }

    /**
     * Функция проверки поля size {@link Container#size}
     * @return возвращает (boolean) size == 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Функция добавления елемента в контейнер
     * (обекта в {@link Container#data} и увелечения {@link Container#size})
     * Вызывает функцию {@link Container#add(Object, Object[], int)}
     * @param elem  - элемент
     * @return возвращает true, если объект добавлен
     */
    public boolean add(E elem) {
        add(elem, this.data, this.size);
        return true;
    }

    /**
     * Функция добавления елемента в контейнер
     * (обекта в {@link Container#data} и увелечения {@link Container#size})
     * Внутренняя функция для {@link Container#add(Object)}
     * Вызывает функцию {@link Container#increase(int)}
     * @param elem  - элемент
     * @param data  - массив
     * @param size  - размер
     */
    private void add(E elem, Object[] data, int size) {
        if (size == data.length)
            data = increase(size + 1);
        data[size] = elem;
        this.size += 1;
    }

    /**
     * Функция увелечения емкости {@link Container#data}
     * Внутренняя функция для {@link Container#add(Object, Object[], int)}
     * @param capacity  - новая емкость
     */
    private Object[] increase(int capacity) {
        if (data.length > 0 || data != EMPTY_DATA) {
            return data = Arrays.copyOf(data, capacity);
        } else {
            return data = new Object[1];
        }
    }

    /**
     * Функция получения объекта по индексу
     * @param index  - индекс
     * в {@link Container#data}
     * @return объект (E) или null
     * @throws IllegalArgumentException Illegal index
     */
    @Nullable
    public E get(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Illegal index: "+ index);
        if (index >= size)
            return null;
        return (E) this.data[index];
    }

    /**
     * Функция удаления объекта по индексу
     * @param index  - индекс
     * в {@link Container#data} и уменьшения {@link Container#size}
     * Вызывает функцию {@link Container#delete(int, int)}
     * @return объект (E) или null
     * @throws IllegalArgumentException Illegal index
     */
    @Nullable
    public E delete(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Illegal index: "+ index);
        if (index >= size)
            return null;
        E value = (E) data[index];
        delete(size-1, index);
        return value;
    }

    /**
     * Функция удаления объекта по индексу
     * @param index   - индекс
     * @param newSize - новый размер
     * в {@link Container#data}
     * Внутренняя функция для {@link Container#delete(int)}
     */
    private void delete(final int newSize, int index) {
        if (newSize > index)
            System.arraycopy(data, index + 1, data, index, newSize - index);
        data[size = newSize] = null;
    }

    /**
     * Функция вывода в консоль размера контейнера и его элементы
     */
    public void print() {
        System.out.println("Size: " + size);
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

}
