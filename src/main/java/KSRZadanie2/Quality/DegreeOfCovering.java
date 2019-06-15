package KSRZadanie2.Quality;

import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

public class DegreeOfCovering implements IDegree {
    @Override
    public Double Calc(FirstTypeSummary firstTypeSummary) {
        return null;
    }

    @Override
    public Double Calc(SecondTypeSummary secondTypeSummary) {
        int ti =0;
        int hi =0;
        int size;
        if (secondTypeSummary.ValuesForSummarizer1.size() >= secondTypeSummary.ValuesForSummarizer2.size()) {
            size = secondTypeSummary.ValuesForSummarizer2.size();
        } else {
            size = secondTypeSummary.ValuesForSummarizer1.size();
        }
        if(secondTypeSummary.Operation.equals("NONE")) {
            for (int i = 0; i < secondTypeSummary.ValuesForSummarizer1.size(); i++) {
                if(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer1.get(i))!= 0 && secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i))!=0){
                    ti++;
                }if(secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i))!=0){
                    hi++;
                }
            }
            return (double) ti / (double) hi;
        }else if(secondTypeSummary.Operation.equals("AND")){

            for (int i = 0; i < size; i++) {
                if(Math.min(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer1.get(i)),secondTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer2.get(i)))!= 0 && secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i))!=0){
                    ti++;
                }if(secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i))!=0){
                    hi++;
                }
            }
            return (double) ti / (double) hi;
        }else if(secondTypeSummary.Operation.equals("OR")){
            for (int i = 0; i < size; i++) {
                if(Math.max(secondTypeSummary.Summarizer1.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer1.get(i)),secondTypeSummary.Summarizer2.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForSummarizer2.get(i)))!= 0 && secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i))!=0){
                    ti++;
                }if(secondTypeSummary.Qualifier.fuzzySet.MemberFuncResult(secondTypeSummary.ValuesForQualifier.get(i))!=0){
                    hi++;
                }
            }
            return (double) ti / (double) hi;
        }else {
            return null;
        }
    }
}
