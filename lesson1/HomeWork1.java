package lesson1;

public class HomeWork1 {


    // 1. Создать пустой проект в IntelliJ IDEA, создать класс HomeWorkApp, и прописать в нем метод main().

    public static void main(String[] args) {

    printThreeWords();

        System.out.println("***************");
        if (checkSumSign(10, 15)) {
        System.out.println("Sum positive");
    } else {
        System.out.println("Sum negative");
    }

        System.out.println("***************");
        System.out.println(printColor(110));
//        System.out.println(printColor(50));

        System.out.println("***************");
        System.out.println(compareNumbers(20, 15));

}

    // 2. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //     3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
//     и инициализируйте их любыми значениями, которыми захотите.
//     Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
//     то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
    public static boolean checkSumSign(int a, int b) {
        return (a + b) >= 0;
    }

//    public static void check(int a, int b) {
//        int a = 999;
//        int b = 50;
//        int sum = a + b;
//        if (a + b >= 0) {
//            System.out.println("Sum positive");
//        } else {
//            System.out.println("Sum negative");
//        }
//    }

    // 4. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
// Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
// если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
// то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
    public static String printColor(int value) {
        if (value <= 0) {
            return "Red";
        } else if (value > 0 && value <= 100) {
            return "Yellow";
        } else {
            return "Green";
        }
    }

    // 5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
// Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static String compareNumbers(int a, int b) {
        if (a >= b) {
            return "a >= b";
        } else {
            return "a < b";
        }
    }

// 6. Методы из пунктов 2-5 вызовите из метода main() и посмотрите корректно ли они работают.


}

/**
 * 1. Создать пустой проект в IntelliJ IDEA, создать класс HomeWorkApp, и прописать в нем метод main().
 * 2. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
 * _Orange
 * _ Banana
 * _ Apple
 * 3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
 * Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
 * то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
 * 4. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
 * Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
 * если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
 * если больше 100 (100 исключительно) - “Зеленый”;
 * 5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
 * и инициализируйте их любыми значениями, которыми захотите.
 * Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
 * 6. Методы из пунктов 2-5 вызовите из метода main() и посмотрите корректно ли они работают.
 */









//         printThreeWords();
//     }
//     public static void printThreeWords() {
//         System.out.println("Orange");
//         System.out.println("Banana");
//         System.out.println("Apple");
//        System.out.println("***************");
//     }


//        printcheckSumSign();
//    }
//    public static void printcheckSumSign() {
//        int a = 10;
//        int b = 20;
//        int result = a + b;
//        if (result >= 0) {
//            System.out.println("Сумма положительная");
//        } else {
//            System.out.println("Сумма отрицательная");
//        }
//        System.out.println("***************");
//    }


//    printprintColor();
//        }
//    public static void printprintColor() {
//        int value = -100;
//        if (value <= 0) {
//            System.out.println("Красный");
//        }
//        if (value > 0 && value <= 100) {
//            System.out.println("Желтый");
//        }
//        if (value > 100) {
//            System.out.println("Зеленый");
//        }
//        System.out.println("***************");
//    }

//        printcompareNumbers();
//    }
//    public static void printcompareNumbers() {
//        int a = 50;
//        int b = 20;
//        if (a >= b) {
//            System.out.println("a >= b");
//        } else {
//            System.out.println("a < b");
//        }
//        System.out.println("***************");
//    }