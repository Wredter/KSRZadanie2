package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class DegreeOfQuantifierCardinality implements IDegree {

    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return 1- (Cardinalty(firstTypeSummary.ValuesForQuantifier,firstTypeSummary.Quantifier.fuzzySet)/(double)firstTypeSummary.ValuesForQuantifier.size());
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        return 1- (Cardinalty(secondTypeSummary.ValuesForQuantifier,secondTypeSummary.Quantifier.fuzzySet)/(double)secondTypeSummary.ValuesForQuantifier.size());
    }
    private Double Cardinalty(List<Double> values , FuzzySet fuzzySet){
        double result = 0;
        for(Double valu : values){
            result += fuzzySet.MemberFuncResult(valu);
        }
        return result;
    }
}
