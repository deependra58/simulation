package assignment1;

/**
 * @author Deependra Karki student_id 12151622
 */
public class OrderEvent extends Event {

    private CustomerGroup group;

    public OrderEvent(CustomerGroup group, int time) {
        super(time);
        this.group = group;
    }

    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {
        shopModel.serveOrder(group.getArrivalTime() + 1, group);
        //Leave event
        Event leaveEvent = new LeaveEvent(group, group.getArrivalTime() + 10);
        scheduler.schedule(leaveEvent);
    }

}
