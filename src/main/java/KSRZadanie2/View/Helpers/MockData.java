package KSRZadanie2.View.Helpers;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import KSRZadanie2.Model.LinguisticVariables.Qualifier;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import KSRZadanie2.View.MainController;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    public List<Summarizer> summarizers;
    public List<Quantifier> quantifiers;
    public List<Qualifier> qualifiers;

    public MockData() {
        summarizers = new ArrayList<>();
        quantifiers = new ArrayList<>();
        qualifiers = new ArrayList<>();
        //CreateSummarizer1();
        //CreateQuantifier11();
    }

    void CreateSummarizer1() {
        RectangleMemberFunc func = new RectangleMemberFunc(32.0, 42.0, 40.0, 34.0, 1.0);
        FuzzySet set = new FuzzySet(func);
        Summarizer s = new Summarizer("dużo oddanych strzałów", set, "homeTeamShots");
        summarizers.add(s);
    }

//    void CreateQuantifier11() {
//        RectangleMemberFunc func = new RectangleMemberFunc(10.0, 20.0, 18.0, 12.0, 1.0);
//        FuzzySet set = new FuzzySet(func);
//        Quantifier q = new Quantifier("Mało", set, "homeTeamShots");
//        quantifiers.add(q);
//    }
}
