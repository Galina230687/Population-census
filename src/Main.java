import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long c = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("Несовершеннолетние: " + c);


        List<String> z = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() < 27)
                .filter(x -> x.getSex() == Sex.MAN)
                .map(Person::getFamily).toList();
        System.out.println("\nПризывники: " + z);


        Object w = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getSex() == Sex.MAN && x.getAge() < 65 ||
                        x.getSex() == Sex.WOMAN && x.getAge() < 60)
                .map(Person::getFamily)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("\nРаботоспособные: " + w);


    }
}










