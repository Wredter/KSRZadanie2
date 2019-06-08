package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class QuantifierPrecision implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return 1-(CalcR(firstTypeSummary.ValuesForQuantifier,firstTypeSummary.Quantifier.fuzzySet));
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        return 1-(CalcR(secondTypeSummary.ValuesForQuantifier,secondTypeSummary.Quantifier.fuzzySet));
    }
    private Double CalcR(List<Double> values , FuzzySet fuzzySet) {
        int counter = 0;
        for (Double value : values) {
            if (fuzzySet.MemberFuncResult(value) > 0) {
                counter++;
            }
        }
        return (double) counter / (double) values.size();
    }
}
