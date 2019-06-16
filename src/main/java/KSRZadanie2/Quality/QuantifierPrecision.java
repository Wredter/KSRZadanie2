package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class QuantifierPrecision implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        Double x = 1-(firstTypeSummary.Quantifier.fuzzySet.memberFunc.SuppNiepoliczalny()/1.0);
        return x;
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        Double x = 1-(secondTypeSummary.Quantifier.fuzzySet.memberFunc.SuppNiepoliczalny()/1.0);
        return x;
    }

}
