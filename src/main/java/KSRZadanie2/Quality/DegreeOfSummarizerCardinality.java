package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class DegreeOfSummarizerCardinality implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        if(firstTypeSummary.Operation.equals("NONE")){
            return 1-(CardinaltyDegree(firstTypeSummary.ValuesForSummarizer1,firstTypeSummary.Summarizer1.fuzzySet));
        }else {
            return 1-(Math.sqrt(CardinaltyDegree(firstTypeSummary.ValuesForSummarizer1,firstTypeSummary.Summarizer1.fuzzySet)
                    *CardinaltyDegree(firstTypeSummary.ValuesForSummarizer2,firstTypeSummary.Summarizer2.fuzzySet)));
        }
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        if(secondTypeSummary.Operation.equals("NONE")){
            return 1-(Math.sqrt(CardinaltyDegree(secondTypeSummary.ValuesForSummarizer1,secondTypeSummary.Summarizer1.fuzzySet)
                    *CardinaltyDegree(secondTypeSummary.ValuesForQualifier,secondTypeSummary.Qualifier.fuzzySet)));
        }else {
            return 1-(Math.pow(CardinaltyDegree(secondTypeSummary.ValuesForSummarizer1,secondTypeSummary.Summarizer1.fuzzySet)
                    *CardinaltyDegree(secondTypeSummary.ValuesForQualifier,secondTypeSummary.Qualifier.fuzzySet)
                    *CardinaltyDegree(secondTypeSummary.ValuesForSummarizer2,secondTypeSummary.Summarizer2.fuzzySet),0.33));
        }
    }
    private Double CardinaltyDegree(List<Double> values , FuzzySet fuzzySet){
        double result = 0;
        for(Double valu : values){
            result += fuzzySet.MemberFuncResult(valu);
        }
        return result/values.size();
    }
}
