package com.practice.lambda.predicatechaining;

@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);

    default MyPredicate<T> and(MyPredicate<T> other){
        return t -> test(t) && other.test(t);
    }

    default MyPredicate<T> or(MyPredicate<T> other){
        return t -> test(t) || other.test(t);
    }
}
