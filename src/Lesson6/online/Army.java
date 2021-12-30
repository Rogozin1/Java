package Lesson6.online;

import Lesson6.models.Player;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 20.12.2021
 */

public class Army {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior", 100, 35, 1.5f, 45, "Male");
        Archer archer = new Archer("Archer", 50, 100, 45, 65, 3.0f, "Female");
        Mage mage = new Mage("Mage", 30, 60, 5.5f, "Male");
        Titan titan = new Titan("Titan", 1000, 50, 10.9f, 500, "None");

        Player[] army = {warrior, archer, mage, titan};
        for (int i = 0; i < army.length; i++) {
            army[i].attack();
            army[i].run();
            army[i].getDamage(150);
            army[i].isAlive();

            if (army[i] instanceof Warrior) {
                ((Warrior) army[i]).methodW();
//                Warrior tmp = (Warrior) army[i];
//                tmp.methodW();
            } else {
                System.out.println("this is not Warrior");
            }

        }

//        byte a = 15;
//        int b = a;
//        System.out.println(b);
//
//        int b1 = 1024;
//        byte a1 = (byte) b1;
//        System.out.println(a1);

//        warrior.attack();
//        warrior.getDamage(900);
//        warrior.run();
//        System.out.println("Alive? " + warrior.isAlive());

//        archer.attack();
//        archer.getDamage(15);
//        archer.escapeFormBattle();
//        System.out.println("Alive? " + archer.isAlive());

//        mage.castFire();
//        mage.castIce();
//        mage.castFire();
//        mage.run();
//        mage.getDamage(100);
//        System.out.println("Alive? " + mage.isAlive());

//        titan.attack();
//        titan.getDamage(45);
//        titan.run();
//        titan.isAlive();
//        titan.doSomething();
    }
}
