package KSRZadanie2.Quality;

import KSRZadanie2.Model.LinguisticVariables.LinguisticVariable;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;
import lombok.AllArgsConstructor;

import java.util.List;
//Narazie może być ale nie na zawsze
@AllArgsConstructor
public class DegreeOfTruth implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        if(firstTypeSummary.Quantifier.isBezwzgl) {
            return firstTypeSummary.Quantifier.fuzzySet.MemberFuncResult(r(firstTypeSummary));
        }else {
            return firstTypeSummary.Quantifier.fuzzySet.MemberFuncResult(r(firstTypeSummary) / firstTypeSummary.DataSetSize);
        }
    }
    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary){
        if(secondTypeSummary.Quantifier.isBezwzgl) {
            return secondTypeSummary.Quantifier.fuzzySet.MemberFuncResult(r(secondTypeSummary));
        }else {
            return secondTypeSummary.Quantifier.fuzzySet.MemberFuncResult(r(secondTypeSummary) / secondTypeSummary.DataSetSize);
        }
    }

    private Double r(FirstTypeSummary firstTypeSummary) {
        Double result = 0.0;
        int size;
        if(!firstTypeSummary.Operation.equals("NONE")) {
            if (firstTypeSummary.ValuesForSummarizer1.size() >= firstTypeSummary.ValuesForSummarizer2.size()) {
                size = firstTypeSummary.ValuesForSummarizer2.size();
            } else {
                size = firstTypeSummary.ValuesForSummarizer1.size();
            }
        }else {
            size = firstTypeSummary.ValuesForSummarizer1.size();
        }

        int j;
        if (firstTypeSummary.Operation.equals("OR")) {
            for (int i = 0;i < size; i++) {
                result += Math.max(firstTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(firstTypeSummary.ValuesForSummarizer1.get(i)),firstTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(firstTypeSummary.ValuesForSummarizer2.get(i)));
            }
        } else if (firstTypeSummary.Operation.equals("AND")) {
            for (int i = 0;i < size; i++) {
                result += Math.min(firstTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(firstTypeSummary.ValuesForSummarizer1.get(i)),firstTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(firstTypeSummary.ValuesForSummarizer2.get(i)));
            }
        } else {
            for (Double value : firstTypeSummary.ValuesForSummarizer1) {
                result += firstTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(value);
            }
        }
        return result;
    }
    private Double r(SecondTypeSummary secondTypeSummary) {
        Double result = 0.0;
        int size;
        if (secondTypeSummary.ValuesForSummarizer1.size() >= secondTypeSummary.ValuesForQualifier.size()) {
            size = secondTypeSummary.ValuesForQualifier.size();
        } else {
            size = secondTypeSummary.ValuesForSummarizer1.size();
        }
        if(!secondTypeSummary.Operation.equals("NONE")){
            if (size >= secondTypeSummary.ValuesForSummarizer2.size()) {
                size = secondTypeSummary.ValuesForSummarizer2.size();
            }
        }
        if (secondTypeSummary.Operation.equals("OR")) {
            for (int i = 0;i < size; i++) {
                result += Math.min(Math.max(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer1.get(i)),secondTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer2.get(i))),secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i)));
            }
        } else if (secondTypeSummary.Operation.equals("AND")) {
            for (int i = 0;i < size; i++) {
                result += Math.min(Math.min(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer1.get(i)),secondTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer2.get(i))),secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i)));
            }
        } else {
            for (int i = 0;i < size; i++) {
                result += Math.min(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer1.get(i)),secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i)));
            }
        }
        double divader = 0.0;
        for(int i = 0;i < secondTypeSummary.ValuesForQualifier.size(); i++){
            divader += secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i));
        }
        return result/divader;
    }
}
