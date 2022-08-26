package assignment1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Deependra Karki
 * @student_id 12151622
 */
public class Assignment1 {

    public static void main(String[] args) throws IOException {

        ShopModel shopModel = new ShopModel(8);
        Simulator simulator = new Simulator(shopModel);
        ArrayList<Event> eventQueue = new ArrayList<Event>();
        //Events arriving at time 0
        Event event = new ArrivalEvent(0);
        eventQueue.add(event);
        simulator.initialize(eventQueue);
        System.out.printf("Simulation Trace:");
        System.out.printf("\n==================\n");
        simulator.run(20);

        File file = new File("statistics.txt");
        FileWriter wr = new FileWriter(file);
        wr.write("Statistics:\n");
        wr.write("==============\n");
        wr.write("The number of people served = " + shopModel.getNumServed() + "\n");
        wr.write("The lost business = " + shopModel.getLostBusiness() + " people\n");
        shopModel.showGroups(wr);
        shopModel.showLog(wr);
        wr.close();

    }

}
