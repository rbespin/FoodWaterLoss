/* Robert Espinoza 
 *  2/26/18
 *  
 *  The purpose of this program is to create chicken objects to 
 * be used in other programs. Chicken.java initializes the 
 * weights of the chickens, as well as calories and basic 
 * macronutrients.
 *
 */
import java.util.*;
import java.io.*;


public class Turkey extends Food{
   private double weightGrams;
   private double calories;
   private double protein;
   private double oilServings;
   private double oilCalories;
   private double proteinPerGram =  0.205357142857143;
   private double caloriesPerGram = 0.982142857142857;
   private double caloriesPerServingOil = 130;


   //no-arg Chicken constructor
   public Turkey(){
      setCalories(0,0);
      setWeightGrams(0);
      setOilServings(0);
      setProtein(0);     
      setOilCalories(0);
   }

   public Turkey(double weightGrams, double oilServings){
      setCalories(weightGrams, oilServings);
      setWeightGrams(weightGrams);
      setOilServings(oilServings);
      setProtein(weightGrams);     
      setOilCalories(oilServings);
   }
   //method to return the weight of the food in grams
   public double getWeightGrams(){
      return this.weightGrams;
   }

   //method to set the weight of the chicken in grams
   public void setWeightGrams(double grams){
      this.weightGrams = grams;
   }

   //method to return weight of olive oil in grams
   public double getOilServings(){
      return this.oilServings;
   }

   //method to set the weight of the olive oil used in grams
   public void setOilServings(double servings){
      this.oilServings = servings;
   }

   //method to get calories from oil
   public double getOilCalories(){
      return this.oilCalories;
   }

   //method to set calories from oil
   public void setOilCalories(double oilServings){
      this.oilCalories = oilServings * caloriesPerServingOil;
   }

   //method to get the calories of the food
   public double getCalories(){
      return this.calories;
   }

   //method to set calories of food
   public void setCalories(double weightGrams, double oilServings){
      this.calories = (weightGrams * caloriesPerGram) + (oilServings * caloriesPerServingOil);
   }

   //method to return protein
   public double getProtein(){
      return this.protein;
   }


   //method to set protein of food
   //@param int weightGrams - weight of food
   public void setProtein(double weightGrams){
      this.protein = (weightGrams)*proteinPerGram;
   }


   public static Turkey modifyTurkey(Turkey rawFood, Turkey cookedFood, String date)
      throws IOException{
         double rawChickenWeight = rawFood.getWeightGrams();
         double cookedChickenWeight = cookedFood.getWeightGrams();

         double reducedWeight = cookedChickenWeight/rawChickenWeight;

         System.out.println();
         System.out.println("The turkey has reduced by a factor of " + reducedWeight);

         Turkey modifiedChicken = new Turkey();
         modifiedChicken.setCalories(rawFood.getWeightGrams(), 
               cookedFood.getOilServings());
         modifiedChicken.setProtein((rawFood.getWeightGrams()));
         modifiedChicken.setWeightGrams(cookedFood.getWeightGrams());
         modifiedChicken.setOilServings(rawFood.getOilServings());

         PrintWriter printWriter1 = new 
            PrintWriter(new FileOutputStream(new 
                     File("FoodReductionFiles.txt/cookedTurkeyFile.txt"),true));
         printWriter1.append(cookedChickenWeight + " ");
         printWriter1.println();
         printWriter1.close();


         PrintWriter printWriter2 = new 
            PrintWriter(new FileOutputStream(new 
                     File("FoodReductionFiles.txt/rawTurkeyFile.txt"),true));
         printWriter2.append(rawChickenWeight + " ");
         printWriter2.println();
         printWriter2.close();


         PrintWriter printWriter3 = new 
            PrintWriter(new FileOutputStream(new 
                     File("FoodReductionFiles.txt/reductionTurkeyFile.txt"),true));
         printWriter3.append(reducedWeight + " ");
         printWriter3.println();
         printWriter3.close();

         File file3 = new File("FoodReductionFiles.txt/reductionTurkeyFile.txt");
         Scanner scanner3 = new Scanner(file3);
         double reducedAverage = 0;
         double counter = 0;

         while(scanner3.hasNextDouble()){
            counter++;
            reducedAverage = reducedAverage + Double.parseDouble(scanner3.next());
         }

         PrintWriter printWriter4 = new 
            PrintWriter(new FileOutputStream(new 
                     File("FoodReductionFiles.txt/reductionTurkeyFileWithDate.txt"),true));
         printWriter4.append(reducedWeight + " " + date);
         printWriter4.println();
         printWriter4.close();

         double reducedAverageTotal = reducedAverage/counter;
         System.out.println();
         System.out.println("The average weight reduction when cooking Turkey so far is: "
               + (reducedAverageTotal) + ", or " + ((int)(reducedAverageTotal*100)) + "%.");
         System.out.println();
         System.out.println("Averaged over " + counter + " elements");
         return modifiedChicken;
      }



   @Override
      public String toString(){
         return "This instance of turkey has: \n"  + this.getCalories() + 
            " calories \n" + this.getProtein() + " grams of protein \n" + 
            "weighs " +this.getWeightGrams() + " grams \n" + 
            "and uses " + this.getOilServings() + " servings of olive oil";
      }


}
