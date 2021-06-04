package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene ;
import javafx.fxml.FXMLLoader ;

import java.io.IOException;
import javafx.scene.Node ;



public class Controller {

private Stage stage;
private Scene scene;
private Parent root ;
@FXML
private Button launchgame ;
@FXML
private Button launch_rules ;
@FXML
private Button passage_Rules1_Rules2;
@FXML
private Button RetourMenu ;

@FXML
private Label myLabel, pseudos2_label ;
@FXML
private TextField nbjoueursfield;
@FXML
private Button validation;
@FXML
private Label Mylabelwin;

int nombre_de_joueur;

public void valider(ActionEvent event) {

    try {

        nombre_de_joueur = Integer.parseInt(nbjoueursfield.getText());
        System.out.println(nombre_de_joueur);
        if (1 < nombre_de_joueur & nombre_de_joueur < 5) {
            Mylabelwin.setText("Veuillez patientez, la partie va bientôt commencer...");
            if (nombre_de_joueur==3) {
                Parent root = FXMLLoader.load(getClass().getResource("pseudos_3.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
                else if(nombre_de_joueur==4) {
                Parent root = FXMLLoader.load(getClass().getResource("pseudos_4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
                else if(nombre_de_joueur==2) {
                    Parent root = FXMLLoader.load(getClass().getResource("pseudos_2.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

            }
        } else {
            myLabel.setText("Ne rentrez que des chiffres entre 2 et 4");

        }

    } catch (NumberFormatException e) {
        myLabel.setText("Ne rentrez que des chiffres de 2 à 4 !");
    } catch (Exception e) {
        System.out.println(e);
    }

}

// On s'occupe de la couleur et des pseudos
// On définit les radioboutons des pseudos qui serviront à la couleur du royaume
@FXML
private RadioButton Rose_pseudos2_J1, Bleu_pseudos2_J1, Vert_pseudos2_J1, Jaune_pseudos2_J1 ;
@FXML
private RadioButton Rose_pseudos2_J2, Bleu_pseudos2_J2, Vert_pseudos2_J2, Jaune_pseudos2_J2 ;
@FXML
private TextField pseudos2_j1_field, pseudos2_j2_field ;
@FXML
private Button pseudos2_Validation_j1, pseudos2_Validation_j2, pseudos2_validation;

String pseudos2_j1 ;
String pseudos2_j2 ;
String choosen_color_j1;

public void pseudos2_validation_j1( ActionEvent event) {

    pseudos2_j1 = pseudos2_j1_field.getText();

    if (Rose_pseudos2_J1.isSelected()) {

        System.out.println("Rose à été choisi par " + pseudos2_j1);
    } else if (Bleu_pseudos2_J1.isSelected()) {

        System.out.println("Bleu à été choisi par " + pseudos2_j1);
    } else if (Vert_pseudos2_J1.isSelected()) {

        System.out.println("Vert à été choisi par " + pseudos2_j1);
    } else if (Jaune_pseudos2_J1.isSelected()) {
        System.out.println("Jaune à été choisi par " + pseudos2_j1);
    }

}

    public void pseudos2_validation_j2( ActionEvent event) {

        pseudos2_j2 = pseudos2_j2_field.getText();

        if (Rose_pseudos2_J2.isSelected()) {

            System.out.println("Rose à été choisi par " + pseudos2_j2);
        } else if (Bleu_pseudos2_J2.isSelected()) {

            System.out.println("Bleu à été choisi par " + pseudos2_j2);
        } else if (Vert_pseudos2_J2.isSelected()) {

            System.out.println("Vert à été choisi par " + pseudos2_j2);
        } else if (Jaune_pseudos2_J2.isSelected()) {
            System.out.println("Jaune à été choisi par " + pseudos2_j2);
        }

    }

    public void pseudos2_validation(ActionEvent event ) {
        if (Rose_pseudos2_J1.isSelected() & Rose_pseudos2_J2.isSelected()) {
            pseudos2_label.setText("Choisisez des couleurs différentes ! ");
        } else if (Jaune_pseudos2_J1.isSelected() & Jaune_pseudos2_J2.isSelected()) {
            pseudos2_label.setText("Choisisez des couleurs différentes ! ");
        } else if (Bleu_pseudos2_J1.isSelected() & Bleu_pseudos2_J2.isSelected()) {
            pseudos2_label.setText("Choisisez des couleurs différentes ! ");
        } else if (Vert_pseudos2_J1.isSelected() & Vert_pseudos2_J2.isSelected()) {
            pseudos2_label.setText("Choisisez des couleurs différentes ! ");
        }
            else {
            pseudos2_label.setText("les couleurs sont différentes, la partie peut commencer ");
        }
    }


    public void  Switchtopage1(ActionEvent event ) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("Page1.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}


public void  Switchtopage2(ActionEvent event ) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Page2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void  SwitchtoRules(ActionEvent event ) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void  SwitchtoRules2(ActionEvent event ) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Rules2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void  SwitchtoRules3(ActionEvent event ) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Rules3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void  SwitchtoMenu(ActionEvent event ) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Page1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
