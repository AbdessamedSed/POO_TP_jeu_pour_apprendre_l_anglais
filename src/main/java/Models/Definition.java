package Models;

import java.util.ArrayList;
import java.util.List;

public class Definition extends CaseQuestion {
        private List<Question> questionList = new ArrayList<>();

        public Definition(Couleur color) {
                super(color);
        }

        public Definition() {
                CreateQuestions();
        }

        public void CreateQuestions() {
                questionList.add(new Question("An institution for educating pupils", new Reponse[] {
                                new Reponse("home", false),
                                new Reponse("school", true),
                                new Reponse("zoo", false),
                                new Reponse("hospital", false),
                }));

                questionList.add(new Question("A building for islamic religious activities and worship", new Reponse[] {
                                new Reponse("mosque", true),
                                new Reponse("school", false),
                                new Reponse("hospital", false),
                                new Reponse("stadium", false),
                }));

                questionList.add(new Question("A meal eaten in the morning, the first of the day", new Reponse[] {
                                new Reponse("dinner", false),
                                new Reponse("lunch", false),
                                new Reponse("breakfast", true),
                                new Reponse("afternoon tea", false),
                }));

                questionList.add(new Question("An abstract or general idea inferred from specific instances ",
                        new Reponse[] {
                                new Reponse("concept", true),
                                new Reponse("information", false),
                                new Reponse("theoreme", false),
                                new Reponse("theory", false),
                        }));

                questionList.add(new Question("A section of text, particularly a section of medium length",
                        new Reponse[] {
                                new Reponse("passage", true),
                                new Reponse("phrase", false),
                                new Reponse("sentence", false),
                                new Reponse("parapgraph", false),
                        }));
                questionList.add(new Question("A well-substantiated explanation of some aspect of the world",
                        new Reponse[] {
                                new Reponse("theory", true),
                                new Reponse("philosophy", false),
                                new Reponse("science", false),
                                new Reponse("information", false),
                        }));
                questionList.add(new Question("A person of noble birth trained to arms and chivalry",
                        new Reponse[] {
                                new Reponse("knight", true),
                                new Reponse("prince", false),
                                new Reponse("king", false),
                                new Reponse("soldier", false),
                        }));
                questionList.add(new Question("The geographical area under the jurisdiction of a state",
                        new Reponse[] {
                                new Reponse("territory", true),
                                new Reponse("surface", false),
                                new Reponse("state", false),
                                new Reponse("place", false),
                        }));
                questionList.add(new Question("A person who pleads for a person, cause, or idea",
                        new Reponse[] {
                                new Reponse("advocate", true),
                                new Reponse("jury", false),
                                new Reponse("brother", false),
                                new Reponse("servant", false),
                        }));
                questionList.add(new Question("The force of attraction between all masses in the universe",
                        new Reponse[] {
                                new Reponse("gravity", true),
                                new Reponse("newton's force", false),
                                new Reponse("physics", false),
                                new Reponse("weight", false),
                        }));
                questionList.add(new Question("An instrumentality invented for a particular purpose",
                        new Reponse[] {
                                new Reponse("device", true),
                                new Reponse("invention", false),
                                new Reponse("computer", false),
                                new Reponse("perephiric", false),
                        }));
                questionList.add(new Question("Produced or growing in extreme abundance",
                        new Reponse[] {
                                new Reponse("luxuriant", true),
                                new Reponse("mark product", false),
                                new Reponse("goody", false),
                                new Reponse("device", false),
                        }));
                questionList.add(new Question("Something that baffles understanding and cannot be explained",
                        new Reponse[] {
                                new Reponse("enigma", true),
                                new Reponse("algorithme", false),
                                new Reponse("code", false),
                                new Reponse("text", false),
                        }));

        }

        @Override
        public Question selectQuestion(int num) {
                return questionList.get(num);
        }
}
