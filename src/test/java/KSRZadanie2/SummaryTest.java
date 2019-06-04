package KSRZadanie2;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.MembershipFunction.IMemberFunc;
import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import org.junit.Test;

import java.util.ArrayList;

public class SummaryTest {

    // To Do
    @Test
    public void SummaryExampleTest() {
        ArrayList<Double> gradesList = new ArrayList<>();
        gradesList.add(5.0);
        gradesList.add(5.0);
        gradesList.add(4.0);
        gradesList.add(3.5);
        gradesList.add(4.0);
        gradesList.add(4.0);
        gradesList.add(2.0);
        gradesList.add(3.0);


        IMemberFunc quantifierMemberFunc = new RectangleMemberFunc(0.12, 0.44, 0.36, 0.16, 1.0);
        IMemberFunc summarizerMemberFunc = new RectangleMemberFunc(0.0, 5.0, 3.5, 0.0, 1.0);

        FuzzySet quantifierFuzzySet = new FuzzySet(quantifierMemberFunc);
        FuzzySet summarizationFuzzySet = new FuzzySet(summarizerMemberFunc);

        Quantifier quantifier = new Quantifier("Większość", quantifierFuzzySet);
        Summarizer summarizer = new Summarizer("dobre oceny", summarizationFuzzySet);

        String summary = quantifier.label + " studentów ma " + summarizer.label;
        // Calculate degree
        Double result = 0.5;
        summary += " [" + result + "]";

        System.out.println(summary);
    }
}
