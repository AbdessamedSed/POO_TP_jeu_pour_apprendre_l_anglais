package Models;

import java.util.ArrayList;
import java.util.List;

public abstract class CaseQuestion extends Case {
    private List<Question> questionList = new ArrayList<>();

    public CaseQuestion(Couleur color) {
        super(color);
    }

    public CaseQuestion(){

    }

    public abstract Question selectQuestion(int num);


}
