package com.lam.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {

    List<Person> personList = new ArrayList<>();
    List<List<Person>> lists = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // 创建训练集
        Person person01 = new Person("Lin", 32, "M981", "man");
        Person person02 = new Person("Ha", 45, "M982", "woman");
        Person person03 = new Person("Lli", 34, "M983", "man");
        Person person04 = new Person("Lie", 22, "M984", "man");
        Person person05 = new Person("Hao", 11, "M985", "woman");

        personList.add(person01);
        personList.add(person02);
        personList.add(person03);
        personList.add(person04);
        personList.add(person05);

        lists = personList.stream()
                .collect(Collectors.groupingBy(person -> person.name().toUpperCase().charAt(0)))
                .values().stream().toList();

//        personList.forEach(person -> {
////            char key = person.name().toLowerCase().charAt(0);
////            if(maps.containsKey(key)) {
////                maps.get(key).add(person);
////            } else {
////                maps.put(key, new ArrayList<>(List.of(person)));
//////                maps.put(key, Arrays.asList(person));  这里会报错，因为Arrays.asList会创建不可变的list
////            }
//            maps.computeIfAbsent(person.name().toLowerCase().charAt(0), ArrayList::new).add(person);
//        });
    }

//    @Test
//    void testMap() {
//        assertNotNull(maps);
//        assertTrue(maps.containsKey('l'));
//    }

    @Test
    void testFlatMap() {
        List<Person> newList = lists.stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(Person::age))
                .toList();

        assertEquals(11, newList.get(0).age());
        assertEquals("Hao", newList.get(0).name());
    }

    @Test
    void testFilter() {
        int result = personList.stream().filter(person -> person.age() < 20).toList().size();
        assertEquals(1, result);
    }

}
