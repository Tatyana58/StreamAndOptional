import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Person> personStream = Stream.of(new Person("Иван",17),
                    new Person("Сергей",61),
                    new Person("Василий",71),
                    new Person("Валентина",42));
        BiConsumer<Person, Person> biConsumer = (min, max) -> System.out.println(min.toString() + max.toString());
        Comparator<Person> personComparator=Comparator.comparing(Person::getAge).thenComparing(Person::getName);
        findMinMax(personStream,personComparator,biConsumer);
        findEvenNum(List.of(5,768,16,4,9,13,11,17,38,5));
    }
    public static<T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> List = stream.collect(Collectors.toList());
        if (List.isEmpty()) {
            minMaxConsumer.accept(null,null);
        }else {
            List.sort(order);
            minMaxConsumer.accept(List.get(0), List.get(List.size() - 1));
        }
    }
/*Задание 2
Реализуйте метод, который принимает на вход список целых чисел, определяет в списке количество четных чисел и выводит их в консоль.
Решите задание именно с применением Stream API.
Критерии проверки
Задача решена корректно.
Соблюден кодстайл.
Правильно реализован предикат.*/
    public static void findEvenNum(List<Integer> list) {
       Stream<Integer> stream = list.stream();
       Predicate<Integer> predicate = (s) -> (s % 2) == 0;
       Stream<Integer> integerStream = stream.filter(predicate);
        System.out.println("Количество четных чисел - "+integerStream.count());

    }
}