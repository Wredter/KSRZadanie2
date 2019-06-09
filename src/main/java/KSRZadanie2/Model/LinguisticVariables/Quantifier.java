package KSRZadanie2.Model.LinguisticVariables;

import KSRZadanie2.Collection.FuzzySet;

public class Quantifier extends LinguisticVariable {
    public String attribute;

    public Quantifier(String label, FuzzySet fuzzySet) {
        super(label, fuzzySet);
    }
    public Quantifier(String label, FuzzySet fuzzySet, String attr) {
        super(label, fuzzySet);
        attribute = attr;
    }
}
