package KSRZadanie2.View;

import KSRZadanie2.MembershipFunction.IMemberFunc;
import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;

import java.util.ArrayList;
import java.util.List;

public class DataContext {
    public IMemberFunc rectangleMemberFunc;
    public IMemberFunc triangleMemberFunc;

    public List<Summarizer> summarizers;
    public List<Quantifier> quantifiers;

    public DataContext() {
        rectangleMemberFunc = new RectangleMemberFunc();
        triangleMemberFunc = new TriangleMemberFunc();

        summarizers = new ArrayList<>();
        quantifiers = new ArrayList<>();
    }
}
