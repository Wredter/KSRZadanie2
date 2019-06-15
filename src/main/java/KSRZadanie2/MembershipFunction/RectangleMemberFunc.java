package KSRZadanie2.MembershipFunction;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RectangleMemberFunc implements IMemberFunc, Serializable {
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

    @Override
    public Double GetHeight() {
        return this.height;
    }

    @Override
    public String ToString() {
        return "Prostokątna";
    }

    @Override
    public Double SuppNiepoliczalny() {
        Double przedziałwartości = Math.abs(a-b);
        return przedziałwartości;
    }

    @Override
    public Double clmNiepoliczalny() {
        Double pole;
        pole = ((Math.abs(a-b)+Math.abs(d-c))*height)/2.0;
        return pole;
    }
}
