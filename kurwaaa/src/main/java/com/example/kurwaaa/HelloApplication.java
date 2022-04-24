package com.example.kurwaaa;

import java.util.Random;
import java.util.Set;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    Random rand = new Random();

    @Override
    public void start(Stage stage) {

        //initialize window
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
        stage.setTitle("Animated Ball");
        stage.setScene(scene);
        //create first ball
        Circle ball = new Circle(10, Color.rgb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
        ball.relocate(rand.nextInt(256), rand.nextInt(256));
        canvas.getChildren().add(ball);

        //create button
        Button b = new Button("button");
        canvas.getChildren().add(b);
        // button action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                System.out.println("pressed");
                //that thread thing
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        //create ball
                        System.out.println("Number of threads " + Thread.activeCount());
                        Circle ball = new Circle(10, Color.rgb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
                        ball.relocate(rand.nextInt(256), rand.nextInt(256));
                        canvas.getChildren().add(ball);

                        //update animation(or whatever its called)
                        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                                new EventHandler<ActionEvent>() {
                                    //velocity
                                    double dx = 5;
                                    double dy = 5;

                                    @Override
                                    public void handle(ActionEvent t) {
                                        //move the ball
                                        ball.setLayoutX(ball.getLayoutX() + dx);
                                        ball.setLayoutY(ball.getLayoutY() + dy);

                                        Bounds bounds = canvas.getBoundsInLocal();

                                        //If the ball reaches the left or right border make the step negative
                                        if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                                                ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){

                                            dx = -dx;

                                        }

                                        //If the ball reaches the bottom or top border make the step negative
                                        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){

                                            dy = -dy;

                                        }

                                    }
                                }));
                        //animation runs indefinitely until stop() is called
                        timeline.setCycleCount(Timeline.INDEFINITE);
                        timeline.play();
                        System.out.println("Number of threads " + Thread.activeCount());
                    }
                });
            }
        };

        // when button is pressed
        b.setOnAction(event);
        //show window
        stage.show();

        //first thread for first ball
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {
                    //velocity
                    double dx = 10;
                    double dy = 10;


                    @Override
                    public void handle(ActionEvent t) {
                        //move the ball
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        Bounds bounds = canvas.getBoundsInLocal();

                        //If the ball reaches the left or right border make the step negative
                        if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                                ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){

                            dx = -dx;


                            //updates but is it thread?


                        }

                        //If the ball reaches the bottom or top border make the step negative
                        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){

                            dy = -dy;

                        }

                    }
                }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();



    }


    public static void main(String[] args)  {
        System.out.println("Number of threads " + Thread.activeCount());
        launch();
        System.out.println("Number of threads " + Thread.activeCount());
    }
}
