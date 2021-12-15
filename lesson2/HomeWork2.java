package lesson2;

public class HomeWork2 {

    public static void main(String[] args) {

        System.out.println("Результат задания 1 - " + numberone(10, 15));
        System.out.println("***************");

        numbertwo(-20);
        System.out.println("***************");

        String result = (numberthree(20)) ? "Number is positive" : "Number is negative";
        System.out.println(result);
        System.out.println("***************");

        numberfour("Hello string" , 3);
        System.out.println("***************");

        int currentYear = 2024;
        System.out.println("Year " + currentYear + " is leap? > " + numberfive(currentYear));

    }

    /*
    1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.
    */
    public static boolean numberone(int first, int second) {
//        int sum = first + second;
//        return (sum <= 20) && (sum >= 10);
        return (first + second <= 20) && (first + second >= 10);
    }

    /*
    2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
    */
    public static void numbertwo(int variable) {
        if (variable >= 0) {
            System.out.println(variable + " is positive");
        } else {
            System.out.println(variable + " is negative");
        }
    }

    /*
    3. Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    */
    public static boolean numberthree(int variable) {
        return variable <= 0;
    }

    /*
4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
*/
    public static void numberfour(String value, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println("String #" + i + ": " + value);
        }
    }

    /*
    5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
    public static boolean numberfive (int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
     * в противном случае – false.
     * 2. Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль, положительное ли число передали или отрицательное.
     * Замечание: ноль считаем положительным числом.
     * 3. Написать метод, которому в качестве параметра передается целое число.
     * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     * 4. Написать метод, которому в качестве аргументов передается строка и число,
     * метод должен отпечатать в консоль указанную строку, указанное количество раз;
     * 5.* Написать метод, который определяет, является ли год високосным,
     * и возвращает boolean (високосный - true, не високосный - false).
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */

