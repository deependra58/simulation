package assignment1;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Deependra Karki 
 * @student_id 12151622
 */

public class Assignment1V1 {
    
    public static void main(String[] args) throws IOException {

        ShopModel shopModel = new ShopModel(8);
        Simulator simulator = new Simulator(shopModel);
        ArrayList<Event> eventQueue = new ArrayList<Event>();
        //Events arriving at time 0
        Event event=new ArrivalEvent(0);
        eventQueue.add(event);
        simulator.initialize(eventQueue);
        System.out.printf("Simulation Trace:");
        System.out.printf("\n==================\n");
        simulator.run(20);
        shopModel.showStatistics();
//        shopModel.showGroups();
//        shopModel.showLog();
    }

}
