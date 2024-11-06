/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny
 */
public class c2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Student Tests");
        
        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(10);
        
        Label score1 = new Label("Score 1:");
        Label score2 = new Label("Score 2:");
        Label score3 = new Label("Score 3:");
        Label score4 = new Label("Score 4:");
        
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField();
        
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        
        pane.add(score1, 0, 0);
        pane.add(field1, 1, 0);
        pane.add(score2, 0, 1);
        pane.add(field2, 1, 1);
        pane.add(score3, 0, 2);
        pane.add(field3, 1, 2);
        pane.add(score4, 0, 3);
        pane.add(field4, 1, 3);
        
        pane.add(submitButton, 0, 4);
        pane.add(cancelButton, 1, 4);
        
        
        
        cancelButton.setOnAction(e -> 
        {
            primaryStage.close();
        });
        
        submitButton.setOnAction(e ->
        {
            primaryStage.hide();
            
            String test1 = field1.getText();
            String test2 = field2.getText();
            String test3 = field3.getText();
            String test4 = field4.getText();
            
            double value1 = Double.parseDouble(test1);
            double value2 = Double.parseDouble(test2);
            double value3 = Double.parseDouble(test3);
            double value4 = Double.parseDouble(test4);
            
            double average = (value1 + value2 + value3 + value4) / 4;
            
            char grade = letter(average);
            
            JOptionPane.showMessageDialog(null, "Average Score: " + average + "\nLetter Grade: " + grade);
        } 
        );
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static char letter(double average)
    {
        char l = ' ';
        
        if(average >= 90)
        {
            l = 'A';
        }
        else if (average <= 89 && average >= 80)
        {
            l = 'B';
        }
        else if (average <= 79 && average >= 70)
        {
            l = 'C';
        }
        else if (average <= 69 && average >= 60)
        {
            l = 'D';
        }
        else
        {
            l = 'F';
        }
        
        
        return l;
    }
    
}
