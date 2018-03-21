import java.awt.*;
import java.util.*;
import java.io.*;

public abstract class Food{

   private double weightGrams;
   private double calories;
   private double protein;
   private double oilServings;
   private double oilCalories;
   private double proteinPerGram;
   private double caloriesPerGram;
   private double caloriesPerGramOil = 9.285714285714286;


   public Food(){
      setCalories(0,0);
      setWeightGrams(0);
      setOilServings(0);
      setProtein(0);
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

   //method to get the calories of the food
   public double getCalories(){
      return this.calories;
   }

   //method to set calories of food
   public void setCalories(double weightGrams, double oilServings){
      this.calories = (weightGrams * caloriesPerGram) + (oilServings * caloriesPerGramOil);
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

     @Override
      public String toString(){
         return "This instance of food has: \n"  + this.getCalories() + 
            " calories \n" + this.getProtein() + " grams of protein \n" + 
            "weighs " +this.getWeightGrams() + " grams \n" + 
            "and uses " + this.getOilServings() + " grams of olive oil";
      }

}
