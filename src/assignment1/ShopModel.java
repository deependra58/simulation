package assignment1;

import java.util.ArrayList;
/**
 *
 * @author Deependra Karki 
 * @student_id 12151622
 */
public class ShopModel {
    
     private ArrayList<CustomerGroup> groups=new ArrayList<CustomerGroup>();
     
     private ArrayList<CustomerGroup> history=new ArrayList<CustomerGroup>();
     
     private int nextId=0;
     
     private int numGroups;
     
     public void addGroup(CustomerGroup g){
         groups.add(g);
     }
     
     public void logGroup(CustomerGroup g){
         history.add(g);
     }
     
     public int getNextId(){
         return nextId++;
     }
     
     public void showGroups()
     {
         System.out.println("\nThe following groups are in the shop:");
         System.out.println("=====================================");
         for(CustomerGroup group:groups){
            System.out.printf("Group %d (%d people) at t=%d\n",group.getId(),group.getNumberInGroup(),group.getArrivalTime());
         }
     }
     
     public void showLog()
     {
         System.out.printf("\nThe following groups are in the history/log:\n");
         System.out.println("============================================");
         for(CustomerGroup group:history){
            System.out.printf("Group %d (%d people) at t=%d\n",group.getId(),group.getNumberInGroup(),group.getArrivalTime());
         }
     }
     
}
