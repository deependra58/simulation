package assignment1;
/**
 *
 * @author Deependra Karki 
 * @student_id 12151622
 */
public class CustomerGroup {
   
    private int id;
    private int numberInGroup;
    private int arrivalTime;

    public CustomerGroup(int id, int numberInGroup, int arrivalTime) {
        this.id = id;
        this.numberInGroup = numberInGroup;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public int getNumberInGroup() {
        return numberInGroup;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "CustomerGroup{" + "id=" + id + ", numberInGroup=" + numberInGroup + ", arrivalTime=" + arrivalTime + '}';
    }
    
    
}
