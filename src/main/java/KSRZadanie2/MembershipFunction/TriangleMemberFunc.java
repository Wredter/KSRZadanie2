package KSRZadanie2.MembershipFunction;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TriangleMemberFunc implements IMemberFunc {
    //  c
    // a b
    Double a;
    Double b;
    Double c;

    @Builder.Default
    Double height = 1.0;

    @Override
    public Double Result(Double x) {
        if (x < a || x > b) return 0.0;
        if (x > a && x < c) return (x - a) / (c - a);
        if (x > c && x < b) return (b - x) / (b - c);
        if (Math.abs(x) == b) return 1.0;
        return 0.0;
    }

    @Override
    public Double GetHeight() {
        return this.height;
    }

    @Override
    public String ToString() {
        return "Trójkątna";
    }

    @Override
    public Double SuppNiepoliczalny() {
        return Math.abs(a - b);
    }

    @Override
    public Double clmNiepoliczalny() {
        Double pole;
        pole = (Math.abs(a - b) * height) / 2.0;
        return pole;
    }
}
