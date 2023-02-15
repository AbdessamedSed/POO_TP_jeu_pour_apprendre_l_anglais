package Controllers;

import Models.Jeu;
import Models.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField NameLabelLogin;

    @FXML
    private Button LogInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField NameLabelSingup;

    private static boolean exist;

    public void Login() {
        try {
            Jeu game = new Jeu();
            game.Deserialization();
            String name = NameLabelLogin.getText();
            boolean bool = game.existPlayer(name);
            System.out.println("joueur exist");
            if (bool) {
                Joueur player = new Joueur(name, null);
               /*for(Map.Entry<String, Joueur> entry : Jeu.playersMap.entrySet()){
                    if(entry.getKey().equals(name)){
                        player.setLastScore(entry.getValue().getLastScore());
                        player.setLastCase(entry.getValue().getLastCase());
                        player.setMeilleurScore(entry.getValue().getMeilleurScore());
                        game.setCurrentPlayer(player);
                        exist = true;
                    }
                }
                player.setLastScore(Jeu.playersMap.get(name).getLastScore());
                player.setLastCase(Jeu.playersMap.get(name).getLastCase());
                player.setMeilleurScore(Jeu.playersMap.get(name).getMeilleurScore());*/
                game.setCurrentPlayer(player);
                exist = true;
            } else {
                throw new NullPointerException("Not exist Player");
            }
        } catch (NullPointerException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Player not exist");
            errorAlert.setContentText("There is no player by this name, try again");
            errorAlert.showAndWait();
        }
    }

    public void SignUp(){
        exist = false;
        String name = NameLabelSingup.getText();
        Jeu game = new Jeu();
        game.Deserialization();
        Joueur player = new Joueur(name, null);
        game.addPlyer(name, player);
        game.setCurrentPlayer(player);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LogInButton.setOnAction(e->{
            Login();
            if(exist)GoToNextPage(e);
        });

        SignUpButton.setOnAction(e->{
            SignUp();
            GoToNextPage(e);
        });
    }

    public void GoToNextPage(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Session.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 900, 650);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}