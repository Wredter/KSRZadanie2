package KSRZadanie2.Quality;

import KSRZadanie2.Model.LinguisticVariables.LinguisticVariable;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DegreeOfTruth implements IDegree {
    public List<Double> ValuesForSummarizer1;
    public List<Double> ValuesForSummarizer2;
    public Quantifier Quantifier;
    public List<Double> ValuesForQualifier;
    public Summarizer Summarizer1;
    public Summarizer Summarizer2;
    public String Operation = "NONE";
    public LinguisticVariable Qualifier;

    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return Quantifier.fuzzySet.MemberFuncResult(r() / ValuesForSummarizer1.size());
    }

    private Double r() {
        Double result = 0.0;
        if (Operation.equals("OR")) {
            for (int i = 0; i < ValuesForSummarizer1.size(); i++) {
                result += Math.min(Summarizer1.fuzzySet.Union(Summarizer1.fuzzySet, ValuesForSummarizer1.get(i), ValuesForSummarizer2.get(i)), Qualifier.fuzzySet.MemberFuncResult(ValuesForQualifier.get(i)));
            }
        } else if (Operation.equals("AND")) {
            for (int i = 0; i < ValuesForSummarizer1.size(); i++) {
                result += Math.min(Summarizer1.fuzzySet.Complement(Summarizer1.fuzzySet, ValuesForSummarizer1.get(i), ValuesForSummarizer2.get(i)), Qualifier.fuzzySet.MemberFuncResult(ValuesForQualifier.get(i)));
            }
        } else {
            for (int i = 0; i < ValuesForSummarizer1.size(); i++) {
                result += Summarizer1.fuzzySet.Complement(Quantifier.fuzzySet, ValuesForSummarizer1.get(i), ValuesForSummarizer1.get(i));
            }
        }

        Double denominator = 0.0;
        for (Double val: ValuesForQualifier) {
            denominator += Qualifier.fuzzySet.MemberFuncResult(val);
        }

        return result / denominator;
    }
}
