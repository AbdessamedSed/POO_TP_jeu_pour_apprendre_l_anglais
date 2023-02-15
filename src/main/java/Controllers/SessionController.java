package Controllers;

import Models.*;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class SessionController implements Initializable {
    @FXML
    private AnchorPane anchorePane;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button DiceBut;

    @FXML
    private Button NewGameBut;

    @FXML
    private Button LastSessionBut;

    @FXML
    private Button SaveButton;

    @FXML
    private ImageView Dice1;

    @FXML
    private ImageView Dice2;

    @FXML
    private Label PlayerNameLabel;

    @FXML
    private Label BestOwnScrLabel;

    @FXML
    private Label OwnerLabel;

    @FXML
    private Label Sum;

    @FXML
    private Label DirectoinCase;

    @FXML
    private Label BestScrLabel;

    public static Label CurScrLabel;
    public static Label CurCaseLabel;
    //***********************************//
    int n1 = 0, n2 = 0, nbrPas, que = 0;
    public static int curCase = 1;
    public static int score = 0;
    private boolean isStarting = true, stop = false, quest = false, imgBool = false, saut = false, bonus = false, malus = false, fin = false;
    private int temp, tempF, tempImg, tempQue;
    Plateau plateau = new Plateau();
    public static Button[] buttons = new Button[100];

    public Plateau CreatePlateau() {

        int tab1[] = {5, 9, 28, 87, 95, 3, 10, 35, 73, 95, 15, 41, 66, 88, 98, 14, 19, 49, 58, 76, 10, 20, 30, 70, 90};
        int tab2[] = {19, 39, 49, 66, 79, 10, 20, 40, 71, 57, 15, 35, 45, 28, 88, 50, 60, 75, 82, 25, 1, 3, 61, 77, 94};
        int tab3[] = {35, 39, 52, 71, 89, 2, 15, 40, 79, 97, 6, 35, 70, 78, 84, 25, 58, 66, 84, 96, 11, 23, 31, 45, 68};
        int tab4[] = {90, 70, 30, 20, 10, 76, 58, 49, 19, 14, 98, 88, 66, 41, 15, 95, 73, 35, 10, 3, 95, 87, 28, 9, 5};
        int tab[];
        Random random = new Random();
        int a = random.nextInt(4)+1;
        if(a == 1) {
            tab = tab1;
        } else if(a == 2){
            tab = tab2;
        } else if(a == 3){
            tab = tab3;
        } else if(a == 4){
            tab = tab4;
        } else{
            tab = tab4;
        }

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        int column = 1;
        int row = 1;
        int j = 0;
        String codeColor = null;
        plateau.CreatePlateau(tab);
        Case cases[] = plateau.getCases();

        for (int i = 0; i < 4; i++) {
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            gridPane.add(button, column, row);
            j++;
            column++;
        }

        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            gridPane.add(button, column, row);
            j++;
            row++;
        }

        for (int i = 0; i < 17; i++) {
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            button.setText(String.valueOf(j + 1));
            gridPane.add(button, column, row);
            j++;
            column++;
        }

        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            gridPane.add(button, column, row);
            j++;
            row--;
        }


        for (int i = 0; i < 15; i++) {
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            button.setText(String.valueOf(j + 1));
            gridPane.add(button, column, row);
            j++;
            column--;
        }

        for (int i = 0; i < 7; i++) {
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            button.setText(String.valueOf(j + 1));
            gridPane.add(button, column, row);
            j++;
            row++;
        }

        for (int i = 0; i < 13; i++) {
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            gridPane.add(button, column, row);
            j++;
            column++;
        }

        for(int i = 0 ; i < 5 ; i++){
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            gridPane.add(button, column, row);
            j++;
            row--;
        }

        for(int i = 0 ; i < 11 ; i++){
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            gridPane.add(button, column,row);
            j++;
            column--;
        }

        for(int i = 0 ; i < 3 ; i++){
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            gridPane.add(button, column, row);
            j++;
            row++;
        }

        for(int i = 0 ; i < 7 ; i++){
            Button button = new Button();
            button.setCursor(Cursor.HAND);
            button.setPrefSize(30, 30);
            buttons[j] = button;
            button.setText(String.valueOf(j + 1));
            codeColor = cases[j].getColor().toString();
            button.setStyle("-fx-background-color : " + codeColor + ";");
            gridPane.add(button, column, row);
            j++;
            column++;
        }

        return plateau;
    }

    public int roll(De de) {
        return de.LancerDe();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MeilleurScore meilleurScore = new MeilleurScore();
        CurCaseLabel = new Label();
        CurScrLabel = new Label();
        anchorePane.getChildren().add(CurCaseLabel);
        anchorePane.getChildren().add(CurScrLabel);

        CurScrLabel.setTranslateX(215);
        CurScrLabel.setTranslateY(97);
        CurScrLabel.setFont(new Font("System Bold", 14));
        CurScrLabel.setText(String.valueOf(0));

        CurCaseLabel.setTranslateX(215);
        CurCaseLabel.setTranslateY(62);
        CurCaseLabel.setFont(new Font("System Bold", 14));
        CurCaseLabel.setText(String.valueOf(0));

        /***************************************************************/
        DiceBut.setCursor(Cursor.HAND);

        Plateau plateau = CreatePlateau();

        Partie session = new Partie(plateau);
        Joueur player = Jeu.getCurrentPlayer();
        player.setPartie(session);

        System.out.println("Le nom dans session est" + Jeu.getCurrentPlayer().getNom());

        De de1 = new De(Couleur.GREEN);
        De de2 = new De(Couleur.RED);

        PlayerNameLabel.setText(player.getNom());
        OwnerLabel.setText(meilleurScore.getJoueur());
        BestScrLabel.setText(String.valueOf(meilleurScore.getTop()));
        BestOwnScrLabel.setText(String.valueOf(player.getMeilleureScore()));

        NewGameBut.setOnAction(e->{
            if(curCase > 1){
                buttons[curCase - 1].setText(String.valueOf(curCase));
                buttons[curCase - 1].setGraphic(null);
            }
            session.startGame();
            if((curCase - 1)>0) {
                buttons[curCase - 1].setGraphic(null);
            }
            score = session.getScore();
            CurScrLabel.setText(String.valueOf(score));
            CurCaseLabel.setText(String.valueOf(0));
            Sum.setText(String.valueOf(0));
            DirectoinCase.setText(String.valueOf(0));
            isStarting = true;
            DiceBut.setDisable(false);
        });

        LastSessionBut.setOnAction(e->{
            score = Jeu.getCurrentPlayer().getLastScore();
            curCase = Jeu.getCurrentPlayer().getLastCase();
            session.resumeGame(score, curCase);
            CurScrLabel.setText(String.valueOf(String.valueOf(score)));
            CurCaseLabel.setText(String.valueOf(curCase));
            Sum.setText(String.valueOf(0));
            DirectoinCase.setText(String.valueOf(0));
            isStarting = true;
            DiceBut.setDisable(false);
        });


        DiceBut.setOnAction(e -> {
            n1 = roll(de1);
            n2 = roll(de2);
            nbrPas = n1 + n2;
            System.out.println("Le de est :" + nbrPas);
            if(isStarting){
                curCase = 0;
                isStarting = false;
            }

            curCase = curCase + (nbrPas);
            if (curCase > plateau.getNbrCases()) {
                tempF = curCase - nbrPas;
                int i = curCase - plateau.getNbrCases();
                curCase = plateau.getNbrCases() - i;
                fin = true;
            }
            Sum.setText(String.valueOf(nbrPas));
            DirectoinCase.setText(String.valueOf(curCase));
            DiceBut.setDisable(true);
            if(quest) {
                buttons[tempQue - 1].setDisable(false);
                buttons[tempQue - 1].setGraphic(null);
                buttons[tempQue - 1].setText(String.valueOf(tempQue));
                quest = false;
            }
            if(imgBool){
                buttons[tempImg - 1].setDisable(false);
                buttons[tempImg - 1].setGraphic(null);
                buttons[tempImg - 1].setText(String.valueOf(tempImg));
                imgBool = false;
            }

            try{
                run(n1, n2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            DirectoinCase.setText(String.valueOf(curCase));
        });

        for(int i = 0 ; i < buttons.length ; i++ ){
            int finalI = i;
            buttons[i].setOnMouseClicked(e->{
                if(finalI != curCase - 1){
                    System.out.println("Destination fausse !!! ");
                    Alert alertWarning = new Alert(Alert.AlertType.WARNING);
                    alertWarning.setTitle("Warning");
                    alertWarning.setHeaderText("You are in false destionation");
                    alertWarning.setContentText("You have to click on case " + curCase);
                    alertWarning.showAndWait();
                }
                else{
                    System.out.println("La case courante est : " + curCase);
                    session.setCaseCourante(plateau.getCases()[curCase - 1]);
                    CurScrLabel.setText(String.valueOf(score));

                    Image img = new Image("/images/p.png");
                    ImageView view = new ImageView(img);
                    view.setFitHeight(15);
                    view.setFitWidth(15);
                    buttons[curCase - 1].setGraphic(view);
                    buttons[curCase - 1].setText("");
                    if((curCase - 1 - nbrPas)>0){
                        buttons[curCase - 1 - nbrPas].setGraphic(null);
                        buttons[curCase - 1 - nbrPas].setText(String.valueOf(curCase - nbrPas));
                    }
                    
                    if(bonus){
                        buttons[curCase - 1 - 2].setGraphic(null);
                        buttons[curCase - 1 - 2].setText(String.valueOf(curCase - 2));
                        bonus = false;
                    }
                    
                    if(malus){
                        buttons[curCase - 1 + 2].setGraphic(null);
                        buttons[curCase - 1 + 2].setText(String.valueOf(curCase + 2));
                        malus = false;
                    }
                    
                    if(saut){
                        buttons[temp - 1].setGraphic(null);
                        buttons[temp - 1].setText(String.valueOf(temp));
                        saut = false;
                    }

                    if(fin){
                        buttons[tempF - 1].setGraphic(null);
                        buttons[tempF - 1].setText(String.valueOf(tempF));
                        fin = false;
                        DiceBut.setDisable(false);
                    }
                    
                    if(session.getCaseCourante() instanceof CaseNormal){
                        DiceBut.setDisable(false);
                        CurCaseLabel.setText(String.valueOf(String.valueOf(curCase)));
                        CurScrLabel.setText(String.valueOf(score));
                    }

                    else if (session.getCaseCourante() instanceof CaseBonus) {
                        CurCaseLabel.setText(String.valueOf(String.valueOf(curCase)));
                        bonus = true;
                        CaseBonus caseBonus = new CaseBonus();
                        score += 10;
                        curCase += caseBonus.getDeplacement();
                        session.setCaseCourante(plateau.getCases()[curCase]);
                        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                        alertInformation.setTitle("Information");
                        alertInformation.setHeaderText("You are in Case Bonus");
                        alertInformation.setContentText("You have +10 in score, move to case " + curCase);
                        alertInformation.showAndWait();
                        CurScrLabel.setText(String.valueOf(score));
                        DirectoinCase.setText(String.valueOf(curCase));
                    }

                    else if (session.getCaseCourante() instanceof CaseMalus) {
                        CurCaseLabel.setText(String.valueOf(String.valueOf(curCase)));
                        malus = true;
                        CaseMalus caseMalus = new CaseMalus();
                        score -= 10;
                        curCase += caseMalus.getDeplacement();
                        session.setCaseCourante(plateau.getCases()[curCase]);
                        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                        alertInformation.setTitle("Information");
                        alertInformation.setHeaderText("You are in Case Malus");
                        alertInformation.setContentText("You have -10 in score, move to case " + curCase);
                        alertInformation.showAndWait();
                        CurScrLabel.setText(String.valueOf(score));
                        DirectoinCase.setText(String.valueOf(curCase));
                    }

                    else if (session.getCaseCourante() instanceof CaseSaut) {
                        saut = true;
                        CurCaseLabel.setText(String.valueOf(String.valueOf(curCase)));
                        CaseSaut caseSaut = new CaseSaut();
                        temp = curCase;
                        curCase = caseSaut.getJump();
                        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                        alertInformation.setTitle("Information");
                        alertInformation.setHeaderText("You are in Case Jump");
                        alertInformation.setContentText("Go to the case number " + curCase);
                        alertInformation.showAndWait();
                        DirectoinCase.setText(String.valueOf(curCase));
                    }

                    else if (session.getCaseCourante() instanceof Definition) {
                        quest = true;
                        tempQue = curCase;
                        buttons[curCase - 1].setDisable(true);
                        CurCaseLabel.setText(String.valueOf(curCase));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/DefinitionQue.fxml"));
                        try {
                            Parent root = (Parent)fxmlLoader.load();
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        DiceBut.setDisable(false);
                    }

                    else if (session.getCaseCourante() instanceof ImageQue) {
                        tempImg = curCase;
                        imgBool = true;
                        buttons[curCase - 1].setDisable(true);
                        CurCaseLabel.setText(String.valueOf(curCase));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Image.fxml"));
                        try {
                            Parent root = (Parent)fxmlLoader.load();
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        DiceBut.setDisable(false);

                    }

                    else if (session.getCaseCourante() instanceof CaseFin) {
                        stop = true;
                        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
                        alertInformation.setTitle("Information");
                        alertInformation.setHeaderText("Game Over");
                        alertInformation.setContentText("Congratulations! You arrive to the final case with score : " + score + "\n Top score is for " + meilleurScore.getJoueur() + "with score :" + meilleurScore.getTop());
                        alertInformation.show();
                        player.modifyTop(score);
                        CurCaseLabel.setText(String.valueOf(100));
                    }
                }
            });
        }


        SaveButton.setOnAction(e->{
            session.setScore(score);
            session.setNumberCurrentCase(curCase);
            player.setLastCase(curCase);
            player.setLastScore(score);
            player.modifyTop(score);
            Jeu.modifyPlayer(player.getNom(), player);
            Jeu.Serialization();
            meilleurScore.modifyMeiScore(player.getNom(), session.getScore());
            OwnerLabel.setText(meilleurScore.getJoueur());
            BestScrLabel.setText(String.valueOf(meilleurScore.getTop()));
            BestOwnScrLabel.setText(String.valueOf(player.getMeilleurScore()));
            Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
            alertInformation.setTitle("Information");
            alertInformation.setHeaderText("Game Over");
            alertInformation.setContentText("End of session");
            alertInformation.show();
            DiceBut.setDisable(true);

        });


    }
    
    public void run(int n1 , int n2) throws InterruptedException {

        RotateTransition rt = new RotateTransition();
        rt.setByAngle(360);
        rt.setNode(Dice1);
        rt.setDuration(Duration.millis(600));
        rt.play();
        rt.setOnFinished(j->Dice1.setImage(new Image(getClass().getResourceAsStream("/images/Dice"+n1+"W.png"))));

        RotateTransition rt2 = new RotateTransition();
        rt2.setByAngle(360);
        rt2.setNode(Dice2);
        rt2.setDuration(Duration.millis(600));
        rt2.play();
        rt2.setOnFinished(j->Dice2.setImage(new Image(getClass().getResourceAsStream("/images/Dice"+n2+"B.png"))));
    }
}
