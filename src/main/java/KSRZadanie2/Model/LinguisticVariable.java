package KSRZadanie2.Model;

import java.util.ArrayList;

//I hope it will help, but it also can be useless
//Based on prof.Niewiadomski lecture
public abstract class LinguisticVariable {
    String name;
    ArrayList<String> labelsCollection;
    String reflectionSpace;

    public abstract String LabelForValue(Double value);

}
