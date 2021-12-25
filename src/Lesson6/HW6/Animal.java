package Lesson6.HW6;

public abstract class Animal {

    static final int SWIM_FAIL = 0;                                                                   //2.4 не проплыло
    static final int SWIM_OK = 1;                                                                     //2.5 проплыло
    static final int SWIM_NONE = -1;                                                                  //2.6 не умеет

    private String type;                                                                              //1.1
    protected String name;                                                                            //1.2
    private float maxRun;                                                                             //1.3
    private float maxSwim;                                                                            //1.4

    public static int countAnimal = 0;                                                                //1.5

    Animal(String type, String name, float maxRun, float maxSwim) {                                   //1.6
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        ++countAnimal;                                                                                //1.7
    }

    String getName() {                     //1.8
        return this.name;
    }

    String getType() {                    //1.9
        return this.type;
    }

    float getMaxRun() {                   //2.0
        return this.maxRun;
    }

    float getMaxSwim() {                 //2.1
        return this.maxSwim;
    }


    protected boolean run(float distance) { //2.2
        return (distance <= maxRun);                             //2.3
    }

    protected int swim(float distance) {                     //2.7
        return (distance <= maxSwim) ? SWIM_OK : SWIM_FAIL;         //2.8
    }

}
