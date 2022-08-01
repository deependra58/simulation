package assignment1;

import java.util.ArrayList;

/**
 * @author Deependra Karki
 * @student_id 12151622
 */
public class ShopModel {

    private ArrayList<CustomerGroup> groups = new ArrayList<CustomerGroup>();

    private ArrayList<CustomerGroup> history = new ArrayList<CustomerGroup>();

    private int nextId = 0;

    private int numGroups;

    private int numSeats;

    private int lostBusiness = 0;

    private int numServed = 0;

    public ShopModel(int numSeats) {
        this.numSeats = numSeats;
    }

    public void addGroup(CustomerGroup g) {
        groups.add(g);
    }

    public void logGroup(CustomerGroup g) {
        System.out.printf("t=%d: Group %d <%d people> arrived.\n", g.getArrivalTime(), g.getId(), g.getNumberInGroup());
        history.add(g);
    }

    public int getNextId() {
        return nextId++;
    }

    public int getLostBusiness() {
        return lostBusiness;
    }

    public int getNumServed() {
        return numServed;
    }

    public void showGroups() {
        System.out.println("\nThe following groups are in the shop:");
        System.out.println("=====================================");
        for (CustomerGroup group : groups) {
            System.out.printf("Group %d (%d people) at t=%d\n", group.getId(), group.getNumberInGroup(), group.getArrivalTime());
        }
    }

    public void showLog() {
        System.out.printf("\nThe following groups are in the history/log:\n");
        System.out.println("============================================");
        for (CustomerGroup group : history) {
            System.out.printf("Group %d (%d people) at t=%d\n", group.getId(), group.getNumberInGroup(), group.getArrivalTime());
        }
    }

    public void serveOrder(int time, CustomerGroup g) {
        System.out.printf("t=%d: Order served for Group %d\n", time, g.getId());
    }

    public void leave(int time, CustomerGroup g) {
        System.out.printf("t=%d: Group %d leaves \n", time, g.getId());
        this.numSeats += g.getNumberInGroup();
        groups.remove(g);
        this.numGroups -= 1;
    }

    public boolean canSeat(int time, CustomerGroup group) {

        if (this.numSeats > group.getNumberInGroup()) {
            System.out.printf("t=%d: Group %d <%d people> seated.\n", time, group.getId(), group.getNumberInGroup());
            this.numSeats -= group.getNumberInGroup();
            this.numServed += group.getNumberInGroup();
            return true;
        } else {
            System.out.printf("t=%d: Group %d leaves as there are insufficient seats for the group.\n", group.getArrivalTime(), group.getId());
            this.lostBusiness += group.getNumberInGroup();
            return false;

        }
    }

    public void showStatistics() {
        System.out.printf("\nStatistics:\n");
        System.out.println("==============");
        System.out.printf("The number of people served=%d \n", this.getNumServed());
        System.out.printf("The lost business=%d people\n", this.getLostBusiness());

    }


}
