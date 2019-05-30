package KSRZadanie2.Collection;

import KSRZadanie2.MembershipFunction.IMemberFunc;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FuzzySet implements ISet {
    public IMemberFunc memberFunc;

    public Double MemberFuncResult(Double x) {
        return memberFunc.Result(x);
    }

    public FuzzySet Union(FuzzySet collection, Double x) {
        return null;
    }

    public FuzzySet Complement(FuzzySet collection, Double x) {
        return null;
    }

    public FuzzySet Intersection(FuzzySet collection, Double x) {
        return null;
    }

    public Boolean Equal(FuzzySet collection, Double x) {
        return null;
    }
}
