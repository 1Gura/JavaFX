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

    boolean tryParseInt(String... value) {
        try {
            for (String str:value) {
                Integer.parseInt(str);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    static String numberDayOfMonth(int month, int year) {
        switch (month) {
            case 1 : {
                return  ("Январь : 31 день");
            } 
            case 2 : {
                if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    return("Февраль : 29 день");
                } else {
                    return("Февраль : 28 день");
                }
            } 
            case 3 : {
                return("Март : 31 день");
            } 
            case 4 : {
                return("Апрель : 30 день");
            } 
            case 5 : {
                return("Май : 31 день");
            } 
            case 6 : {
                return("Июнь : 30 день");
            } 
            case 7 : {
                return("Июль : 31 день");
            } 
            case 8 : {
                return("Август : 31 день");
            } 
            case 9 : {
                return("Сентябрь : 30 день");
            } 
            case 10 : {
                return("Октябрь : 31 день");
            } 
            case 11 : {
                return("Ноябрь : 30 день");
            } 
            case 12 : {
                return("Декабрь : 31 день");
            } 
            default:
                return("Введите номер месяца от 1 до 12");
        }
    }

    static String searchNumber(int[] nums) {
        if(nums.length > 0) {
            for(int i = 0; i<nums.length - 1; i++) {
                if(nums[i] < 0 && nums[i+1] > 0) {
                    return ("Первым встречается отрицательное");

                } else if(nums[i] > 0 && nums[i+1] < 0) {

                    return ("Первым встречается положительное");
                }
            }
        }
        return ("Массив состоит\nтолько из\nположительны или\nотрицательных чисел.");
    }
    
    

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Задание №1*/
        Label task1 = new Label("Задание №1");
        Label task1Label1 = new Label("Первая сторона");
        Label task1Label2 = new Label("Вторая сторона");
        Label task1Label3 = new Label("Третья сторона");
        Label label = new Label("Ответ:\n");
        TextField task1textField1 = new TextField();
        TextField task1textField2 = new TextField();
        TextField task1textField3 = new TextField();
        task1textField1.setPrefColumnCount(17);
        Button button1 = new Button("Посчитать площадь");
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag = tryParseInt(task1textField1.getText(),task1textField2.getText(),task1textField3.getText());
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

        /*Задание №2*/
        Label task2 = new Label("Задание №2");
        Label task2Label1 = new Label("Введите месяц");
        Label task2Label2 = new Label("Введите год");
        TextField task2textField1 = new TextField();
        TextField task2textField2 = new TextField();
        Button button2 = new Button("Вычислить кол-во дней");
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag = tryParseInt(task2textField1.getText(),task2textField2.getText());
                if(flag) {
                    if(task2textField1.getText() != "" && task2textField2.getText() != "") {
                        int year = Integer.parseInt(task2textField1.getText());
                        int month = Integer.parseInt(task2textField2.getText());
                        label.setText(numberDayOfMonth(year, month));
                    }
                } else {
                    label.setText("Поля должны быть целыми числами!");
                }
            }
        });

        /*Задание №3*/
        Label task3 = new Label("Задание №3");
        Label task3Label1 = new Label("Введите кол-во км");
        Label task3Label2 = new Label("Введите процент");
        Label task3Label3 = new Label("Введите кол-во дней");
        TextField task3textField1 = new TextField();
        TextField task3textField2 = new TextField();
        TextField task3textField3 = new TextField();
        Button button3 = new Button("Вычислить кол-во дней");
        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag = tryParseInt(task3textField1.getText(),task3textField2.getText(), task3textField3.getText());
                if(flag) {
                    if(task3textField1.getText() != "" && task3textField2.getText() != "" && task3textField3.getText() != "") {
                        SportsMen sportsMen = new SportsMen(
                                Integer.parseInt(task3textField1.getText()),
                                Integer.parseInt(task3textField2.getText()),
                                Integer.parseInt(task3textField3.getText()));
                        double arrayDouble[] = sportsMen.getSum();
                        label.setText("Суммарный путь (цикл for)" + String.format("%.2f",arrayDouble[0])  + "\n"
                                + "Суммарный путь (цикл while):" + String.format("%.2f",arrayDouble[1]));
                    }
                } else {
                    label.setText("Поля должны быть целыми числами!");
                }
            }
        });


        /*Задание №4*/
        Label task4 = new Label("Задание №4");
        Label task4Label1 = new Label("Введите элементы массива");
        TextField task4textField1 = new TextField();
        Button button4 = new Button("Press");
        button4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean flag = tryParseInt(task4textField1.getText().split(" "));
                if(flag) {
                    if(task4textField1.getText() != "") {

                        String[] numbersString = task4textField1.getText().split(" ");
                        int numbers[] = new int[numbersString.length];
                        for (int i = 0; i < numbersString.length; i++) {
                            numbers[i] = Integer.parseInt(numbersString[i]);
                        }
                        label.setText(searchNumber(numbers));
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
        FlowPane root3 = new FlowPane(Orientation.VERTICAL, 10,10,
                task3,
                task3Label1,
                task3textField1,
                task3Label2,
                task3textField2,
                task3Label3,
                task3textField3,
                button3);

        FlowPane root4 = new FlowPane(Orientation.VERTICAL, 10,10,
                task4,
                task4Label1,
                task4textField1,
                button4);

        HBox hBox = new HBox(root, root2, root3, root4);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(30);
        hBox.setMinWidth(220);

        Scene scene = new Scene(hBox, 850, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Лабораторняа №1 Гура Илья Сергеевич");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
