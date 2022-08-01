package assignment1;

import java.util.ArrayList;

/**
 * @author Deependra Karki
 * @student_id 12151622
 */

public class Simulator implements IScheduler {

    private ArrayList<Event> events = new ArrayList<Event>();

    private int clock = 0;

    private ShopModel model;

    public Simulator(ShopModel model) {
        this.model = model;
    }

    public void initialize(ArrayList<Event> events) {
        this.events = events;
    }

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

    @Override
    public void schedule(Event e) {

        //Adding event to empty queue
        if (this.events.size() < 1) {
            this.events.add(e);
            return;
        }

        //Iterating over the events queue to place in correct index position maintaining the correct order
        for (int i = 0; i < this.events.size(); i++) {
            if (e.getTime() < this.events.get(i).getTime()) {
                this.events.add(i, e);
                return;
            }
        }

        //Adding event to the queue when the new events time is greater than existing events time in queue
        this.events.add(e);
    }


}
