import java.io.*;
import java.util.*;

public class Foods{
   public int calories;
   public int protein;
   public int carbs;
   public int fat;

   public Foods(){
      this.calories = 0;
   }

   public static void main(String[] args) throws IOException{


      //Old instances of chicken that's been cooked
      /*     Chicken reducedChicken1 = ChickenReduction.modifyChicken(new Chicken(804,14),
             new Chicken(537,14));
             Chicken reducedChicken2 = ChickenReduction.modifyChicken(new Chicken(678,14),
             new Chicken(537,14));     
             Chicken reducedChicken3 = ChickenReduction.modifyChicken(new Chicken(539,14),
             new Chicken(430,14));     
             Chicken reducedChicken4 = ChickenReduction.modifyChicken(new Chicken(817,14),
             new Chicken(661,14));     */

      //example chicken call to chicken Reduction
      /*  Chicken reducedChicken5 = ChickenReduction.modifyChicken(new Chicken(),
          new Chicken());  */    

      //     System.out.println(reducedChicken4.toString());
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter 1 for Chicken, 2 for Turkey");
      int foodType = scanner.nextInt();
      System.out.println("Please enter raw food weight, in grams");
      int rawWeight = scanner.nextInt();
      System.out.println("Please enter number of oil servings used");
      int oilServings = scanner.nextInt();
      System.out.println("Please enter cooked food weight, in grams");
      int cookedWeight = scanner.nextInt();
      System.out.println("Please enter the current date in format MM/DD/YY");
      String date = scanner.next();

      if(foodType == 2){
         Turkey raw = new Turkey((double)rawWeight,(double)oilServings);
         Turkey cooked = new Turkey((double)cookedWeight, (double)oilServings);
         Food reducedFood = Turkey.modifyTurkey(raw,cooked,date);
         System.out.println(reducedFood.toString());
      }
      else if(foodType == 1){
         Chicken raw = new Chicken((double)rawWeight,(double)oilServings);
         Chicken cooked = new Chicken((double)cookedWeight, (double)oilServings);
         Food reducedFood = Chicken.modifyChicken(raw,cooked,date);
         System.out.println(reducedFood.toString());
      }
   }
}
