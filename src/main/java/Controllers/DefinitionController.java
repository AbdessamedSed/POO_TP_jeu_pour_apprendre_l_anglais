package Controllers;

import Models.Definition;
import Models.Question;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DefinitionController implements Initializable {

    @FXML
    private Label DefLabel;

    @FXML
    private Button Reponse1;

    @FXML
    private Button Reponse2;

    @FXML
    private Button Reponse3;

    @FXML
    private Button Reponse4;

    private boolean r1;
    private boolean r2;
    private boolean r3;
    private boolean r4;

    static int que = 0;

    public void setData(Question question){
        DefLabel.setText(question.getPhrase());
        Reponse1.setText(question.getReponse(0).getText());
        Reponse2.setText(question.getReponse(1).getText());
        Reponse3.setText(question.getReponse(2).getText());
        Reponse4.setText(question.getReponse(3).getText());
        r1 = question.getReponse(0).isCorrect();
        r2 = question.getReponse(1).isCorrect();
        r3 = question.getReponse(2).isCorrect();
        r4 = question.getReponse(3).isCorrect();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Definition def = new Definition();
        setData(def.selectQuestion(que % 10));
        que++;
        Reponse1.setOnAction(e->{
            Reponse2.setDisable(true); Reponse3.setDisable(true); Reponse4.setDisable(true);
            if(r1){
                Reponse1.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score += 20;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                SessionController.curCase += 4;
                Image img = new Image("/images/p.png");
                ImageView view = new ImageView(img);
                view.setFitHeight(15);
                view.setFitWidth(15);
                SessionController.buttons[SessionController.curCase - 1 - 4].setGraphic(null);
                SessionController.buttons[SessionController.curCase - 1].setGraphic(view);
                //SessionController.CurCaseLabel.setText(String.valueOf(SessionController.curCase));
            }
            if(!r1){
                Reponse1.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
                SessionController.score -=10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
            }
        });

        Reponse2.setOnAction(e->{
            Reponse1.setDisable(true); Reponse3.setDisable(true); Reponse4.setDisable(true);
            if(r2) {
                Reponse2.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score += 20;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                Image img = new Image("/images/p.png");
                ImageView view = new ImageView(img);
                view.setFitHeight(15);
                view.setFitWidth(15);
                SessionController.buttons[SessionController.curCase - 1 - 4].setGraphic(null);
                SessionController.buttons[SessionController.curCase - 1].setGraphic(view);
            }
            if(!r2){
                Reponse2.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
                SessionController.score -=10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
            }
        });

        Reponse3.setOnAction(e->{
            Reponse1.setDisable(true); Reponse2.setDisable(true); Reponse4.setDisable(true);
            if(r3){
                Reponse3.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score +=20;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                SessionController.curCase += 4;
                Image img = new Image("/images/p.png");
                ImageView view = new ImageView(img);
                view.setFitHeight(15);
                view.setFitWidth(15);
                SessionController.buttons[SessionController.curCase - 1 - 4].setGraphic(null);
                SessionController.buttons[SessionController.curCase - 1].setGraphic(view);
            }
            if(!r3){
                Reponse3.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
                SessionController.score -=10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));

            }
        });

        Reponse4.setOnAction(e->{
            Reponse1.setDisable(true); Reponse2.setDisable(true); Reponse3.setDisable(true);
            if(r4){
                Reponse4.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score +=20;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                SessionController.curCase += 4;
                Image img = new Image("/images/p.png");
                ImageView view = new ImageView(img);
                view.setFitHeight(15);
                view.setFitWidth(15);
                SessionController.buttons[SessionController.curCase - 1 - 4].setGraphic(null);
                SessionController.buttons[SessionController.curCase - 1].setGraphic(view);            }
            if(!r4){
                Reponse4.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
                SessionController.score -=10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
            }
        });
    }
}
