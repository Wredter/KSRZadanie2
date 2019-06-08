package KSRZadanie2.Quality;

import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

public class LengthOfSummary implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        if(firstTypeSummary.Operation.equals("NONE")){
            return 2*Math.pow(0.5,1);
        }else {
            return 2*Math.pow(0.5,2);
        }
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        if(secondTypeSummary.Operation.equals("NONE")){
            return 2*Math.pow(0.5,2);
        }else {
            return 2*Math.pow(0.5,3);
        }
    }
}
