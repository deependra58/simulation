package assignment1;

/**
 * @author Deependra Karki
 * @student_id 12151622
 */
public class ArrivalEvent extends Event {

    private int groupLowerBound = 1;
    private int groupGeneratorBound = 4;
    private int orderLowerBound = 1;
    private int orderGeneratorBound = 5;

    public ArrivalEvent(int time) {
        super(time);
    }

    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {

        //Create a group
        CustomerGroup customerGroup = new CustomerGroup(shopModel.getNextId(), getGenerator().nextInt(this.groupGeneratorBound) + this.groupLowerBound, this.getTime());
        //Adding incoming group to log
        shopModel.logGroup(customerGroup);

        if (shopModel.canSeat(this.getTime(), customerGroup)) {
            //Adding group to group list
            shopModel.addGroup(customerGroup);

            //Order Event after random time unit
            Event orderEvent = new OrderEvent(customerGroup, customerGroup.getArrivalTime() + getGenerator().nextInt(this.orderLowerBound) + this.orderGeneratorBound);
            scheduler.schedule(orderEvent);
        }

        //Arrival Event after 2 time unit
        Event event = new ArrivalEvent(this.getTime() + 2);
        scheduler.schedule(event);

    }

}
