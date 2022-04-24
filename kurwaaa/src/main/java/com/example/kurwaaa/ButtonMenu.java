package com.example.kurwaaa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ButtonMenu extends Application {

    public void toDo(Pane pane){
        Button button = new Button();
        button.setText("spawn ball");
        button.setLayoutX(250);
        button.setLayoutY(220);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BallThread ball = new BallThread();
                System.out.println("new button");
                ball.start();



                ball.setBall(pane);
                System.out.println(Thread.activeCount());


            }
        });
        pane.getChildren().add(button);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
