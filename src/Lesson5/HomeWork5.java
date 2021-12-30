package Lesson5;

public class HomeWork5 {

   public static void main(String[] args) {

       Person mainEmployee = new Person("Иван", "Иванович", "Иванов",
               "8(111)000-00-00", "Test Manager", 10000, 1986);

       Person[] office = {
               mainEmployee,
               new Person("Семён", "Семёнович", "Семёнов",
                       "8(111)111-11-11", "Manager", 20000, 1976),
               new Person("Антон", "Антонович", "Антонов",
                       "8(111)222-22-22", "engineer", 30000, 1963),
               new Person("Светлана", "Юрьевна", "Светлова",
                       "8(111)333-33-33", "programmer", 40000, 1990),
               new Person("Наталия", "Валериевна", "Тарасова",
                       "8(111)444-44-44", "senior developer", 50000, 19830)
       };

       getOldPersonIntOffice(office);
       System.out.println("*****************");
       getOldPerson(office, 40);

   }

   private static void getOldPerson(Person[] office, int year) {
       for (int i = 0; i < office.length; i++)
           if (office[i].getAge() > year) {
               System.out.println(office[i].getFullInfo());
           }
   }

   private static void getOldPersonIntOffice(Person[] office) {
       System.out.println("All person: ");
       for (int i = 0; i < office.length; i++)
           System.out.println((i + 1) + " " + office[i].getFullInfo());
   }


}
