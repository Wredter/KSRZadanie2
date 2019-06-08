package KSRZadanie2.Model.Summary;

import KSRZadanie2.Model.LinguisticVariables.Qualifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;

import java.util.List;
//QP będących S1 jest S2//
public class SecondTypeSummary extends FirstTypeSummary {
    List<Double> ValuesForQualifier;
    Qualifier Qualifier;

    public SecondTypeSummary(String subject, KSRZadanie2.Model.LinguisticVariables.Quantifier quantifier, List<Double> valuesForQualifier, Summarizer summarizer1, List<Double> valuesForSummarizer1, List<Double> valuesForQuantifier, Qualifier qualifier) {
        super(subject, quantifier, valuesForQualifier, summarizer1, valuesForSummarizer1);
        ValuesForQualifier = valuesForQuantifier;
        Qualifier = qualifier;
    }

    public SecondTypeSummary(String subject, KSRZadanie2.Model.LinguisticVariables.Quantifier quantifier, List<Double> valuesForQualifier, Summarizer summarizer1, Summarizer summarizer2, List<Double> valuesForSummarizer1, List<Double> valuesForSummarizer2, String operation, List<Double> valuesForQuantifier, Qualifier qualifier) {
        super(subject, quantifier, valuesForQualifier, summarizer1, summarizer2, valuesForSummarizer1, valuesForSummarizer2, operation);
        ValuesForQualifier = valuesForQuantifier;
        Qualifier = qualifier;
    }
    @Override
    public String toString() {
        if(Operation.equals("NONE")){
            return String.format("%1$s %2$s będących %3$s jest %4$s",Quantifier.label,Subject,Qualifier.label,Summarizer1.label);
        }if(Operation.equals("AND")){
            return String.format("%1$s %2$s będących %3$s jest %4$s oraz %5$s",Quantifier.label,Subject,Qualifier.label,Summarizer1.label,Summarizer2.label);
        }if(Operation.equals("OR")){
            return String.format("%1$s %2$s będących %3$s jest %4$s lub %5$s",Quantifier.label,Subject,Qualifier.label,Summarizer1.label,Summarizer2.label);
        }else {
            return "Summary does not meet requirements";
        }
    }
}
