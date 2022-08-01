package assignment1;

/**
 * @author Deependra Karki student_id 12151622
 */
public class OrderEvent extends Event {

    private CustomerGroup group;

    private int leaveLowerBound = 5;
    private int leaveGeneratorBound = 12;

    public OrderEvent(CustomerGroup group, int time) {
        super(time);
        this.group = group;
    }

    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {
        shopModel.serveOrder(this.getTime(), group);
        //Leave event
        Event leaveEvent = new LeaveEvent(group, this.getTime()+getGenerator().nextInt(this.leaveGeneratorBound) + this.leaveLowerBound);
        scheduler.schedule(leaveEvent);
    }

}
