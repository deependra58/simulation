package assignment1;

import java.util.ArrayList;

/**
 *
 * @author Deependra Karki 
 * @student_id 12151622
 */
public class Assignment1V1 {
    
    public static void main(String[] args) {

        ShopModel shopModel = new ShopModel();
        Simulator simulator = new Simulator(shopModel);
        ArrayList<Event> eventQueue = new ArrayList<Event>();
        //Events arriving at time 0
        Event event=new ArrivalEvent(0);
        eventQueue.add(event);
        simulator.initialize(eventQueue);
        System.out.printf("Simulation Trace:");
        System.out.printf("\n==================\n");
        simulator.run(20);
        shopModel.showGroups();
        shopModel.showLog();
    }

}
