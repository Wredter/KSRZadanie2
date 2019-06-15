package KSRZadanie2.Collection;

import KSRZadanie2.MembershipFunction.IMemberFunc;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class FuzzySet implements ISet, Serializable {
    public IMemberFunc memberFunc;

    public Double MemberFuncResult(Double x) {
        return memberFunc.Result(x);
    }

    public Double Union(FuzzySet set, Double x) {
        return Math.max(this.MemberFuncResult(x), set.MemberFuncResult(x));
    }

    public Double Union(FuzzySet set, Double x1, Double x2) {
        return Math.max(this.MemberFuncResult(x1), set.MemberFuncResult(x2));
    }

    public Double Complement(FuzzySet set, Double x) {
        return Math.min(this.MemberFuncResult(x), set.MemberFuncResult(x));
    }

    public Double Complement(FuzzySet set, Double x1, Double x2) {
        return Math.min(this.MemberFuncResult(x1), set.MemberFuncResult(x2));
    }

    public Double Intersection(Double x) {
        return (this.memberFunc.GetHeight() - this.MemberFuncResult(x));
    }

    public Double Difference(FuzzySet set, Double x) {
        return Math.min(this.MemberFuncResult(x), set.Intersection(x));
    }

    public Boolean Equal(FuzzySet set, Double x) {
        return this.MemberFuncResult(x).equals(set.MemberFuncResult(x));
    }
}
