package KSRZadanie2.View;

import KSRZadanie2.MembershipFunction.IMemberFunc;
import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import KSRZadanie2.Model.LinguisticVariables.Qualifier;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.ArrayList;
import java.util.List;

public class DataContext {
    public IMemberFunc rectangleMemberFunc;
    public IMemberFunc triangleMemberFunc;

    public List<Summarizer> summarizers;
    public List<Quantifier> quantifiers;
    public List<Qualifier> qualifiers;

    public List<FirstTypeSummary> summaries1;
    public List<SecondTypeSummary> summaries2;

    public DataContext() {
        rectangleMemberFunc = new RectangleMemberFunc();
        triangleMemberFunc = new TriangleMemberFunc();

        summarizers = new ArrayList<>();
        quantifiers = new ArrayList<>();
        qualifiers = new ArrayList<>();

        summaries1 = new ArrayList<>();
        summaries2 = new ArrayList<>();
    }
}
