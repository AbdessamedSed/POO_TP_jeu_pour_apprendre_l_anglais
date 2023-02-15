package Models;

import java.util.ArrayList;
import java.util.List;

public class ImageQue extends CaseQuestion {
    private List<Question> imagesList = new ArrayList<>();

    public ImageQue(Couleur color) {
        super(color);
    }

    public ImageQue() {
                CreateQuestions();
        }

    public void CreateQuestions() {
        imagesList.add(new Question("mosque", new Reponse[] {
                new Reponse("/images/2.png", false),
                new Reponse("/images/1.png", true),
                new Reponse("/images/3.png", false),
                new Reponse("/images/4.png", false),
        }));

        imagesList.add(new Question("cockies", new Reponse[] {
                new Reponse("/images/2.png", true),
                new Reponse("/images/1.png", false),
                new Reponse("/images/9.png", false),
                new Reponse("/images/7.png", false),
        }));

        imagesList.add(new Question("duck", new Reponse[] {
                new Reponse("/images/5.png", false),
                new Reponse("/images/4.png", false),
                new Reponse("/images/3.png", true),
                new Reponse("/images/2.png", false),
        }));

        imagesList.add(new Question("tree",
                new Reponse[] {
                        new Reponse("/images/4.png", true),
                        new Reponse("/images/8.png", false),
                        new Reponse("/images/1.png", false),
                        new Reponse("/images/2.png", false),
                }));

        imagesList.add(new Question("camera",
                new Reponse[] {
                        new Reponse("/images/5.png", true),
                        new Reponse("/images/8.png", false),
                        new Reponse("/images/4.png", false),
                        new Reponse("/images/1.png", false),
                }));
        imagesList.add(new Question("plane",
                new Reponse[] {
                        new Reponse("/images/6.png", true),
                        new Reponse("/images/2.png", false),
                        new Reponse("/images/1.png", false),
                        new Reponse("/images/10.png", false),
                }));
        imagesList.add(new Question("lion",
                new Reponse[] {
                        new Reponse("/images/7.png", true),
                        new Reponse("/images/10.png", false),
                        new Reponse("/images/3.png", false),
                        new Reponse("/images/2.png", false),
                }));
        imagesList.add(new Question("flag",
                new Reponse[] {
                        new Reponse("/images/8.png", true),
                        new Reponse("/images/10.png", false),
                        new Reponse("/images/2.png", false),
                        new Reponse("/images/3.png", false),
                }));
        imagesList.add(new Question("city",
                new Reponse[] {
                        new Reponse("/images/9.png", true),
                        new Reponse("/images/2.png", false),
                        new Reponse("/images/3.png", false),
                        new Reponse("/images/1.png", false),
                }));
        imagesList.add(new Question("treasure",
                new Reponse[] {
                        new Reponse("/images/10.png", true),
                        new Reponse("/images/7.png", false),
                        new Reponse("/images/2.png", false),
                        new Reponse("/images/3.png", false),
                }));

    }

    @Override
    public Question selectQuestion(int num) {
        return imagesList.get(num);
    }
}
