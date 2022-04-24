package com.example.kurwaaa;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    Random rand = new Random();

    @Override
    public void start(Stage stage) {


        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
        Circle ball = new Circle(10, Color.rgb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
        ball.relocate(rand.nextInt(256), rand.nextInt(256));

        canvas.getChildren().add(ball);

        stage.setTitle("Animated Ball");
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {
            //velocity
            double dx = 6;
            double dy = 2;


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
                    /*Thread t1 = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            System.out.println("aaa");
                            Circle ball = new Circle(10, Color.CADETBLUE);
                            ball.relocate(0, 0);




                        }
                    });
                    t1.start();*/

                    //updates but is it thread?
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            Circle ball = new Circle(10, Color.rgb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
                            ball.relocate(0, 0);

                            canvas.getChildren().add(ball);



                            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                                    new EventHandler<ActionEvent>() {
                                        //velocity
                                        double dx = 0.1;
                                        double dy = 0.1;


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
                    /*Thread t1 = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            System.out.println("aaa");
                            Circle ball = new Circle(10, Color.CADETBLUE);
                            ball.relocate(0, 0);




                        }
                    });
                    t1.start();*/



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
                    });

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
        launch();
    }

}

