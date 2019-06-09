package KSRZadanie2.View;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.MembershipFunction.IMemberFunc;
import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import KSRZadanie2.Model.DataService.DataInserter;
import KSRZadanie2.Model.DataService.DataLoader;
import KSRZadanie2.Model.LinguisticVariables.Qualifier;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import KSRZadanie2.Model.Match;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.ArrayList;

public class MainController {
    public DataContext dataContext;

    public MainController() {
        dataContext = new DataContext();
        LoadMatches();
    }

    public void ResetDataContext() {
        dataContext = new DataContext();
    }

    public void LoadMatches() {
        DataLoader dl = new DataLoader();
        dl.downloadFiles("Data");
        dataContext.matches = DataInserter.insert();
    }

    public IMemberFunc CreateMemberFunc(String name, Double a, Double b, Double c, Double d) {
        if (name.equals(dataContext.rectangleMemberFunc.ToString())) {
            return new RectangleMemberFunc(a, b, c, d, 1.0);
        } else if (name.equals(dataContext.triangleMemberFunc.ToString())) {
            return new TriangleMemberFunc(a, b, c, 1.0);
        }
        return null;
    }

    public void CreateSummarizer(String attribute, String label, String memberFuncName, Double a, Double b, Double c, Double d) {
        FuzzySet set = new FuzzySet(CreateMemberFunc(memberFuncName, a, b, c, d));
        Summarizer summarizer = new Summarizer(label, set, attribute);

        dataContext.summarizers.add(summarizer);
    }

    public Summarizer GetSummarizer(String label) {
        for (Summarizer s : dataContext.summarizers) {
            if (label.equals(s.label)) {
                return s;
            }
        }
        return null;
    }

    public void CreateQuantifier(String attribute, String label, String memberFuncName, Double a, Double b, Double c, Double d) {
        FuzzySet set = new FuzzySet(CreateMemberFunc(memberFuncName, a, b, c, d));
        Quantifier quantifier = new Quantifier(label, set, attribute);

        dataContext.quantifiers.add(quantifier);
    }

    public Quantifier GetQuantifier(String label) {
        for (Quantifier q : dataContext.quantifiers) {
            if (label.equals(q.label)) {
                return q;
            }
        }
        return null;
    }

    public void CreateQualifier(String attribute, String label, String memberFuncName, Double a, Double b, Double c, Double d) {
        FuzzySet set = new FuzzySet(CreateMemberFunc(memberFuncName, a, b, c, d));
        Qualifier qualifier = new Qualifier(label, set, attribute);

        dataContext.qualifiers.add(qualifier);
    }

    public Qualifier GetQualifier(String label) {
        for (Qualifier q : dataContext.qualifiers) {
            if (label.equals(q.label)) {
                return q;
            }
        }
        return null;
    }

