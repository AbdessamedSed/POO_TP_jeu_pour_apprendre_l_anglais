package Controllers;

import Models.Definition;
import Models.ImageQue;
import Models.Question;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ImageController implements Initializable {

    @FXML
    private Label DefLabel;

    @FXML
    private Button Reponse1;

    @FXML
    private ImageView Image1;

    @FXML
    private Button Reponse2;

    @FXML
    private ImageView Image2;

    @FXML
    private Button Reponse3;

    @FXML
    private ImageView Image3;

    @FXML
    private Button Reponse4;

    @FXML
    private ImageView Image4;

    private boolean r1;
    private boolean r2;
    private boolean r3;
    private boolean r4;

    static int que = 0;


    public void setData(Question question){
        DefLabel.setText(question.getPhrase());
        Image img1 = new Image(getClass().getResourceAsStream(question.getReponse(0).getText()));
        Image img2 = new Image(getClass().getResourceAsStream(question.getReponse(1).getText()));
        Image img3 = new Image(getClass().getResourceAsStream(question.getReponse(2).getText()));
        Image img4 = new Image(getClass().getResourceAsStream(question.getReponse(3).getText()));
        Image1.setImage(img1);
        Image2.setImage(img2);
        Image3.setImage(img3);
        Image4.setImage(img4);
        r1 = question.getReponse(0).isCorrect();
        r2 = question.getReponse(1).isCorrect();
        r3 = question.getReponse(2).isCorrect();
        r4 = question.getReponse(3).isCorrect();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ImageQue image = new ImageQue();
        setData(image.selectQuestion(que % 10));
        que++;
        Reponse1.setOnAction(e->{
            Reponse2.setDisable(true); Reponse3.setDisable(true); Reponse4.setDisable(true);
            if(r1){
                Reponse1.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score += 10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                SessionController.curCase += 2;
                //SessionController.CurCaseLabel.setText(String.valueOf(SessionController.curCase));
            }
            if(!r1){
                Reponse1.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
            }
        });

        Reponse2.setOnAction(e->{
            Reponse1.setDisable(true); Reponse3.setDisable(true); Reponse4.setDisable(true);
            if(r2) {
                Reponse2.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score += 10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                SessionController.curCase += 2;
            }
            if(!r2){
                Reponse2.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
            }
        });

        Reponse3.setOnAction(e->{
            Reponse1.setDisable(true); Reponse2.setDisable(true); Reponse4.setDisable(true);
            if(r3){
                Reponse3.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score +=10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                SessionController.curCase += 2;
                //SessionController.CurCaseLabel.setText(String.valueOf(SessionController.curCase));
            }
            if(!r3){
                Reponse3.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
            }
        });

        Reponse4.setOnAction(e->{
            Reponse1.setDisable(true); Reponse2.setDisable(true); Reponse3.setDisable(true);
            if(r4){
                Reponse4.setStyle("-fx-background-color: green; -fx-background-radius: 10px;");
                SessionController.score +=10;
                SessionController.CurScrLabel.setText(String.valueOf(SessionController.score));
                SessionController.curCase += 2;
                //SessionController.CurCaseLabel.setText(String.valueOf(SessionController.curCase));
            }
            if(!r4){
                Reponse4.setStyle("-fx-background-color: red; -fx-background-radius: 10px;");
            }
        });
    }

}
