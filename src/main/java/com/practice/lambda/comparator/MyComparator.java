package com.practice.lambda.comparator;

import java.util.function.Function;

@FunctionalInterface
public interface MyComparator<E> {

    static <T> MyComparator<T> comparing(Function<T, Comparable> function) {
        return (p1, p2) -> function.apply(p1).compareTo(function.apply(p2));
    }

    int compare(E e1, E e2);

    default MyComparator<E> thenComparing(MyComparator<E> cmp) {
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
    }

    default MyComparator<E> thenComparing(Function<E, Comparable> cmp) {
        return thenComparing(comparing(cmp));
    }
}
