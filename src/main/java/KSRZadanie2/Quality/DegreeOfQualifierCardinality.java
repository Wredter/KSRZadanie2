package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class DegreeOfQualifierCardinality implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return null;
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        return 1-CardinaltyDegree(secondTypeSummary.ValuesForQualifier,secondTypeSummary.Qualifier.fuzzySet);
    }
    private Double CardinaltyDegree(List<Double> values , FuzzySet fuzzySet){
        double result = 0;
        for(Double valu : values){
            result += fuzzySet.MemberFuncResult(valu);
        }
        return result/values.size();
    }
}
