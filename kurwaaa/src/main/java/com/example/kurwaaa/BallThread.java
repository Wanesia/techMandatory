package com.example.kurwaaa;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class BallThread extends Thread{

    Circle ball=new Circle();
    Circle testBall=new Circle();
    double dx = 5;
    double dy = 5;
    ArrayList<Circle> balls = new ArrayList<Circle>();
    Boolean decision=false;
    BallMethods ballMethodsStart = new BallMethods();



    public void run() {
        while(true) {
            System.out.println("run");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Thread.interrupted()) {
                return;
            }
        }
    }
    /*public void checkColision(ArrayList<Circle> balls) throws NullPointerException{

        for (int i = 0; i <balls.size(); i++) {
            ball = balls.get(i);
            for (int j = i+1; j < balls.size(); j++) {
                decision=checkDistance(balls);
                testBall = balls.get(j);
                if (decision){
                    collideBalls(ball,testBall);
                    System.out.println("yessssssssssssssssssssssssssssssssssssssss");
                    System.out.println("yessssssssssssssssssssssssssssssssssssssss");
                    System.out.println("yessssssssssssssssssssssssssssssssssssssss");

                }

            }
        }
    }

    private void collideBalls(Circle ball, Circle testBall) {
        System.out.println("collide");
    }

    public boolean checkDistance(ArrayList<Circle> balls)throws NullPointerException{
        boolean distance = false;
        for (int i = 0; i <balls.size(); i++) {
            ball = balls.get(i);
            for (int j = i+1; j < balls.size(); j++) {

                if(balls.get(i).getLayoutY() == balls.get(j).getLayoutY() && balls.get(i).getLayoutX() == balls.get(j).getLayoutX()){
                    //do whatever (such as bouncing off) when the balls collide
                    distance=true;
                }
            }
        }
        return distance;
    }*/

    public void setBall(Pane pane){

        //Drawing a Circle

        //Setting the properties of the ball

        //Setting other properties
        ball.setFill(Color.DARKCYAN);

        //Setting the Scene
        pane.getChildren().add(ball);
        ball.setCenterX(10.0f);
        ball.setCenterY(10.0f);
        ball.setRadius(10.0f);

        balls.add(ball);

        //update animation(or whatever its called)

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {
                    //velocity


                    @Override
                    public void handle(ActionEvent t) {
                        //move the ball
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        Bounds bounds = pane.getBoundsInLocal();

                        double xMin = ball.getBoundsInParent().getMinX();
                        double yMin = ball.getBoundsInParent().getMinY();
                        double xMax = ball.getBoundsInParent().getMaxX();
                        double yMax = ball.getBoundsInParent().getMaxY();
                        if(true){
                            ballMethodsStart.ballMethodsStart();
                        }

                        // Collision - boundaries
                        if (xMin < 0 || xMax > pane.getWidth()) {
                            dx = dx * -1;
                        }
                        if (yMin < 0 || yMax > pane.getHeight()) {
                            dy = dy * -1;
                        }

                        ball.setTranslateX(ball.getTranslateX() + dx);
                        ball.setTranslateY(ball.getTranslateY() + dy);

                    }

                }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }



    public static void main(String args[])
    {
        BallThread t1=new BallThread();
        // this will call run() method
        t1.start();
    }



}
