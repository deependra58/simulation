package assignment1;

/**
 * This class extends abstract event class and implements its process method to create leave event.
 *
 * @author Deependra Karki
 */
public class LeaveEvent extends Event {

    private CustomerGroup group;

    /**
     * Class constructor that initializes the customer group and time.
     *
     * @param g-    Customer group that is about to leave .
     * @param time- Time at what the customer group leaves.
     */
    public LeaveEvent(CustomerGroup g, int time) {
        super(time);
        this.group = g;
    }

    /**
     * Invokes shop model's leave method.
     *
     * @param shopmodel
     * @param scheduler
     */
    @Override
    public void process(ShopModel shopmodel, IScheduler scheduler) {
        shopmodel.leave(this.getTime(), group);
    }
}
