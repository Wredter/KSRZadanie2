package KSRZadanie2.Quality;

import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

public class DegreeOfPrecision implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        if(firstTypeSummary.Operation.equals("NONE")) {
            return 1 - DegreeOfFuzzines(firstTypeSummary);
        }else {
            return 1 - Math.sqrt(DegreeOfFuzzines(firstTypeSummary));
        }
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        if(secondTypeSummary.Operation.equals("NONE")) {
            return 1 - Math.sqrt(DegreeOfFuzzines(secondTypeSummary));
        }else {
            return 1 - Math.pow(DegreeOfFuzzines(secondTypeSummary),1f/3f);
        }
    }
    private Double DegreeOfFuzzines(FirstTypeSummary firstTypeSummary){
        int counter =0;
        double fuzzines;
        if (firstTypeSummary.Operation.equals("NONE")) {
            for(Double value : firstTypeSummary.ValuesForSummarizer1){
                if(firstTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(value)!=0){
                    counter ++;
                }
            }
            fuzzines = (double) counter/(double) firstTypeSummary.ValuesForSummarizer1.size();
        } else {
            for(Double value : firstTypeSummary.ValuesForSummarizer1){
                if(firstTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(value)!=0){
                    counter ++;
                }
            }
            fuzzines = (double) counter/(double) firstTypeSummary.ValuesForSummarizer1.size();
            counter =0 ;
            for(Double value : firstTypeSummary.ValuesForSummarizer2){
                if(firstTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(value)!=0){
                    counter ++;
                }
            }
            fuzzines *= (double) counter/(double) firstTypeSummary.ValuesForSummarizer2.size();
        }
        return fuzzines;
    }
    private Double DegreeOfFuzzines(SecondTypeSummary secondTypeSummary){
        int counter =0;
        double fuzzines;
        if (secondTypeSummary.Operation.equals("NONE")) {
            for(Double value : secondTypeSummary.ValuesForSummarizer1){
                if(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(value)!=0){
                    counter ++;
                }
            }
            fuzzines = (double) counter/(double) secondTypeSummary.ValuesForSummarizer1.size();
        } else {
            for(Double value : secondTypeSummary.ValuesForSummarizer1){
                if(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(value)!=0){
                    counter ++;
                }
            }
            fuzzines = (double) counter/(double) secondTypeSummary.ValuesForSummarizer1.size();
            counter =0 ;
            for(Double value : secondTypeSummary.ValuesForSummarizer2){
                if(secondTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(value)!=0){
                    counter ++;
                }
            }
            fuzzines *= (double) counter/(double) secondTypeSummary.ValuesForSummarizer2.size();
        }
        for(Double value : secondTypeSummary.ValuesForQualifier){
            if(secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(value)!=0){
                counter ++;
            }
        }
        fuzzines *= (double) counter/(double) secondTypeSummary.ValuesForQualifier.size();
        return fuzzines;
    }
}
