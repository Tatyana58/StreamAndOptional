import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
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



}