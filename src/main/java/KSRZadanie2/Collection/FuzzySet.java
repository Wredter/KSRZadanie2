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

    public Double Union(FuzzySet set, Double x) {
        return Math.max(set.MemberFuncResult(x), this.MemberFuncResult(x));
    }

    public Double Complement(FuzzySet set, Double x) {
        return Math.min(set.MemberFuncResult(x), this.MemberFuncResult(x));
    }

    public Double Intersection(Double x) {
        return (this.memberFunc.GetHeight() - this.MemberFuncResult(x));
    }

    public Double Difference(FuzzySet set, Double x) {
        return Math.min(set.Intersection(x), this.MemberFuncResult(x));
    }

    public Boolean Equal(FuzzySet set, Double x) {
        return this.MemberFuncResult(x).equals(set.MemberFuncResult(x));
    }
}
