import java.util.*;
import java.io.*;

public class ChickenReduction{

   private double reducedWeight;

   //  public static void ChickenReduction() throws IOException{
   //  public static void main(String[] args) throws IOException{

   //method to calculate the weight lost from cooking chicken
   //@return Chicken - returns cooked chicken macronutrients and calories
   //@param chickenRawChicken - raw chicken object
   //@param chickenCookedChicken - cooked chicken object
   /*
    * This program 
    *
    *
    */
   public static Chicken modifyChicken(Chicken chickenRawChicken, 
         Chicken chickenCookedChicken) throws IOException{

      int rawChickenWeight = chickenRawChicken.getChickenWeightGrams();
      int cookedChickenWeight = chickenCookedChicken.getChickenWeightGrams();

      double reducedWeight = (double)cookedChickenWeight/(double)rawChickenWeight;

      System.out.println();
      System.out.println("The chicken has reduced by a factor of " + reducedWeight);

      Chicken modifiedChicken = new Chicken();
      modifiedChicken.setCalories(chickenRawChicken.getChickenWeightGrams(), 
            chickenRawChicken.getOliveOilWeightGrams());
      modifiedChicken.setProtein((int)chickenRawChicken.getChickenWeightGrams());
      modifiedChicken.setChickenWeightGrams(chickenCookedChicken.getChickenWeightGrams());
      modifiedChicken.setOliveOilWeightGrams(chickenRawChicken.getOliveOilWeightGrams());

      PrintWriter printWriter1 = new 
         PrintWriter(new FileOutputStream(new File("FoodReductionFiles.txt/cookedChickenFile.txt"),true));
      printWriter1.append(cookedChickenWeight + " ");
      printWriter1.println();
      printWriter1.close();


      PrintWriter printWriter2 = new 
         PrintWriter(new FileOutputStream(new File("FoodReductionFiles.txt/rawChickenFile.txt"),true));
      printWriter2.append(rawChickenWeight + " ");
      printWriter2.println();
      printWriter2.close();


      PrintWriter printWriter3 = new 
         PrintWriter(new FileOutputStream(new File("FoodReductionFiles.txt/reductionChickenFile.txt"),true));
      printWriter3.append(reducedWeight + " ");
      printWriter3.println();
      printWriter3.close();

      File file3 = new File("FoodReductionFiles.txt/reductionChickenFile.txt");
      Scanner scanner1 = new Scanner("cookedChickenFile.txt");
      Scanner scanner2 = new Scanner("rawChickenFile.txt");
      Scanner scanner3 = new Scanner(file3);
      double reducedAverage = 0;
      double counter = 0;

      while(scanner3.hasNextDouble()){
         counter++;
         reducedAverage = reducedAverage + Double.parseDouble(scanner3.next());
      }

      double reducedAverageTotal = reducedAverage/counter;
      System.out.println("The average weight reduction when cooking chicken so far is: "
            + (reducedAverageTotal) + ", or " + ((int)(reducedAverageTotal*100)) + "%.");
      // System.out.println();
      System.out.println("Averaged over " + counter + " elements");
      System.out.println();



      return modifiedChicken;

   }


   /*      System.out.println("Please enter the weight of the raw chicken in grams: ");
           Scanner scanner = new Scanner(System.in);

           int chickenRaw = scanner.nextInt();

           System.out.println("Please enter the weight of the olive oil in grams");
           int oilWeight = scanner.nextInt();

           Chicken rawChicken = new Chicken(chickenRaw, oilWeight);

           PrintWriter printWriter1 = new 
           PrintWriter(new FileOutputStream(new File("cookedChickenFile.txt"),true));
           printWriter1.append(chickenRaw + " ");
           printWriter1.println();
           printWriter1.close();

           System.out.println("Please enter the weight of the cooked chicken in grams: ");
           int chickenCooked = scanner.nextInt();



           Chicken cookedChicken = new Chicken(chickenCooked, oilWeight);
           PrintWriter printWriter2 = new 
           PrintWriter(new FileOutputStream(new File("rawChickenFile.txt"),true));
           printWriter2.append(chickenCooked + " ");
           printWriter2.println();
           printWriter2.close();


           PrintWriter printWriter3 = new 
           PrintWriter(new FileOutputStream(new File("reductionFile.txt"),true));
           double reducedWeight = ((double)chickenCooked)/((double)chickenRaw);
           printWriter3.append(reducedWeight + " ");
           printWriter3.println();
           printWriter3.close();

           File file3 = new File("reductionFile.txt");
           Scanner scanner1 = new Scanner("cookedChickenFile.txt");
           Scanner scanner2 = new Scanner("rawChickenFile.txt");
           Scanner scanner3 = new Scanner(file3);
           double reducedAverage = 0;
           double counter = 0;

           while(scanner3.hasNextDouble()){
           counter++;
           reducedAverage = reducedAverage + Double.parseDouble(scanner3.next());
           }

           double reducedAverageTotal = reducedAverage/counter;
           System.out.println();
           System.out.println("The average weight reduction when cooking chicken so far is: "
           + (reducedAverageTotal) + ", or " + ((int)(reducedAverageTotal*100)) + "%.");
           System.out.println();
           System.out.println("Averaged over " + counter + " elements");

           } */
}




