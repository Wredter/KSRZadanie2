package KSRZadanie2.Quality;

import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

public interface IDegree {
    public Double Calc(FirstTypeSummary firstTypeSummary);
    public Double Calc(SecondTypeSummary secondTypeSummary);
}
