package main.java;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class WorkingWithQueues {
    public static void main(String[] args) {
//        queues(supermarket);
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("Alex", 21));
        linkedList.add(new Person("Alexa", 22));
        linkedList.addFirst(new Person("Ali", 18));
        linkedList.addLast(new Person("Bob", 23));

        ListIterator<Person> personListIterator = linkedList.listIterator(); // LinkedList to ListIterator
        while (personListIterator.hasNext()) {
            System.out.println(personListIterator.next());
        }
        System.out.println();
        while (personListIterator.hasPrevious()) {
            System.out.println(personListIterator.previous());
        }
//        linkedList.forEach(System.out::println);

    }

    private static void queues() {
        Queue<Person> supermarket = new LinkedList<Person>();
        supermarket.add(new Person("Alex", 21));
        supermarket.add(new Person("Mariam", 18));
        supermarket.add(new Person("Ali", 40));

        System.out.println(supermarket.size()); // The numbers of elements in this collection
        System.out.println(supermarket.peek()); // the head of this queue
        System.out.println(supermarket.poll()); // Retrieves and remove the head of this queue
        System.out.println(supermarket.size());
        System.out.println(supermarket.peek());
    }

    static record Person(String name, int age){}
}
