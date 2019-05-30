package KSRZadanie2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import org.junit.Test;

public class MembershipFunctionTest {
    @Test
    public void triangleResultMethodTest()
    {
        TriangleMemberFunc triangleMemberFunc = new TriangleMemberFunc(1.00, 5.00, 10.0, 5.0);
        Double result = triangleMemberFunc.Result(3.00);
        assertEquals( (Double) 0.5, result );
    }
}
