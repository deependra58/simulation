package assignment1;

/**
 * This class stores customer group information that has ever arrived at the shop.
 *
 * @author Deependra Karki
 */
public class CustomerGroup {

    private int id;
    private int numberInGroup;
    private int arrivalTime;

    /**
     * Class constructor that initializes customer group.
     *
     * @param id-Customer group ID
     * @param numberInGroup- No. of people in the customer group.
     * @param arrivalTime-   Time at which the customer group arrived.
     */
    public CustomerGroup(int id, int numberInGroup, int arrivalTime) {
        this.id = id;
        this.numberInGroup = numberInGroup;
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns ID of a customer group.
     *
     * @return- Customer group ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns no. of people in customer group.
     *
     * @return- No. of people in customer group.
     */
    public int getNumberInGroup() {
        return numberInGroup;
    }

    /**
     * Returns arrival time of a customer group.
     *
     * @return- customer group arrival time.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Returns customer group information such as ID, no. of people, and arrival time of a group.
     *
     * @return- Customer group information.
     */
    @Override
    public String toString() {
        return "CustomerGroup{" + "id=" + id + ", numberInGroup=" + numberInGroup + ", arrivalTime=" + arrivalTime + '}';
    }


}
