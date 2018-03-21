import java.util.*;
import java.io.*;
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GuiFoods extends Application{
   private TextField tfRawFoodWeight = new TextField();
   private TextField tfCookedFoodWeight = new TextField();
   private TextField tfOilServings = new TextField();
   private TextField tfDate = new TextField();
   private TextField tfModifiedFoodWeight = new TextField();
   private TextField tfModifiedCalories = new TextField();
   private TextField tfModifiedCaloriesPerGram = new TextField();
   private TextField tfModifiedProteinPerGram = new TextField();
   private Button btCalculate = new Button("Calculate");
   private int selection = 0;

   @Override
      public void start(Stage primaryStage){

         //Create Master Pane
         BorderPane masterPane = new BorderPane();

         //Create UI
         GridPane gridPane = new GridPane();
         gridPane.setHgap(10);
         gridPane.setVgap(10);
         gridPane.add(new Label("Raw Food Weight(grams):"), 0, 0);
         gridPane.add(tfRawFoodWeight,1,0);
         gridPane.add(new Label("Cooked Food Weight(grams):"), 0, 1);
         gridPane.add(tfCookedFoodWeight, 1,1);
         gridPane.add(new Label("Servings of Olive Oil used:"), 0,2);
         gridPane.add(tfOilServings, 1,2);
         gridPane.add(new Label("Date Cooked:"),0,3);
         gridPane.add(new Label("Cooked Food Weight:"),0,4);
         gridPane.add(tfModifiedFoodWeight, 1,4);
         gridPane.add(tfDate, 1,3);
         gridPane.add(new Label("Cooked Food Calories:"), 0, 5);
         gridPane.add(tfModifiedCalories, 1,5);
         gridPane.add(new Label("Cooked Calories per 100 grams"), 0, 6);
         gridPane.add(tfModifiedCaloriesPerGram,1,6);
         gridPane.add(new Label("Cooked Protein per 100 grams"), 0,7);
         gridPane.add(tfModifiedProteinPerGram, 1, 7);
         gridPane.add(btCalculate, 1, 8);

         //UI for radio buttons
         HBox paneForRadioButtons = new HBox();
         paneForRadioButtons.setPadding(new Insets(40,15,0,15));
         RadioButton rbChicken = new RadioButton("Chicken ");
         RadioButton rbTurkey = new RadioButton("Turkey ");
         paneForRadioButtons.getChildren().addAll(rbChicken, rbTurkey);
         masterPane.setTop(paneForRadioButtons);
         paneForRadioButtons.setAlignment(Pos.CENTER);

         ToggleGroup group = new ToggleGroup();
         rbChicken.setToggleGroup(group);
         rbTurkey.setToggleGroup(group);

         rbChicken.setOnAction(e -> {
               if(rbChicken.isSelected()){
               int selection = 1;
               }
               });

         rbTurkey.setOnAction(e -> {
               if(rbTurkey.isSelected()){
               int selection = 0;
               }
               });

         //adding gridPane to masterPane
         masterPane.setCenter(gridPane);

         //set properties for UI
         gridPane.setAlignment(Pos.CENTER);
         tfRawFoodWeight.setAlignment(Pos.BOTTOM_RIGHT);
         tfCookedFoodWeight.setAlignment(Pos.BOTTOM_RIGHT);     
         tfOilServings.setAlignment(Pos.BOTTOM_RIGHT);    
         tfDate.setAlignment(Pos.BOTTOM_RIGHT);
         tfModifiedFoodWeight.setAlignment(Pos.BOTTOM_RIGHT);
         tfModifiedFoodWeight.setEditable(false);
         tfModifiedCalories.setAlignment(Pos.BOTTOM_RIGHT);
         tfModifiedCalories.setEditable(false);
         tfModifiedCaloriesPerGram.setAlignment(Pos.BOTTOM_RIGHT);
         tfModifiedCaloriesPerGram.setEditable(false);
         tfModifiedProteinPerGram.setAlignment(Pos.BOTTOM_RIGHT);
         tfModifiedProteinPerGram.setEditable(false);

         GridPane.setHalignment(btCalculate, HPos.RIGHT);

         btCalculate.setOnAction(e -> {
               try{
               if(group.getSelectedToggle() == rbChicken){
               foodModifyChicken();
               } else if(group.getSelectedToggle() == rbTurkey){
               foodModifyTurkey();
               }
               } catch(IOException f){
               System.out.println("exception thrown");
               }
               });

         Scene scene = new Scene(masterPane, 700,400);
         primaryStage.setTitle("Food Weight Reduction Calculator");
         primaryStage.setScene(scene);
         primaryStage.show();
      }

   private void foodModifyChicken() throws IOException{
      double rawFoodWeight = Double.parseDouble(tfRawFoodWeight.getText());
      double cookedFoodWeight = Double.parseDouble(tfCookedFoodWeight.getText());
      double oilServings = Double.parseDouble(tfOilServings.getText());
      String date = tfDate.getText();

      Chicken rawChicken = new Chicken(rawFoodWeight, oilServings);
      Chicken cookedChicken = new Chicken(cookedFoodWeight, oilServings);

      Chicken modifyChicken = new Chicken();
      modifyChicken = Chicken.modifyChicken(rawChicken, cookedChicken, date);

      double modifyChickenProtein = modifyChicken.getProtein();
      System.out.println(modifyChickenProtein);

      tfModifiedFoodWeight.setText(modifyChicken.getWeightGrams() + " ");
      tfModifiedCalories.setText(modifyChicken.getCalories() + " ");
      tfModifiedCaloriesPerGram.setText((modifyChicken.getCalories() / 
               modifyChicken.getWeightGrams() * 100) + " ");
      System.out.println(modifyChicken.getProtein() + "protein is");
      tfModifiedProteinPerGram.setText(Double.toString(modifyChickenProtein/modifyChicken.getWeightGrams()*100));
      //  tfModifiedProteinPerGram.setText(((modifyChicken.getProtein())/
      //           (modifyChicken.getWeightGrams())) + " ");
      //    tfModifiedProteinPerGram.setText((modifyChicken.getProtein() / 
      //        modifyChicken.getWeightGrams()) + " ");
   }
   private void foodModifyTurkey() throws IOException{
      double rawFoodWeight = Double.parseDouble(tfRawFoodWeight.getText());
      double cookedFoodWeight = Double.parseDouble(tfCookedFoodWeight.getText());
      double oilServings = Double.parseDouble(tfOilServings.getText());
      String date = tfDate.getText();

      Turkey rawTurkey = new Turkey(rawFoodWeight, oilServings);
      Turkey cookedTurkey = new Turkey(cookedFoodWeight, oilServings);


      Turkey modifyTurkey = new Turkey();
      modifyTurkey = Turkey.modifyTurkey(rawTurkey, cookedTurkey, date);

      tfModifiedFoodWeight.setText(modifyTurkey.getWeightGrams() + " ");
      tfModifiedCalories.setText(modifyTurkey.getCalories() + " ");
      tfModifiedCaloriesPerGram.setText((modifyTurkey.getCalories() / 
               modifyTurkey.getWeightGrams()*100) + " ");
      tfModifiedProteinPerGram.setText((modifyTurkey.getProtein() / 
               modifyTurkey.getWeightGrams()*100) + " ");

   }



}
