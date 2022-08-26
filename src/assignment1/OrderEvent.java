package assignment1;

/**
 * This class extends abstract event class and implement its process method to serve order and create leave event.
 *
 * @author Deependra Karki
 */
public class OrderEvent extends Event {

    private CustomerGroup group;

    private int leaveLowerBound = 5;

    private int leaveGeneratorBound = 12;

    /**
     * Class constructor that initializes the customer group and time.
     *
     * @param group- Customer group to which the order is to be served.
     * @param time-  Time at what the order is served.
     */
    public OrderEvent(CustomerGroup group, int time) {
        super(time);
        this.group = group;
    }

    /**
     * Process order and schedules leave event.
     *
     * @param shopModel-Shop Model that process the order.
     * @param scheduler-Scheduler that schedules the leave event.
     */
    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {
        shopModel.serveOrder(this.getTime(), group);
        Event leaveEvent = new LeaveEvent(group, this.getTime() + getGenerator().nextInt(this.leaveGeneratorBound) + this.leaveLowerBound);
        scheduler.schedule(leaveEvent);
    }

}
