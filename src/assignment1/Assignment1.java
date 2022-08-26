package assignment1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class contains a main method that initiates the simulation process and writes the simulation output to a file.
 *
 * @author Deependra Karki
 */
public class Assignment1 {

    /**
     * Creates and add first arrival event to event queue at time 0.
     * Simulator is passed an event queue.
     * Writes the simulation outputs to a file.
     *
     * @param args- Application startup arguments.
     * @throws IOException if the file cannot be created, or cannot be opened or cannot be written for any reason.
     */

    public static void main(String[] args) throws IOException {

        ShopModel shopModel = new ShopModel(8);
        Simulator simulator = new Simulator(shopModel);
        ArrayList<Event> eventQueue = new ArrayList<Event>();

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