    public void CreateSummary(String subject, String quantifierLabel, String summarizer1Label, String summarizer2Label, String operationLabel, String qualifierLabel) {
        Quantifier quantifier = GetQuantifier(quantifierLabel);
        ArrayList<Double> quantifierValues = PrepareAttributeValuesList(quantifier.attribute);

        Summarizer summarizer1 = GetSummarizer(summarizer1Label);
        ArrayList<Double> summarizer1Values = PrepareAttributeValuesList(summarizer1.attribute);

        Summarizer summarizer2;
        ArrayList<Double> summarizer2Values;

        Qualifier qualifier;
        ArrayList<Double> qualifierValues;


        if (summarizer2Label.equals("NONE") && operationLabel.equals("NONE") && qualifierLabel.equals("NONE")) {
            FirstTypeSummary summaryType1 = new FirstTypeSummary(subject, quantifier, quantifierValues, summarizer1, summarizer1Values);
            dataContext.summaries1.add(summaryType1);
        } else if (qualifierLabel.equals("NONE")) {
            summarizer2 = GetSummarizer(summarizer2Label);
            summarizer2Values = PrepareAttributeValuesList(summarizer2.attribute);
            FirstTypeSummary summaryType1 = new FirstTypeSummary(subject, quantifier, quantifierValues, summarizer1, summarizer2, summarizer1Values, summarizer2Values, operationLabel);
            dataContext.summaries1.add(summaryType1);
        }


        if (!qualifierLabel.equals("NONE")) {
            qualifier = GetQualifier(qualifierLabel);
            qualifierValues = PrepareAttributeValuesList(qualifier.attribute);

            if (summarizer2Label.equals("NONE") && operationLabel.equals("NONE")) {
                SecondTypeSummary summaryType2 = new SecondTypeSummary(subject, quantifier, quantifierValues, summarizer1, summarizer1Values, qualifierValues, qualifier);
                dataContext.summaries2.add(summaryType2);
            } else {
                summarizer2 = GetSummarizer(summarizer2Label);
                summarizer2Values = PrepareAttributeValuesList(summarizer2.attribute);
                SecondTypeSummary summaryType2 = new SecondTypeSummary(subject, quantifier, quantifierValues, summarizer1, summarizer2, summarizer1Values, summarizer2Values, operationLabel, quantifierValues, qualifier);
                dataContext.summaries2.add(summaryType2);
            }
        }

    }

    public ArrayList<Double> PrepareAttributeValuesList(String attr) {
        Match match = new Match();
        ArrayList<Double> result = new ArrayList<>();

        for (Match m : dataContext.matches) {
            if (ValidateAttribute(attr, match.ToStringFullTimeHomeGoals(), m.getFullTimeHomeGoals())) {
                result.add(m.getFullTimeHomeGoals().doubleValue());
            }
            if (ValidateAttribute(attr, match.ToStringFullTimeAwayGoals(), m.getFullTimeAwayGoals())) {
                result.add(m.getFullTimeAwayGoals().doubleValue());
            }

            if (ValidateAttribute(attr, match.ToStringHalfTimeHomeTeamGoals(), m.getHalfTimeHomeTeamGoals())) {
                result.add(m.getHalfTimeHomeTeamGoals().doubleValue());
            }
            if (ValidateAttribute(attr, match.ToStringHalfTimeAwayTeamGoals(), m.getHalfTimeAwayTeamGoals())) {
                result.add(m.getHalfTimeAwayTeamGoals().doubleValue());
            }

            if (ValidateAttribute(attr, match.ToStringHomeTeamShoots(), m.getHomeTeamShots())) {
                result.add(m.getHomeTeamShots().doubleValue());
            }
            if (ValidateAttribute(attr, match.ToStringAwayTeamShots(), m.getAwayTeamShots())) {
                result.add(m.getAwayTeamShots().doubleValue());
            }

            if (ValidateAttribute(attr, match.ToStringHomeTeamShotsOnTarget(), m.getHomeTeamShotsOnTarget())) {
                result.add(m.getHomeTeamShotsOnTarget().doubleValue());
            }
            if (ValidateAttribute(attr, match.ToStringAwayTeamShotsOnTarget(), m.getAwayTeamShotsOnTarget())) {
                result.add(m.getAwayTeamShotsOnTarget().doubleValue());
            }


            if (ValidateAttribute(attr, match.ToStringHomeTeamFoulsCommitted(), m.getHomeTeamFoulsCommitted())) {
                result.add(m.getHomeTeamFoulsCommitted().doubleValue());
            }
            if (ValidateAttribute(attr, match.ToStringAwayTeamFoulsCommitted(), m.getAwayTeamFoulsCommitted())) {
                result.add(m.getAwayTeamFoulsCommitted().doubleValue());
            }
        }

        return result;
    }

    public Boolean ValidateAttribute(String attr, String aimAttr, Number num) {
        if (attr.equals(aimAttr) && num != null) {
            return true;
        }
        return false;
    }

}
