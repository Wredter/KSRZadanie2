package KSRZadanie2.Model.LinguisticVariables;

import KSRZadanie2.Collection.FuzzySet;

import java.io.Serializable;

public class Summarizer extends LinguisticVariable implements Serializable {
    public String attribute;

    public Summarizer(String label, FuzzySet fuzzySet) {
        super(label, fuzzySet);
    }

    public Summarizer(String label, FuzzySet fuzzySet, String attr) {
        super(label, fuzzySet);
        attribute = attr;
    }
}
