package com.lam.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PersonTest {

    List<Person> personList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // 创建训练集
        Person person01 = new Person("Lin", 32, "M981", "man");
        Person person02 = new Person("Ha", 35, "M982", "woman");
        Person person03 = new Person("Lli", 34, "M983", "man");
        Person person04 = new Person("Lie", 22, "M984", "man");
        Person person05 = new Person("Hao", 31, "M985", "woman");

        personList.add(person01);
        personList.add(person02);
        personList.add(person03);
        personList.add(person04);
        personList.add(person05);
    }

    @Test
    void testNameWithL() {
        List<Person> personWithNameLList = personList.stream()
                .filter(person -> person.name().toUpperCase().contains("L"))
                .toList();
        assertThat(personWithNameLList.size(), is(3));
    }

    @Test
    void testAgeBiggerThanThirty() {
        /* *
         * Predicate<T>
         * 用于判断某个条件是否成立。
         * 抽象方法：boolean test(T t)
         * Predicate<Integer> isEven = x -> x % 2 == 0;
         * System.out.println(isEven.test(4)); // 输出：true
         * */
        Predicate<Person> isBiggerThanThirty = person -> person.age() > 30;
        assertThat(personList.stream().filter(isBiggerThanThirty).toList().size(), is(4));
    }

    @Test
    void testConsumer() {
        /* *
         * Consumer<T>
         * 接受一个参数并执行某些操作，无返回值。
         * 抽象方法：void accept(T t)
         * Consumer<String> printer = s -> System.out.println(s);
         * printer.accept("Hello, World!"); // 输出：Hello, World!
         * */
        Consumer<Person> personConsumer = person -> System.out.println("Meine Name ist " + person.name());
        personList.forEach(personConsumer);
    }

    @Test
    void testSupplier() {
        /**
         * 提供一个结果，无需输入。
         * 抽象方法：T get()
         * Supplier<Double> randomSupplier = () -> Math.random();
         * System.out.println(randomSupplier.get()); // 输出：随机数
         * * **/
        Supplier<Person> personSupplier = () -> new Person("Lin", 10, "M9810", "man");
        assertThat(personSupplier.get().ID(), is("M9810"));
    }

    @Test
    void testFunction() {
        /**
         * 接受一个参数，返回一个结果。
         * 抽象方法：R apply(T t)
         * Function<Integer, String> intToString = x -> "Number: " + x;
         * System.out.println(intToString.apply(5)); // 输出：Number: 5
         * */
        Function<String, Person> stringFunction = name -> new Person(name, 10, "XXXX", "man");
        assertThat(stringFunction.apply("Li").age(), is(10));
    }

    @Test
    void BiFunction() {
        /**
         * 接受两个参数，返回一个结果。
         * 抽象方法：R apply(T t, U u)
         * BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
         * System.out.println(sum.apply(3, 4)); // 输出：7
         * */
        BiFunction<String, Integer, Person> biFunction = (name, age) -> new Person(name, age, "XXXX", "man");
        assertThat(biFunction.apply("Hao", 31).age(), is(31));
        assertThat(biFunction.apply("Lie", 22).name(), is("Lie"));
    }
}