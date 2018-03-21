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


public class Chicken extends Food{
   private double weightGrams;
   private double calories;
   private double protein;
   private double oilServings;
   private double oilCalories;
   private double proteinPerGram =  0.205357142857143;
   private double caloriesPerGram = 0.982142857142857;
   private double caloriesPerServingOil = 130;


   //no-arg Chicken constructor
   public Chicken(){
      setCalories(0,0);
      setWeightGrams(0);
      setOilServings(0);
      setProtein(0);     
      setOilCalories(0);
   }

   public Chicken(double weightGrams, double oilServings){
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


   public static Chicken modifyChicken(Chicken rawFood, Chicken cookedFood, String date)
      throws IOException{
         double rawChickenWeight = rawFood.getWeightGrams();
         double cookedChickenWeight = cookedFood.getWeightGrams();

         double reducedWeight = cookedChickenWeight/rawChickenWeight;

         System.out.println();
         System.out.println("The chicken has reduced by a factor of " + reducedWeight);

         Chicken modifiedChicken = new Chicken();
         modifiedChicken.setCalories(rawFood.getWeightGrams(), 
               cookedFood.getOilServings());
         modifiedChicken.setProtein((rawFood.getWeightGrams()));
         modifiedChicken.setWeightGrams(cookedFood.getWeightGrams());
         modifiedChicken.setOilServings(rawFood.getOilServings());

         PrintWriter printWriter1 = new 
            PrintWriter(new FileOutputStream(new 
                     File("FoodReductionFiles.txt/cookedChickenFile.txt"),true));
         printWriter1.append(cookedChickenWeight + " ");
         printWriter1.println();
         printWriter1.close();


         PrintWriter printWriter2 = new 
            PrintWriter(new FileOutputStream(new
                     File("FoodReductionFiles.txt/rawChickenFile.txt"),true));
         printWriter2.append(rawChickenWeight + " ");
         printWriter2.println();
         printWriter2.close();


         PrintWriter printWriter3 = new 
            PrintWriter(new FileOutputStream(new 
                     File("FoodReductionFiles.txt/reductionChickenFile.txt"),true));
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

         PrintWriter printWriter4 = new 
            PrintWriter(new FileOutputStream(new 
                     File("FoodReductionFiles.txt/reductionChickenFileWithDate.txt"),true));
         printWriter4.append(reducedWeight + " " + date);
         printWriter4.println();
         printWriter4.close();



         double reducedAverageTotal = reducedAverage/counter;
         System.out.println();
         System.out.println("The average weight reduction when cooking chicken so far is: "
               + (reducedAverageTotal) + ", or " + ((int)(reducedAverageTotal*100)) + "%.");
         System.out.println();
         System.out.println("Averaged over " + counter + " elements");
         return modifiedChicken;
      }


   @Override
      public String toString(){
         return "This instance of chicken has: \n"  + this.getCalories() + 
            " calories \n" + this.getProtein() + " grams of protein \n" + 
            "weighs " +this.getWeightGrams() + " grams \n" + 
            "and uses " + this.getOilServings() + " servings of olive oil";
      }













   /*   //chicken constructor for no input of oliveoil
   //@param boolean lazy - parameter to indicate whether
   // or not lazy measuring was used for olive oil.
   //if true, add 14g oil, if false, add 0 calories
   public Chicken(int chickenGrams, boolean lazy){
   this.setOliveOilWeightGrams(0);
   this.setChickenWeightGrams(chickenGrams);
   if(lazy == true){
   this.setOliveOilWeightGrams(14);
   this.setCalories(chickenGrams, 14);
   }
   else if(lazy == false){
   this.setCalories(chickenGrams, 0);
   }
   this.setProtein(chickenGrams);
   }

   public Chicken(int chickenGrams, int oliveOilGrams){
   this.setChickenWeightGrams(chickenGrams);
   this.setOliveOilWeightGrams(oliveOilGrams);
   this.setCalories(chickenGrams, 14);
   this.setProtein(chickenGrams);
   } */













   /*   //method to return the weight of the chicken in grams
        public int getChickenWeightGrams(){
        return this.chickenWeightGrams;
        }

   //method to set the weight of the chicken in grams
   public void setChickenWeightGrams(int grams){
   this.chickenWeightGrams = grams;
   }

   //method to return weight of olive oil in grams
   public int getOliveOilWeightGrams(){
   return this.oliveOilWeightGrams;
   }

   //method to set the weight of the olive oil used in grams
   public void setOliveOilWeightGrams(int grams){
   this.oliveOilWeightGrams = grams;
   }

   //method to get the calories of the chicken
   public double getCaloriesChicken(){
   return this.calories;
   }

   //method to set calories of chicken
   public void setCalories(int chickenWeight, int oliveOilWeight){
   this.calories = (int)((((double)chickenWeight) * caloriesPerGram) +
   (((double)oliveOilWeight)*caloriesPerGramOil));
   }

   //method to return protein
   public double getProtein(){
   return this.protein;
   }


   //method to set protein of chicken
   //@param int chickenWeight - weight of chicken
   public void setProtein(int chickenWeight){
   this.protein = ((double)chickenWeight)*proteinPerGram;
   }


   public static String printUsage(){
   return "Chicken's parameters are Chicken(int chickenWeight, int oliveOilWeight) \n"
   + "If olive oil was not measured, use Chicken(int chickenWeight, true) \n"
   + "If olive oil was not used, use Chicken(int chickenWeight, false)";
   }

   @Override
   public String toString(){
   return "This instance of chicken has: \n"  + this.getCaloriesChicken() + 
   " calories \n" + this.getProtein() + " grams of protein \n" + 
   "weighs " +this.getChickenWeightGrams() + " grams \n" + 
   "and uses " + this.getOliveOilWeightGrams() + " grams of olive oil";
   }

    */

}
