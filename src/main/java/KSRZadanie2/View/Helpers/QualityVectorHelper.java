package KSRZadanie2.View.Helpers;

import KSRZadanie2.Quality.*;

public class QualityVectorHelper {
    public DegreeOfTruth T1;
    public DegreeOfPrecision T2;
    public DegreeOfCovering T3;
    public DegreeOfAppropriatness T4;
    public LengthOfSummary T5;
    public QuantifierPrecision T6;
    public DegreeOfQuantifierCardinality T7;
    public DegreeOfSummarizerCardinality T8;
    public DegreeOfQualifierPrecision T9;
    public DegreeOfQuantifierCardinality T10;
    public LengthOfQualifier T11;

    public QualityVectorHelper() {
        T1 = new DegreeOfTruth();
        T2 = new DegreeOfPrecision();
        T3 = new DegreeOfCovering();
        T4 = new DegreeOfAppropriatness();
        T5 = new LengthOfSummary();
        T6 = new QuantifierPrecision();
        T7 = new DegreeOfQuantifierCardinality();
        T8 = new DegreeOfSummarizerCardinality();
        T9 = new DegreeOfQualifierPrecision();
        T10 = new DegreeOfQuantifierCardinality();
        T11 = new LengthOfQualifier();
    }
}
