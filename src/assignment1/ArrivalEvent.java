package assignment1;

/**
 * @author Deependra Karki
 * @student_id 12151622
 */
public class ArrivalEvent extends Event {

    public ArrivalEvent(int time) {
        super(time);
    }

    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {
        CustomerGroup customerGroup = new CustomerGroup(shopModel.getNextId(), 2, this.getTime());
        shopModel.logGroup(customerGroup);

        if (shopModel.canSeat(this.getTime(), customerGroup)) {
            shopModel.addGroup(customerGroup);

            //Order Event after 1 time unit
            Event orderEvent = new OrderEvent(customerGroup, customerGroup.getArrivalTime() + 1);
            scheduler.schedule(orderEvent);
        }

        //Arrival Event after 2 time unit
        Event event = new ArrivalEvent(this.getTime() + 2);
        scheduler.schedule(event);

    }

}
