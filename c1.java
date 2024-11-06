
package hw12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class c1 extends Application {
    
    final String url = "C:\\Users\\Danny\\OneDrive - Rancho Santiago Community College District\\Documents\\NetBeansProjects\\HW12\\rainfall.db";
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rainfall");
        
        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(10);
        
        Label lblOne = new Label("January:");
        TextField field1 = new TextField();
        
        Label lblTwo = new Label("February:");
        TextField field2 = new TextField();
        
        Label lblThree = new Label("March:");
        TextField field3 = new TextField();
        
        Label lbl4 = new Label("April:");
        TextField field4 = new TextField();
        
        Label lbl5 = new Label("May:");
        TextField field5 = new TextField();
        
        Label lbl6 = new Label("June:");
        TextField field6 = new TextField();
        
        Label lbl7 = new Label("July:");
        TextField field7 = new TextField();
        
        Label lbl8 = new Label("August:");
        TextField field8 = new TextField();
        
        Label lbl9 = new Label("September:");
        TextField field9 = new TextField();
        
        Label lbl10 = new Label("October:");
        TextField field10 = new TextField();
        
        Label lbl11 = new Label("November:");
        TextField field11 = new TextField();
        
        Label lbl12 = new Label("December:");
        TextField field12 = new TextField();
        
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        
        pane.add(lblOne, 0, 0);
        pane.add(field1, 1, 0);
        pane.add(lblTwo, 0, 1);
        pane.add(field2, 1, 1);
        pane.add(lblThree, 0, 2);
        pane.add(field3, 1, 2);
        pane.add(lbl4, 0, 3);
        pane.add(field4, 1, 3);
        pane.add(lbl5, 0, 4);
        pane.add(field5, 1, 4);
        pane.add(lbl6, 0, 5);
        pane.add(field6, 1, 5);
        pane.add(lbl7, 0, 6);
        pane.add(field7, 1, 6);
        pane.add(lbl8, 0, 7);
        pane.add(field8, 1, 7);
        pane.add(lbl9, 0, 8);
        pane.add(field9, 1, 8);
        pane.add(lbl10, 0, 9);
        pane.add(field10, 1, 9);
        pane.add(lbl11, 0, 10);
        pane.add(field11, 1, 10);
        pane.add(lbl12, 0, 11);
        pane.add(field12, 1, 11);
        
        pane.add(submitButton, 0, 12);
        pane.add(cancelButton, 1, 12);
        
        submitButton.setOnAction(e->
        {
            String j = field1.getText();
            String f = field2.getText();
            String m = field3.getText();
            String a = field4.getText();
            String m1 = field5.getText();
            String june1 = field6.getText();
            String july1 = field7.getText();
            String august1 = field8.getText();
            String september1 = field9.getText();
            String october1 = field10.getText();
            String november1 = field11.getText();
            String december1 = field12.getText();
            
            double january = Double.parseDouble(j);
            double february = Double.parseDouble(f);
            double march = Double.parseDouble(m);
            double april = Double.parseDouble(a);
            double may = Double.parseDouble(m1);
            double june = Double.parseDouble(june1);
            double july = Double.parseDouble(july1);
            double august = Double.parseDouble(august1);
            double september = Double.parseDouble(september1);
            double october = Double.parseDouble(october1);
            double november = Double.parseDouble(november1);
            double december = Double.parseDouble(december1);
            
            double average = (january + february + march + april
                    + may + june + july + august 
                    + september + october + november + december) / 12;
            
            double totalRainfall = january + february + march + april
                    + may + june + july + august 
                    + september + october + november + december;
            
            System.out.println("Total Rainfall: " + totalRainfall);
            System.out.println("Average Rainfall: " + average);
            
            primaryStage.hide();
            insertData(average, totalRainfall);
        }
        
        );
        
        
        Scene scene = new Scene(pane, 300, 500);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void insertData(double average, double totalRainfall)
{
    String url = "jdbc:sqlite:C:/Users/Danny/OneDrive - Rancho Santiago Community College District/Documents/NetBeansProjects/HW12/rainfall.db";
    
    // Load the SQLite JDBC driver explicitly (optional)
    try {
        Class.forName("org.sqlite.JDBC");  // Explicitly load the SQLite JDBC driver
    } catch (ClassNotFoundException e) {
        System.out.println("SQLite JDBC driver not found.");
        e.printStackTrace();
        return;
    }
    
    String sql = "INSERT INTO rainfall (averageRainfall, totalRainfall) VALUES (?, ?)";
    
    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql))
    {
        // Set the values for the placeholders
        pstmt.setDouble(1, average);        // Set the first placeholder to 'average'
        pstmt.setDouble(2, totalRainfall);  // Set the second placeholder to 'totalRainfall'
        
        // Execute the insert statement
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Transported");
        
    } 
    catch (SQLException e)
    {
        System.out.println("Error inserting data: " + e.getMessage());
    } 
}


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
