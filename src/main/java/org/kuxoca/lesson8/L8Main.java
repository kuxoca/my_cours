package org.kuxoca.lesson8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class L8Main {
    public static void main(String[] args) {
       /*
       1. Создайте массив с набором слов, и с помощью Stream API
       найдите наиболее часто встречающееся;
        */
        String[] arr = {"AA", "BB", "AA", "BGT", "CC", "CC", "CC"};
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(arr)
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum))
                .forEach((k, v) -> System.out.println(k + ": " + v));
      /*
      Создайте массив объектов типа Сотрудник (с полями Имя,
      Возраст, Зарплата) и вычислите среднюю зарплату сотрудника;
       */
        Emp[] emps = {
                new Emp("Alex", 20, 1000),
                new Emp("Lexa", 24, 2000),
                new Emp("Oleg", 29, 3000),
                new Emp("Kirill", 21, 4000),
        };
     /*
      Напишите метод, способный найти в массиве сотрудников из
      п. 2 найдите N самых старших сотрудников и отпечатает в
      консоль сообщение вида “N самых старших сотрудников зовут:
      имя1, имя2, имяN;”.
      */
        System.out.println(Arrays.stream(emps).mapToInt(el -> el.salary).average());
        System.out.println(Arrays.stream(emps)
                .sorted((o1, o2) -> o2.age - o1.age)
                .limit(3)
                .map(el -> el.name)
                .collect(Collectors.joining(",\n", "3 самых старших сотрудников зовут:\n", "")));
//                .forEach(System.out::println);
    }

    static class Emp {
        String name;
        Integer age;
        Integer salary;

        public Emp(String name, Integer age, Integer salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}