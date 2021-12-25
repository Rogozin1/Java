package Lesson6.HW6;

public class Cat extends Animal {                                   //2.9

    public static int countCat = 0;                                 //3.2
    public static String typeThisClass = "Кот";                     //3.3

    Cat(String name, float maxRun, float maxSwim) {                 //3.4
        super(typeThisClass, name, maxRun, maxSwim);                //3.5
        ++countCat;                                                 //3.6
    }

    @Override                                                       //3.0
    protected int swim(float distance) {             //
        return Animal.SWIM_NONE;   //3.1
    }
}
