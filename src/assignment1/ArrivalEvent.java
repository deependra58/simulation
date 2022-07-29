package assignment1;

/**
 *
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
        shopModel.addGroup(customerGroup);
        System.out.printf("t=%d: group %d <%d people> arrived.\n", customerGroup.getArrivalTime(), customerGroup.getId(), customerGroup.getNumberInGroup());
        Event event = new ArrivalEvent(this.getTime() + 2);
        scheduler.schedule(event);

    }

}
