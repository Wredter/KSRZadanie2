package KSRZadanie2.View;

import KSRZadanie2.MembershipFunction.IMemberFunc;
import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import KSRZadanie2.Model.LinguisticVariables.Qualifier;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import KSRZadanie2.Model.Match;
import KSRZadanie2.Model.Quality;

import java.util.ArrayList;
import java.util.List;

public class DataContext {
    public List<Match> matches;

    public IMemberFunc rectangleMemberFunc;
    public IMemberFunc triangleMemberFunc;

    public List<Summarizer> summarizers;
    public List<Quantifier> quantifiers;
    public List<Qualifier> qualifiers;

//    public List<FirstTypeSummary> summaries1;
//    public List<SecondTypeSummary> summaries2;

    public List<Quality> summaries1;
    public List<Quality> summaries2;


    public DataContext() {
        matches = new ArrayList<>();
        rectangleMemberFunc = new RectangleMemberFunc();
        triangleMemberFunc = new TriangleMemberFunc();

        summarizers = new ArrayList<>();
        quantifiers = new ArrayList<>();
        qualifiers = new ArrayList<>();

        summaries1 = new ArrayList<>();
        summaries2 = new ArrayList<>();

    }
}
