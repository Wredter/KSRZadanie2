package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class DegreeOfAppropriatness implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        if(firstTypeSummary.Operation.equals("NONE")){
            return CalcR(firstTypeSummary.ValuesForSummarizer1,firstTypeSummary.Summarizer1.fuzzySet);
        }else {
            return CalcR(firstTypeSummary.ValuesForSummarizer1,firstTypeSummary.Summarizer1.fuzzySet)*CalcR(firstTypeSummary.ValuesForSummarizer2,firstTypeSummary.Summarizer2.fuzzySet);
        }
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        if(secondTypeSummary.Operation.equals("NONE")){
            return CalcR(secondTypeSummary.ValuesForSummarizer1,secondTypeSummary.Summarizer1.fuzzySet)*CalcR(secondTypeSummary.ValuesForQualifier,secondTypeSummary.Qualifier.fuzzySet);
        }else {
            return CalcR(secondTypeSummary.ValuesForSummarizer1,secondTypeSummary.Summarizer1.fuzzySet)*CalcR(secondTypeSummary.ValuesForSummarizer2,secondTypeSummary.Summarizer2.fuzzySet)*CalcR(secondTypeSummary.ValuesForQualifier,secondTypeSummary.Qualifier.fuzzySet);
        }
    }
    private Double CalcR(List<Double> values , FuzzySet fuzzySet){
        int counter =0;
        for (Double value : values){
            if(fuzzySet.MemberFuncResult(value)> 0){
                counter ++;
            }
        }
        return (double) counter / (double) values.size();
    }
}
