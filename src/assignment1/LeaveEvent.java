package assignment1;

public class LeaveEvent extends Event {

    private CustomerGroup group;

    public LeaveEvent(CustomerGroup g, int time) {
        super(time);
        this.group = g;
    }

    @Override
    public void process(ShopModel shopmodel, IScheduler scheduler) {
        shopmodel.leave(this.getTime(), group);
    }
}
