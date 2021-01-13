import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    ZooClub zooClub = new ZooClub();
       void menu() {
        System.out.println();
        System.out.println(" Натисніть 1 щоб Додати учасника клубу\n" +
                " Натисніть 2 щоб Додати тваринку до учасника клубу\n" +
                " Натисніть 3 щоб Видалити тваринку з учасника клубу\n" +
                " Натисніть 4 щоб Видалити учасника з клубу\n" +
                " Натисніть 5 щоб Видалити конкретну тваринку зі всіх власників\n" +
                " Натисніть 6 щоб Вивести на екран зооклуб\n" +
                " Натисніть 7 щоб Вийти з програми");

         Scanner scanner = new Scanner(System.in);
         try{switch (scanner.nextInt()) {

             case 1: {
                 zooClub.addNewPerson();
                 break;
             }

             case 2: {
                 zooClub.addNewAnimalForSomePerson();
                 break;
             }

             case 3: {
                 zooClub.removeSomeAnimalFromSomePerson();
                 break;
             }

             case 4: {
                 zooClub.removeSomePerson();
                 break;
             }

             case 5: {
                 zooClub.removeAnimalFromAllPersons();
                 break;
             }

             case 6: {
                 zooClub.seeZooClub();
                 break;
             }

             case 7: {
                 System.exit(0);
                 break;
             }

             default: {
                 System.out.println("Оберіть команду зі списку!");
                 break;
             }
         }}
         catch (InputMismatchException exception){
             System.out.println("Ви взагалі не цифру вводите! Оберіть зі списку");
         }

     }

    public static void main(String[] args) {
         Application application = new Application();
         while (true){
             application.menu();
         }


    }
}
