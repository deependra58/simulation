package assignment1;

import java.util.Random;

/**
 * @author Deependra Karki
 * @student_id 12151622
 */
public abstract class Event {

    private int time;

    static Random generator=new Random(1);

    public abstract void process(ShopModel shopmodel, IScheduler scheduler);

    public Event(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public static Random getGenerator() {
        return generator;
    }
}
