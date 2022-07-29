package assignment1;

import java.util.ArrayList;
/**
 *
 * @author Deependra Karki 
 * @student_id 12151622
 */
public class Simulator implements IScheduler {
    
    private ArrayList<Event> events=new ArrayList<Event>();
    
    private int clock=0;
    
    private ShopModel model;

    public Simulator( ShopModel model) {
        this.model = model;
    }
    
    public void initialize(ArrayList<Event> events){
        this.events=events;
    }
    
    public void run(int stopTime){
        if ((events == null)|| events.isEmpty() )
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

        // can we have a separate function to sort the events accoring to time ?
        this.events.add

        this.events.add(e);
    }
    
    
}
