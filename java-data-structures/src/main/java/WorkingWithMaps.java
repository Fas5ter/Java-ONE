package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WorkingWithMaps {
    public static void main(String[] args) {
        Map<Person, Diamond> map = new HashMap<>();
//        map.put(new Person("Jamila", 21), new Diamond("African Diamond"));
        map.put(new Person("Jamila"), new Diamond("African Diamond"));
//        maps();
        System.out.println(new Person("Jamila").hashCode());
        System.out.println(new Person("Jamila").hashCode());
        System.out.println(map.get(new Person("Jamila")));
    }

    /*private static void maps() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1,  new Person("Juan", 25));
        map.put(2,  new Person("Cristian", 25));
        map.put(3,  new Person("Miriam", 25));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        map.remove(3);
        map.entrySet().forEach(x ->System.out.println(x.getValue()));
        map.forEach((key, person)->
                System.out.println(key + " - " + person));
        System.out.println(map.getOrDefault(3, new Person("default", 30)));
        System.out.println(map.values());
    }

    record Person(String name, int age) {}*/

    static class Person {
        public String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        /*@Override
        public int hashCode() {
            return Objects.hashCode(name);
        }*/
    }

    record Diamond(String name){}
}
