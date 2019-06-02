package KSRZadanie2.Model.LinguisticVariables;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.MembershipFunction.IMemberFunc;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public abstract class LinguisticVariable {
    String label;
    FuzzySet fuzzySet;
}
