package KSRZadanie2.Model.LinguisticVariables;

import KSRZadanie2.Collection.FuzzySet;

public class Qualifier extends LinguisticVariable {
    public String attribute;

    public Qualifier(String label, FuzzySet fuzzySet) {
        super(label, fuzzySet);
    }

    public Qualifier(String label, FuzzySet fuzzySet, String attr) {
        super(label, fuzzySet);

        attribute = attr;
    }
}
