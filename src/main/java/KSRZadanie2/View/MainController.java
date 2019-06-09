package KSRZadanie2.View;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.MembershipFunction.IMemberFunc;
import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import KSRZadanie2.Model.LinguisticVariables.LinguisticVariable;
import KSRZadanie2.Model.LinguisticVariables.Qualifier;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;

import javax.swing.*;

public class MainController {
    public DataContext dataContext;

    public MainController() {
        dataContext = new DataContext();
    }

    public void ResetDataContext() {
        dataContext = new DataContext();
    }

    public IMemberFunc CreateMemberFunc(String name, Double a, Double b, Double c, Double d){
        if(name.equals(dataContext.rectangleMemberFunc.ToString())) {
            return new RectangleMemberFunc(a, b, c, d, 1.0);
        } else if(name.equals(dataContext.triangleMemberFunc.ToString())) {
            return new TriangleMemberFunc(a, b, c, 1.0);
        }
        return null;
    }

    public void CreateSummarizer(String attribute, String label, String memberFuncName, Double a, Double b, Double c, Double d) {
        FuzzySet set = new FuzzySet(CreateMemberFunc(memberFuncName, a, b, c, d));
        Summarizer summarizer = new Summarizer(label, set, attribute);

        dataContext.summarizers.add(summarizer);
    }

    public void CreateQuantifier(String label, String memberFuncName, Double a, Double b, Double c, Double d) {
        FuzzySet set = new FuzzySet(CreateMemberFunc(memberFuncName, a, b, c, d));
        Quantifier quantifier = new Quantifier(label, set);

        dataContext.quantifiers.add(quantifier);
    }

    public void CreateQualifier(String label, String memberFuncName, Double a, Double b, Double c, Double d) {
        FuzzySet set = new FuzzySet(CreateMemberFunc(memberFuncName, a, b, c, d));
        Qualifier qualifier = new Qualifier(label, set);

        dataContext.qualifiers.add(qualifier);
    }

    public void CreateSummary() {
        // to do
    }

}
