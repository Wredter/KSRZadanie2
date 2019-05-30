package KSRZadanie2.Collection;

import KSRZadanie2.MembershipFunction.IMemberFunc;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FuzzyCollection implements ICollection {
    public IMemberFunc memberFunc;

    public Double MemberFuncResult(Double x) {
        return memberFunc.Result(x);
    }

    public FuzzyCollection Union(FuzzyCollection collection, Double x) {
        return null;
    }

    public FuzzyCollection Complement(FuzzyCollection collection, Double x) {
        return null;
    }

    public FuzzyCollection Intersection(FuzzyCollection collection, Double x) {
        return null;
    }

    public Boolean Equal(FuzzyCollection collection, Double x) {
        return null;
    }
}
