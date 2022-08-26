package assignment1;

/**
 * This class extends abstract event class and implements its process method to create customer group and schedule order event.
 *
 * @author Deependra Karki
 */
public class ArrivalEvent extends Event {

    private int groupLowerBound = 1;
    private int groupGeneratorBound = 4;
    private int orderLowerBound = 1;
    private int orderGeneratorBound = 5;

    /**
     * Class constructor to initialize arrival event with customer group arrival time.
     *
     * @param time- Time at what the group arrived.
     */
    public ArrivalEvent(int time) {
        super(time);
    }

    /**
     * Creates newly arrived customer group with random number in the range.
     * Adds the customer group to customer group list and log list.
     * Schedules order event.
     *
     * @param shopModel- Shop model that processes
     * @param scheduler- Scheduler to schedule next event.
     */
    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {

        CustomerGroup customerGroup = new CustomerGroup(shopModel.getNextId(), getGenerator().nextInt(this.groupGeneratorBound) + this.groupLowerBound, this.getTime());
        shopModel.logGroup(customerGroup);

        if (shopModel.canSeat(this.getTime(), customerGroup)) {
            shopModel.addGroup(customerGroup);
            Event orderEvent = new OrderEvent(customerGroup, customerGroup.getArrivalTime() + getGenerator().nextInt(this.orderLowerBound) + this.orderGeneratorBound);
            scheduler.schedule(orderEvent);
        }

        Event event = new ArrivalEvent(this.getTime() + 2);
        scheduler.schedule(event);

    }

}
