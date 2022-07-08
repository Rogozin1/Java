package Lesson6.models;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 20.12.2021
 */

public abstract class Player {

    protected String name;
    protected float health;
    protected float speed;
    protected int level;
    protected String gender;

    public Player(String name, float health, float speed, String gender) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.level = 1;
        this.gender = gender;
//        System.out.println("1");
    }

    public abstract void attack();

    public void run() {
        System.out.println(name + " moved to speed " + speed);
    }

    public void getDamage(int incomingDamage) {
        health -= incomingDamage;
        System.out.println(name + " get damage " + incomingDamage + " point");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void doSomething() {
        System.out.println("I here");
    }
}
