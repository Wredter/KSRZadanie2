package KSRZadanie2.Model;

import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import java.util.List;

public class Quality {
    public FirstTypeSummary summaryType1;
    public SecondTypeSummary summaryType2;
    public List<Double> qualities;

    public Quality(FirstTypeSummary summary, List<Double> qualityVector) {
        summaryType1 = summary;
        qualities = qualityVector;
    }

    public Quality(SecondTypeSummary summary, List<Double> qualityVector) {
        summaryType2 = summary;
        qualities = qualityVector;
    }
}
