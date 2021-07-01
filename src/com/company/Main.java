package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.company.Occupation.CEO;

public class Main {

    public static void main(String[] args) {
            List<Person> team = Arrays.asList(
                    new Person("Nikita", 21, CEO),
                    new Person("Ruslan", 22, CEO),
                    new Person("Dyadya Vanya", 60, Occupation.CLEANING_LADY),
                    new Person("Bob Martin", 46, Occupation.DEVELOPER),
                    new Person("Fred Brooks", 47, Occupation.DEVELOPER),
                    new Person("Maks", 21, CEO)
            );
// task 1 - get number of CEOs
            Long ceo_num = null;
            ceo_num = team.stream().filter(s -> s.getOccupation() == CEO).count();
            System.out.println("We have " + ceo_num + " CEOs running the business!");

//// task 2 - get max age in team
            Integer max_age = null;
            max_age = team.stream().mapToInt(Person::getAge).max().getAsInt();
            System.out.println("\nThe oldest person in team is only " + max_age);
//// task 3 - get all team members per position, except CEO
            Map<Occupation, List<Person>> positions = Arrays.stream(Occupation.values())
                    .filter(e -> !e.equals(Occupation.CEO))
                    .collect(Collectors.toMap(e -> e, e -> team.stream().filter(s -> s.getOccupation() == e).collect(Collectors.toList())));

            positions.forEach((occupation, team_members) -> System.out.println(occupation + ": " + team_members));
//// task 4- Удалить из списка все дублирующиеся значения (оставить только уникальные)
            Integer numbers[] = {1, 2, 5, 3, 5, 2, 1, 1, 4, 7, 3, 2};
            Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));

            System.out.println("\nУникальные значения " + uniqueNumbers);
//// task 5 - Сделать реверс числа (из 12345 в 54321)  num = 12345
            int num = 12345;
            StringBuilder sb = new StringBuilder();
            sb.append(num);
            sb = sb.reverse();
            num = Integer.parseInt(sb.toString());
            System.out.println("\nРеверс числа 12345 = " + num);
//// task 6 - Скопировать структуру из d1 в d2.
            //d1 = {"data": {"number": 1}}
            //d2 = d1.clone
//// task 7 - Выведите все елементы первого списка, которых нет во втором
            String[] l1 = {"White", "Black", "Red"};
            String[] l2 = {"Red", "Green"};
            List<String> list1 = new ArrayList(Arrays.asList(l1));
            List<String> list2 = new ArrayList(Arrays.asList(l2));

            list1.removeAll(list2);
            List<String> resultArray = list1;
            System.out.println("\nEлементы первого списка, которых нет во втором " + resultArray);
//// task 8 - Отсортировать список словарей по ключу 'x'
//            //    l = ["x": 4}, {"x": 2}, {"x": 1}, {"x": 3}]
//            //   newL = sorted(l, key=lambda k: k['x']
//
////task 9 - Вывести все уникальные имена из листа, результат должен быть в апперкейсе. пример: ["PETER","PAUL","STEVE"]
            List<PersonAge> personList = new ArrayList<>();
            personList.add(new PersonAge("Peter", "Patterson", 21));
            personList.add(new PersonAge("Peter", "Patterson", 21));
            personList.add(new PersonAge("Paul", "Walker", 31));
            personList.add(new PersonAge("Steve", "Runner", 41));
            personList.add(new PersonAge("Arnold", "", -1));
            personList.add(new PersonAge(" ", "Stevenson", 19));
            personList.add(new PersonAge("Arnold", "Stevenson", 19));
            personList.add(null);
            personList.add(new PersonAge("Aaron", "Bortnicker", 18));


            List<String>uniqueName = personList.stream()
                    .filter(s->s!=null)
                    .map(s->s.getName().toUpperCase())
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println("Unique name" + uniqueName);
    }
}
