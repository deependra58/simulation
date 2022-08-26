package assignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class models the customer groups that have ever arrived in the simulation.
 *
 * @author Deependra Karki
 */
public class ShopModel {

    private ArrayList<CustomerGroup> groups = new ArrayList<CustomerGroup>();

    private ArrayList<CustomerGroup> history = new ArrayList<CustomerGroup>();

    private int nextId = 0;

    private int numGroups;

    private int numSeats;

    private int lostBusiness = 0;

    private int numServed = 0;

    /**
     * Class constructor specifying number of seats in the shop.
     *
     * @param numSeats- Number of seats in the shop.
     */

    public ShopModel(int numSeats) {
        this.numSeats = numSeats;
    }

    /**
     * Adds the customer group to the customer group list.
     *
     * @param g- Customer group to add to customer group list.
     */
    public void addGroup(CustomerGroup g) {
        groups.add(g);
    }

    /**
     * Adds the customer group to the customer log list.
     *
     * @param g- Customer group to add to customer log list.
     */
    public void logGroup(CustomerGroup g) {
        System.out.printf("t=\t%d: Group %d <%d people> arrived.\n", g.getArrivalTime(), g.getId(), g.getNumberInGroup());
        history.add(g);
    }

    /**
     * Returns the result of customer group ID after incrementing by 1
     *
     * @return- Customer group ID after incrementing current group ID by 1
     */

    public int getNextId() {
        return nextId++;
    }

    /**
     * Returns the no. of lost business in the shop.
     *
     * @return- No. of lost business
     */
    public int getLostBusiness() {
        return lostBusiness;
    }

    /**
     * Returns the no. of people served by the shop.
     *
     * @return- No. of people served.
     */
    public int getNumServed() {
        return numServed;
    }

    /**
     * Writes the customer groups that are currently in the shop to a file.
     *
     * @param wr- File in which the customer group that are in the shop is written.
     * @throws IOException- If the file cannot be written for any reason.
     */
    public void showGroups(FileWriter wr) throws IOException {

        wr.write("\nThe following groups are in the shop:");
        wr.write("\n=====================================\n");
        for (CustomerGroup group : groups) {
            wr.write("Group \t" + group.getId() + " (" + group.getNumberInGroup() + " people) at t=" + group.getArrivalTime() + "\n");
        }
    }

    /**
     * Writes the customer groups that were in the shop to a file.
     *
     * @param wr- File in which the customer group that are in the shop is written.
     * @throws IOException- If the file cannot be written for any reason.
     */
    public void showLog(FileWriter wr) throws IOException {

        wr.write("\nThe following groups are in the history/log:");
        wr.write("\n=====================================\n");
        for (CustomerGroup group : history) {
            wr.write("Group \t" + group.getId() + " (" + group.getNumberInGroup() + " people) at t=" + group.getArrivalTime() + "\n");
        }
    }

    /**
     * Prints the customer group and time at which the order is served.
     *
     * @param time- Time at what the customer group is served.
     * @param g-    Customer group that is served.
     */

    public void serveOrder(int time, CustomerGroup g) {
        System.out.printf("t=\t%d: Order served for Group %d.\n", time, g.getId());
    }

    /**
     * Prints the customer group and time at which the customer left the shop.
     * Increases the seat number by no. of people in the group that left the shop.
     * Removes customer group from the customer group list.
     *
     * @param time- Time at what the customer left the shop.
     * @param g-    Customer group that left the shop.
     */
    public void leave(int time, CustomerGroup g) {
        System.out.printf("t=\t%d: Group %d leaves \n", time, g.getId());
        this.numSeats += g.getNumberInGroup();
        groups.remove(g);
        this.numGroups -= 1;
    }

    /**
     * Checks if the customer group can stay or leave.
     *
     * @param time-  Time at which the customer group arrived.
     * @param group- Customer group that arrived in the shop.
     * @return- true if number of seats is greater or equal to no. of people in arriving customer group else returns false.
     */
    public boolean canSeat(int time, CustomerGroup group) {

        if (this.numSeats >= group.getNumberInGroup()) {
            System.out.printf("t=\t%d: Group %d <%d people> seated.\n", time, group.getId(), group.getNumberInGroup());
            this.numSeats -= group.getNumberInGroup();
            this.numServed += group.getNumberInGroup();
            return true;
        } else {
            System.out.printf("t=\t%d: Group %d leaves as there are insufficient seats for the group.\n", group.getArrivalTime(), group.getId());
            this.lostBusiness += group.getNumberInGroup();
            return false;
        }
    }

}
