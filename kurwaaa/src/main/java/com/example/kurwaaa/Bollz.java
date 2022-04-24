package com.example.kurwaaa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Bollz extends Application {

    @Override
    public void start(final Stage primaryStage) {

        /*Button button = new Button();
        button.setText("Open a New Window");


        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BallThread ball = new BallThread();
                System.out.println("pressed");
                ball.start();



                ball.setBall(root);
                System.out.println(Thread.activeCount());

            }
        });*/
        Pane root = new Pane();
        ButtonMenu button = new ButtonMenu();





        Scene scene = new Scene(root, 450, 250);
        button.toDo(root);
        primaryStage.setTitle("Boooooollzzz");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
