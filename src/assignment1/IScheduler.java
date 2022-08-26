package assignment1;

/**
 * This interface is implemented by the simulator class to schedule events in the event queue according to scheduled time.
 *
 * @author Deependra Karki
 */
public interface IScheduler {

    /**
     * Schedules the event in event queue.
     *
     * @param e- Event to schedule in the event queue.
     */
    public void schedule(Event e);
}
