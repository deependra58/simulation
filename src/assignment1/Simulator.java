package assignment1;

import java.util.ArrayList;

/**
 *
 * @author Deependra Karki
 */
public class Simulator implements IScheduler {
    
    private ArrayList<Event> events=new ArrayList<Event>();
    
    private int clock=0;
    
    private ShopModel model;

    public Simulator( ShopModel model) {
        this.model = model;
    }
    
    public void initialize(ArrayList<Event> events){
        
    }
    
    public void run(int stopTime){
        if ((events == null)|| events.isEmpty() )
           return;
        
        Event e = events.remove(0);
        clock = e.getTime();
       
        while (clock <= stopTime) {
            e.process(model, this);// the this argument means that we are   
                                   // passing a reference to this simulator 
                                   // object to the event’s process method.
            e = events.remove(0);
            clock = e.getTime();
        }

        
    }

    @Override
    public void Schedule(Event e) {
        
    }
    
    
}
