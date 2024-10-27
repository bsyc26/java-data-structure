 public interface Set<E> {
    // create method
     boolean add(E e);
     boolean addAll(Collection<? extends E> coll);

    // delete methods
     boolean remove(Object obj);
     boolean removeAll(Collection<?> coll);

     void clear();

    // readin methods
     int size();
     boolean isEmpty();
     boolean equals(Object obj);
     int hashCode();
     Iterator<E> iterator();

     boolean contains(Object obj);
     boolean containsAll(Collection<?> coll);

    // convert methods
     Object[] toArray();
     <T> T[] toArray(T[] arr); // returns an arr contains all elems in this set
}
