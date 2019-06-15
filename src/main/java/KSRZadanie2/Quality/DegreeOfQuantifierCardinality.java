package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class DegreeOfQuantifierCardinality implements IDegree {

    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return 1- (firstTypeSummary.Quantifier.fuzzySet.memberFunc.clmNiepoliczalny()/1.0);
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        return 1- (secondTypeSummary.Quantifier.fuzzySet.memberFunc.clmNiepoliczalny()/1.0);
    }

}
