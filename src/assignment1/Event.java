package assignment1;

import java.util.Random;

/**
 * An abstract event class with abstract process method.
 * Each event implements their own process method.
 *
 * @author Deependra Karki
 */
public abstract class Event {

    private int time;

    static Random generator = new Random(1);

    /**
     * Abstrct process method
     *
     * @param shopmodel- Shop model that processes event.
     * @param scheduler- Scheduler that schedules event.
     */
    public abstract void process(ShopModel shopmodel, IScheduler scheduler);

    /**
     * Class constructor that initializes the event time.
     *
     * @param time- Time of event.
     */
    public Event(int time) {
        this.time = time;
    }

    /**
     * Returns event time.
     *
     * @return- Time of an event.
     */
    public int getTime() {
        return time;
    }

    /**
     * Returns randomly generated number using the seed.
     *
     * @return- Randomly generated number.
     */
    public static Random getGenerator() {
        return generator;
    }
}
