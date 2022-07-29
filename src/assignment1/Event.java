package assignment1;

/**
 * @author Deependra Karki
 * @student_id 12151622
 */
public abstract class Event {

    private int time;

    public abstract void process(ShopModel shopmodel, IScheduler scheduler);

    public Event(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
