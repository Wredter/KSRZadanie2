package KSRZadanie2.Quality;

import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

public class LengthOfQualifier implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return 0.0;
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        return 1d;
    }
}
