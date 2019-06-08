package KSRZadanie2.Model.Summary;

import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;

import java.util.List;
//QP będących S1 jest S2//
public class SecondTypeSummary extends FirstTypeSummary {
    List<Double> ValuesForQuantifier;
    Quantifier Quantifier;

    public SecondTypeSummary(String subject, KSRZadanie2.Model.LinguisticVariables.Quantifier quantifier, List<Double> valuesForQualifier, Summarizer summarizer1, List<Double> valuesForSummarizer1, List<Double> valuesForQuantifier, Quantifier quantifier1) {
        super(subject, quantifier, valuesForQualifier, summarizer1, valuesForSummarizer1);
        ValuesForQuantifier = valuesForQuantifier;
        Quantifier = quantifier1;
    }

    public SecondTypeSummary(String subject, KSRZadanie2.Model.LinguisticVariables.Quantifier quantifier, List<Double> valuesForQualifier, Summarizer summarizer1, Summarizer summarizer2, List<Double> valuesForSummarizer1, List<Double> valuesForSummarizer2, String operation, List<Double> valuesForQuantifier, Quantifier quantifier1) {
        super(subject, quantifier, valuesForQualifier, summarizer1, summarizer2, valuesForSummarizer1, valuesForSummarizer2, operation);
        ValuesForQuantifier = valuesForQuantifier;
        Quantifier = quantifier1;
    }
}
