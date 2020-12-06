package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock {
    private int hour;
    private int minute;
    private int second;
    Pane pane;

    public Clock(Pane pane) {
        this.pane = pane;
        setCurrentTime();
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paint();
    }

    protected void paint() {
        double width = 250;
        double height = 250;
        double clockRadius = width * 0.8 * 0.5;
//        System.out.println(width);
        double centerX = width / 2;
        double centerY = height / 2;
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text text1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text text2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text text3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text text4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
        /*System.out.println(text1);
        System.out.println(text2);
        System.out.println(text3);
        System.out.println(text4);*/
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerX - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        sLine.setStrokeWidth(1);
//        System.out.println(sLine);
        double mLength = clockRadius * 0.65;
        double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.BLACK);
        mLine.setStrokeWidth(2);
//        System.out.println(mLine);
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.BLACK);
        hLine.setStrokeWidth(3);
//        System.out.println(hLine);
        pane.getChildren().clear();
        pane.getChildren().addAll(circle, text1, text2, text3, text4, sLine, mLine, hLine);
    }
}