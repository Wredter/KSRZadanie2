package KSRZadanie2.Model.LinguisticVariables;

import KSRZadanie2.Collection.FuzzySet;

import java.io.Serializable;

public class Quantifier extends LinguisticVariable implements Serializable {
    public String attribute;
    public Boolean isBezwzgl;

    public Quantifier(String label, FuzzySet fuzzySet) {
        super(label, fuzzySet);
    }

    public Quantifier(String label, Boolean isBezwzgledny, FuzzySet fuzzySet, String attr) {
        super(label, fuzzySet);
        attribute = attr;
        isBezwzgl = isBezwzgledny;
    }

    public Quantifier(String label, FuzzySet fuzzySet, String attr) {
        super(label, fuzzySet);
        attribute = attr;
        isBezwzgl = false;
    }
}
