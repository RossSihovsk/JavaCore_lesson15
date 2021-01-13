import java.lang.reflect.Array;
import java.util.*;
import java.util.Map;

public class ZooClub {

    Map<Person, ArrayList<Animal>> map = new HashMap<Person, ArrayList<Animal>>();


    Person usePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть імя учасника: ");
        String name = scanner.nextLine();
        System.out.println("Введіть вік учасника: ");
        int age = scanner.nextInt();
        Person person = new Person(name, age);
        return person;
    }

    Animal useAnimal() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введіть тип тваринки: ");
        String typeofAnimal = scanner1.nextLine();
        System.out.println("Введіть імя тваринки: ");
        String nameOfAnimal = scanner1.nextLine();
        Animal animal = new Animal(typeofAnimal, nameOfAnimal);
        return animal;
    }

    void addNewPerson() {

        Person person = usePerson();
        System.out.println("Оскільки в цей клуб можна вступити тільки якщо є хоча б одна тваринка то ви повинн ввести також і її данні");
        map.put(person, new ArrayList<>());

        Animal animal = useAnimal();

        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, ArrayList<Animal>> next = iterator.next();
            if (next.getKey().equals(person)) {
                ArrayList<Animal> value = next.getValue();
                value.add(animal);
                next.setValue(value);
            }
        }
        System.out.println("Ви успішно створили нового учасника клубу");
    }

     void addNewAnimalForSomePerson() {
         System.out.println("\n" + map + "\n");
         System.out.println("Виберіть кому бажаєте добавити нову тваринку:");
         Person person = usePerson();
         Animal animal = useAnimal();
         boolean temp = isPersonExist(person);
         if (temp) {
             Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
             while (iterator.hasNext()) {
                 Map.Entry<Person, ArrayList<Animal>> next = iterator.next();
                 if (next.getKey().equals(person)) {
                     ArrayList<Animal> value = next.getValue();
                     value.add(animal);
                     next.setValue(value);
                 }

             }
             System.out.println("Додавання пройшло успішно :)");
         }
         else {
             System.out.println("Такого учасника нема: ");
         }
     }

    void removeSomeAnimalFromSomePerson() {
        System.out.println("\n" + map+"\n");
        System.out.println("Виберіть у кого бажаєте видалити тваринку:");
        Person person = usePerson();
        System.out.println("Введіть данні тваринки яку бажаєте видалити: ");
        Animal animal = useAnimal();
        boolean temp = isAnimalInSomePersonExist(animal,person);
        if (temp){
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, ArrayList<Animal>> next = iterator.next();
            if (next.getKey().equals(person)) {
                ArrayList<Animal> value = next.getValue();
                value.remove(animal);
                next.setValue(value);
            }
        }
        System.out.println("Ви успішно видалили тваринку у певного учасника :( ");
    }
        else {
            System.out.println("Такого учасника або тваринки немає");
        }
    }


    void removeSomePerson() {
        System.out.println("\n" + map+"\n");
        System.out.println("Виберіть кого з учасників бажаєте видалити: ");
        Person person = usePerson();
        boolean temp = isPersonExist(person);

        if (temp){
        map.entrySet().removeIf(entry -> person.equals(entry.getKey()));
        System.out.println("Видалення учасника пройшло успішно :( ");
    }else {
            System.out.println("Нема такого учасника ");
        }
    }

    void removeAnimalFromAllPersons() {
        System.out.println("\n" + map + "\n");
        boolean temp = false;
        System.out.println("Виберіть який тип  тваринок бажаєте видалити у всіх учасників ");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
            ArrayList<Animal> animalList = nextMember.getValue();
            Iterator<Animal> iterator2 = animalList.iterator();
            while (iterator2.hasNext()) {
                Animal next2 = iterator2.next();
                if (next2.getTypeOfAnimal().equalsIgnoreCase(type)){
                    iterator2.remove();
                     temp = true;
                }
            }
        }
        if (temp){
            System.out.println("Видалення "+type+" у всіх учасників пройшло успішно :( ");
        }
        else {
            System.out.println("Видалення не відбулось. Немає такого типу тварин");
        }

    }

    void seeZooClub(){
        Set<Map.Entry<Person, ArrayList<Animal>>> allInZooClub = map.entrySet();
        System.out.println("\nСклад ЗооКлубу: ");
        for (Map.Entry<Person, ArrayList<Animal>> entry : allInZooClub) {
            System.out.println("У  " + entry.getKey() + " є " + entry.getValue());
        }
    }

    boolean isPersonExist(Person person){
        boolean flag = false;

        Set<Map.Entry<Person, ArrayList<Animal>>> zooClubMembers = map.entrySet();

        for (Map.Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
            if (entry.getKey().getName().equalsIgnoreCase(person.getName()) && entry.getKey().getAge() == person.getAge()) {
                flag = true;
            }
        }
        return flag;
    }

    boolean isAnimalInSomePersonExist(Animal animal, Person person){
        boolean flag = false;

        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

            if (nextMember.getKey().getName().equalsIgnoreCase(person.getName()) && nextMember.getKey().getAge() == person.getAge()) {
                ArrayList<Animal> animalList = nextMember.getValue();

                Iterator<Animal> iterator2 = animalList.iterator();

                while (iterator2.hasNext()) {
                    Animal next2 = iterator2.next();

                    if (next2.getTypeOfAnimal().equalsIgnoreCase(animal.getTypeOfAnimal()) && next2.getNameOfAnimal().equalsIgnoreCase(animal.getNameOfAnimal())) {
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }

}



