package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.awt.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("King Domino");

        Text question_nb_joueurs = new Text();
        question_nb_joueurs.setText("Indiquez le nombre de joueurs :");

        TextField reponse_nb_joueurs = new TextField();

        question_nb_joueurs.setLayoutX(450);
        question_nb_joueurs.setLayoutY(100);

        reponse_nb_joueurs.setLayoutX(450);
        reponse_nb_joueurs.setLayoutY(120);

        root.getChildren().add(question_nb_joueurs);
        root.getChildren().add(reponse_nb_joueurs);

        Button bouton_debut = new Button("Commencer à jouer");
        bouton_debut.setLayoutX(450);
        bouton_debut.setLayoutY(500);
        bouton_debut.setOnAction(e -> System.out.println("click"));

        root.getChildren().add(bouton_debut);

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
