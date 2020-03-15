package com.practice.lambda.comparator;

public class MainMyComparator {
    public static void main(String[] args) {

        Person person1 = new Person(10, "A", "B");
        Person person2 = new Person(10, "X", "Y");

        MyComparator<Person> compareAge = (p1, p2) -> p1.getAge() - p2.getAge();
        MyComparator<Person> compareFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        MyComparator<Person> compareLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

        System.out.println(compareAge.compare(person1, person2));
        System.out.println(compareFirstName.compare(person1, person2));
        System.out.println(compareLastName.compare(person1, person2));

        System.out.println("\ncomparing(Function<T, Comparable> function)");

        MyComparator<Person> comparingAge = MyComparator.comparing(Person::getAge);
        MyComparator<Person> comparingFirstName = MyComparator.comparing(Person::getFirstName);
        MyComparator<Person> comparingLastName = MyComparator.comparing(Person::getLastName);

        System.out.println(comparingAge.compare(person1, person2));
        System.out.println(comparingFirstName.compare(person1, person2));
        System.out.println(comparingLastName.compare(person1, person2));

        System.out.println("\nthenComparing(MyComparator<E> cmp)");

        System.out.println(compareAge
                .thenComparing(compareFirstName)
                .thenComparing(compareLastName)
                .compare(person1, person2));

        System.out.println("\nthenComparing(Function<E, Comparable> cmp)");

        System.out.println(compareAge
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getLastName)
                .compare(person1, person2));

    }
}
