package KSRZadanie2.MembershipFunction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TriangleMemberFunc implements IMemberFunc<Double> {
    //  b
    // a c
    Double a;
    Double b;
    Double c;
    @Builder.Default
    public Double height = 1.0;

    @Override
    public Double Result(Double x) {
        if (x < a || x > c) return 0.0;
        if (x > a && x < b) return (x - a) / (b - a);
        if (x > b && x < c) return (c - x) / (c - b);
        if(Math.abs(x) == c) return 1.0;
        return 0.0;
    }
}
