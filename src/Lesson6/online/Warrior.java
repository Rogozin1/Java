package Lesson6.online;

import Lesson6.models.Player;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 20.12.2021
 */

public class Warrior extends Player {
    private int defence;
    private int strength;

    public Warrior(String name, int health, int defence, float speed, int strength, String gender) {
        super(name, health, speed, gender);
//        this.name = name;
//        this.health = health;
//        this.speed = speed;
//        this.level = 1;
//        this.gender = gender;
        this.strength = strength;
        this.defence = strength * level + 2;
//        System.out.println("11");
    }

    @Override
    public void attack() {
        System.out.println(name + " attack enemy on " + strength * level);
    }

    @Override
    public void getDamage(int incomingDamage) {
        float tmpDmg = incomingDamage - defence / 2;
        health -= tmpDmg;
        System.out.println(name + " get damage is " + tmpDmg);
    }

    public void methodW() {
        System.out.println("methodW");
    }



}
