package com.example.kurwaaa;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class BallMethods {

    Circle ball=new Circle();
    Circle testBall=new Circle();
    double dx = 5;
    double dy = 5;
    ArrayList<Circle> balls = new ArrayList<>();
    Boolean decision=false;


    public void checkColision(ArrayList<Circle> balls) throws NullPointerException{

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
    }
    public void ballMethodsStart(){
        checkColision(balls);

    }
}
