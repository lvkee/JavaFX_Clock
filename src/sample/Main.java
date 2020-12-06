package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        Pane pane = new Pane();
        Clock clock = new Clock(pane);
        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
            String timeString = "北京时间 : " + clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
            Label label_CurrentTime = new Label(timeString);
            label_CurrentTime.setStyle("-fx-font-size: 20px; -fx-font-family: 'Microsoft YaHei UI'");
            rootPane.setTop(pane);
            rootPane.setBottom(label_CurrentTime);
//            System.out.println(label_CurrentTime);
            BorderPane.setAlignment(label_CurrentTime, Pos.BOTTOM_CENTER);
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        Scene scene = new Scene(rootPane, 250, 250);
        primaryStage.setResizable(false);
        primaryStage.setTitle("时钟动画");
        primaryStage.getIcons().add(new Image("file:src/res/clock.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
