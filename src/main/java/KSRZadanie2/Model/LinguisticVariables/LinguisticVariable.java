package KSRZadanie2.Model.LinguisticVariables;

import KSRZadanie2.MembershipFunction.IMemberFunc;

import java.util.ArrayList;

//I hope it will help, but it also can be useless
//Based on prof.Niewiadomski lecture
public abstract class LinguisticVariable {
    String name;
    ArrayList<String> labelsCollection;
    Double minValue;
    Double maxValue;
    IMemberFunc membershipFunction;

    public abstract String LabelForValue(Double value);

}
