package assignment1;

import java.util.ArrayList;

/**
 * This class implements IScheduler interface, runs the simulator and schedule the event.
 *
 * @author Deependra Karki
 */
public class Simulator implements IScheduler {

    private ArrayList<Event> events = new ArrayList<Event>();

    private int clock = 0;

    private ShopModel model;

    /**
     * Class constructor that initializes the shop model.
     *
     * @param model-Shop Model to the simulator.
     */
    public Simulator(ShopModel model) {
        this.model = model;
    }

    /**
     * Initializes the event queue for the first time.
     *
     * @param events- Arrival Event for simulation.
     */
    public void initialize(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * Checks if the event queue is empty or not.
     * If the event queue is not empty, event is removed from the queue and processed.
     * Events are processed if they arrive within stop time.
     *
     * @param stopTime- Time upto which the simulation runs.
     */
    public void run(int stopTime) {
        if ((events == null) || events.isEmpty())
            return;

        Event e = events.remove(0);
        clock = e.getTime();

        while (clock <= stopTime) {
            e.process(model, this);
            e = events.remove(0);
            clock = e.getTime();
        }
    }

    /**
     * Checks if the queue is empty and add the event to the empty queue.
     * Iterates over the event queue to schedule the incoming event in the event queue according to their scheduled time.
     *
     * @param e- Event to be added to the event queue.
     */
    @Override
    public void schedule(Event e) {

        if (this.events.size() < 1) {
            this.events.add(e);
            return;
        }

        for (int i = 0; i < this.events.size(); i++) {
            if (e.getTime() < this.events.get(i).getTime()) {
                this.events.add(i, e);
                return;
            }
        }

        this.events.add(e);
    }


}
