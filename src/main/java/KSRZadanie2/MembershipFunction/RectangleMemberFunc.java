package KSRZadanie2.MembershipFunction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RectangleMemberFunc implements IMemberFunc<Double> {
    //  d c
    // a   b
    Double a;
    Double b;
    Double c;
    Double d;
    @Builder.Default
    Double height = 1.0;

    @Override
    public Double Result(Double x) {
        if (x >= d && x <= c) return 1.0;
        if (x > a && x < d) return (x - a) / (d - a);
        if (x > c && x < b) return (b - x) / (b - c);
        return 0.0;
    }
}
