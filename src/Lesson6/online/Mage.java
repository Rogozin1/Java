package Lesson6.online;

import Lesson6.models.Player;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 20.12.2021
 */

public class Mage extends Player {

    private int mana;

    private int costFire = 20;
    private int costIce = 40;


    public Mage(String name, float health, int mana, float speed, String gender) {
        super(name, health, speed, gender);
        this.mana = mana;
    }

    @Override
    public void attack() {
        System.out.println(name + " dont use attack");
    }

    public void castFire() {
        if (mana >= costFire) {
            mana -= costFire;
            System.out.println(name + " created Fire");
        } else {
            System.out.println(name + " not enougth mana > " + mana + "/" + costFire );
        }
    }

    public void castIce() {
        if (mana >= costIce) {
            mana -= costIce;
            System.out.println(name + " created Ice");
        } else {
            System.out.println(name + " not enougth mana > " + mana + "/" + costIce );
        }
    }

    public void methodM() {
        System.out.println("methodM");
    }


}
