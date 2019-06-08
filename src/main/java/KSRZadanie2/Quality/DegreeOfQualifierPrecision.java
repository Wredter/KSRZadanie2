package KSRZadanie2.Quality;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class DegreeOfQualifierPrecision implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return null;
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        return 1 - Fuzzines(secondTypeSummary.ValuesForQualifier,secondTypeSummary.Qualifier.fuzzySet);
    }
    public Double Fuzzines(List<Double> values , FuzzySet fuzzySet){
        int counter=0;
        for(Double value : values){
            if(fuzzySet.MemberFuncResult(value)>0){
                counter++;
            }
        }
        return (double) counter/(double) values.size();
    }
}
