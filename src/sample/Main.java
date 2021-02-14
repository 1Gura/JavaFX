package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jdk.jfr.Event;
import javafx.scene.control.Label;

public class Main extends Application {

    boolean tryParseInt(String[] value) {
        try {
            for (String str:value) {
                Integer.parseInt(str);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label task1 = new Label("Задание №1");
        Label task1Label1 = new Label("Первая сторона");
        Label task1Label2 = new Label("Вторая сторона");
        Label task1Label3 = new Label("Третья сторона");
        Label label = new Label();
        TextField task1textField1 = new TextField();
        TextField task1textField2 = new TextField();
        TextField task1textField3 = new TextField();
        task1textField1.setPrefColumnCount(17);
        Button button1 = new Button("Посчитать площадь");

        Label task2 = new Label("Задание №2");
        Label task2Label1 = new Label("Введите год");
        Label task2Label2 = new Label("Введите месяц");
        TextField task2textField1 = new TextField();
        TextField task2textField2 = new TextField();
        Button button2 = new Button("Вычислить кол-во дней");






        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String[] stringArray = {task1textField1.getText(),task1textField2.getText(),task1textField3.getText()};
                boolean flag = tryParseInt(stringArray);
                if(flag) {
                    if(task1textField1.getText() != "" && task1textField2.getText() != "" && task1textField3.getText() != "") {
                        Triangle triangle = new Triangle(
                                Integer.parseInt(task1textField1.getText()),
                                Integer.parseInt(task1textField2.getText()),
                                Integer.parseInt(task1textField3.getText()));
                        double area = triangle.area();
                        if(area < 0) {
                            label.setText("Такого треугольника не существует.");
                        } else  {
                            label.setText("Площадь треугольника равна: " + String.format("%.2f",area));
                        }
                    } else {
                        label.setText("Заполнитие все поля!");
                    }
                } else {
                    label.setText("Поля должны быть целыми числами!");
                }
            }
        });
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10,10,
                task1,
                task1Label1,
                task1textField1,
                task1Label2,
                task1textField2,
                task1Label3,
                task1textField3,
                button1,
                label
        );
        FlowPane root2 = new FlowPane(Orientation.VERTICAL, 10,10,
                task2,
                task2Label1,
                task2textField1,
                task2Label2,
                task2textField2,
                button2);
        HBox hBox = new HBox(root, root2);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(30);
        hBox.setMinWidth(220);

        Scene scene = new Scene(hBox, 850, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
