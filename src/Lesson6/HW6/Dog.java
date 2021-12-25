package Lesson6.HW6;

public class Dog extends Animal {                      //3.7

    public static int countDog = 0;                    //3.9
    public static String typeThisClass = "Пес";        //3.8

    Dog(String name, float maxRun, float maxSwim) {    //4.0
        super(typeThisClass, name, maxRun, maxSwim);   //4.1
        ++countDog;                                    //4.2
    }
}
