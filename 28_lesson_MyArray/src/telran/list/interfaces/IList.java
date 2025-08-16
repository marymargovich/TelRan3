package telran.list.interfaces;

public interface IList <E> extends Iterable <E> {
    // абстрактные методы
// типизация дженериком до рантайма
    //заменили все обжект на е элемент?
    //по дефолту - ПАБЛИК метод

    default boolean add(E element){
        return add(size(), element);
    };

    boolean add(int index, E element);

    E get(int index);

    int size();

    int indexOf(E element);//первый встретившийся элемент из одинаковых

    int lastIndexOf(E element);// последнее вхождение элемента

    E remove( int index); // возвращаем объект по индексу.
    // чтобы это объект сохранить в другом месте

    default boolean remove (E element){
        int index = indexOf(element);
        if (index>=0){
            remove(index);
            return true;
        }
        return false;
    };

    default boolean contains(E element){
        return indexOf(element)>=0;
    };//содержится ли объект в массиве

    void clear(); // очистка массива

    default boolean isEmpty(){
        return size()== 0;
    }; // проверяет массив на пустоту

    E set (int index, E element);// замещение элемента, остается тот же размер,
    // возвращаем замещенный элемент





















}
