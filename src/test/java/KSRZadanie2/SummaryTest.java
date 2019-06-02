package KSRZadanie2;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.MembershipFunction.IMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import KSRZadanie2.Model.LinguisticVariables.LinguisticVariable;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import org.junit.Test;

import java.util.ArrayList;

public class SummaryTest {

    // To Do
    @Test
    public void SummaryExampleTest() {
        ArrayList<Double> gradesList = new ArrayList<>();
        gradesList.add(3.0);
        gradesList.add(5.0);
        gradesList.add(3.0);
        gradesList.add(3.5);
        gradesList.add(4.0);
        gradesList.add(2.0);
        gradesList.add(2.0);
        gradesList.add(3.0);

        IMemberFunc quantifierMemberFunc = new TriangleMemberFunc(0.1, 0.5, 0.3, 1.0);
        IMemberFunc summarizerMemberFunc = new TriangleMemberFunc(0.2, 0.8, 0.5, 1.0);

        FuzzySet quantifierFuzzySet = new FuzzySet(quantifierMemberFunc);
        FuzzySet summarizationFuzzySet = new FuzzySet(summarizerMemberFunc);

        Quantifier quantifier = new Quantifier("Większość", quantifierFuzzySet);
        Summarizer summarizer = new Summarizer("dobre", summarizationFuzzySet);

        String result = quantifier.label + " studentów dostała " + summarizer.label + " oceny";
        System.out.println(result);

    }
}
