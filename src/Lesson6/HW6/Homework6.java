package Lesson6.HW6;
/** Из всех моих вариантов выполнения Д/з6, вариант преподавателя - лучший!
 *  Поэтому сдаю Д/з с пошаговым разбором и мелкими добавками.
 */
public class Homework6 {

    public static void main(String[] args) {                                                                      //4.5

        String tempWinEvent = " это получилось";                                                                  //4.6
        String tempLossEvent = " это не получилось";                                                              //4.7
        String eventName;                                                                                         //4.8
        String eventResult;                                                                                       //4.9

        Cat cat1 = new Cat("Барсик", 200, 1);                                              //5.1
        Cat cat2 = new Cat("Мурзик", 200, 1);                                              //........
        Dog dog1 = new Dog("Тузик", 500, 10);                                               //....
        Dog dog2 = new Dog("Бобик", 500, 10);                                              //.....

        Animal[] animals = {cat1, cat2, dog1, dog2};                                                              //5.2

        float runLength = 150;                                                                                    //5.3
        float swimLength = 10;                                                                                    //5.4

        for (int i = 0; i < animals.length; i++) {                                                                //5.4
            String nameString = animals[i].getType() + " " + animals[i].getName() + " может ";                    //5.5

            eventName = "пробежать на " + animals[i].getMaxRun() + " м. Пытается пробежать на ";                  //5.6
            eventResult = animals[i].run(runLength) ? tempWinEvent : tempLossEvent;                               //5.7
            result(nameString, eventName, runLength, eventResult);                                                //5.8

            int swimResult = animals[i].swim(swimLength);                                                         //5.9
            eventName = "проплыть на " + animals[i].getMaxSwim() + " м. Попытка проплыть на ";                    //6.1
            eventResult = (swimResult == Animal.SWIM_OK) ? tempWinEvent : tempLossEvent;                          //6.2

            if (swimResult == Animal.SWIM_NONE)                                                                   //6.3
                eventResult = " котик утонул, т.к. не умеет плавать";                                             //6.4
            result(nameString, eventName, swimLength, eventResult);                                               //6.5
        }
                                                                                                                  //6.6
        System.out.println("Было животных     = " + Animal.countAnimal + "   котов = " + Cat.countCat + "    собак = " + Dog.countDog);
        System.out.println("Осталось животных = " + Dog.countDog + "   котов = " + 0 + "    собак = " + Dog.countDog);
    }



    private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + " м и" + resultEvent);                              //5.9
    }
}




