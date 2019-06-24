package KSRZadanie2.Model.Summary;

import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;

import java.io.Serializable;
import java.util.List;

//QP jest/ma S//
public class FirstTypeSummary implements Serializable
{
    public String Subject;
    public Quantifier Quantifier;
    public int DataSetSize;
    public Summarizer Summarizer1;
    public Summarizer Summarizer2;
    public List<Double> ValuesForSummarizer1;
    public List<Double> ValuesForSummarizer2;
    public String Operation = "NONE";

    public FirstTypeSummary(String subject, KSRZadanie2.Model.LinguisticVariables.Quantifier quantifier, int valuesForQualifier, Summarizer summarizer1, List<Double> valuesForSummarizer1) {
        Subject = subject;
        Quantifier = quantifier;
        DataSetSize = valuesForQualifier;
        Summarizer1 = summarizer1;
        ValuesForSummarizer1 = valuesForSummarizer1;
    }

    public FirstTypeSummary(String subject, KSRZadanie2.Model.LinguisticVariables.Quantifier quantifier, int valuesForQualifier, Summarizer summarizer1, Summarizer summarizer2, List<Double> valuesForSummarizer1, List<Double> valuesForSummarizer2, String operation) {
        Subject = subject;
        Quantifier = quantifier;
        DataSetSize = valuesForQualifier;
        Summarizer1 = summarizer1;
        Summarizer2 = summarizer2;
        ValuesForSummarizer1 = valuesForSummarizer1;
        ValuesForSummarizer2 = valuesForSummarizer2;
        Operation = operation;
    }

    @Override
    public String toString() {
        if(Operation.equals("NONE")){
            return String.format("%1$s %2$s jest/ma %3$s",Quantifier.label,Subject,Summarizer1.label);
        }if(Operation.equals("AND")){
            return String.format("%1$s %2$s jest/ma %3$s oraz %4$s",Quantifier.label,Subject,Summarizer1.label,Summarizer2.label);
        }if(Operation.equals("OR")){
            return String.format("%1$s %2$s jest/ma %3$s lub %4$s",Quantifier.label,Subject,Summarizer1.label,Summarizer2.label);
        }else {
            return "Summary does not meet requirements";
        }
    }
}
