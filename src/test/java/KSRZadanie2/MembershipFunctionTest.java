package KSRZadanie2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import KSRZadanie2.MembershipFunction.RectangleMemberFunc;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import org.junit.Test;

public class MembershipFunctionTest {
    @Test
    public void triangleResultMethodTest()
    {
        TriangleMemberFunc triangleMemberFunc = new TriangleMemberFunc(1.00, 10.00, 5.0, 5.0);
        Double result = triangleMemberFunc.Result(3.00);
        assertEquals( (Double) 0.5, result );
    }

    @Test
    public void rectangleResultMethodTest()
    {
        RectangleMemberFunc rectangleMemberFunc = new RectangleMemberFunc(1.00, 7.00, 5.00, 3.00, 5.0);
        Double result = rectangleMemberFunc.Result(4.00);
        assertEquals( (Double) 1.0, result );
    }
}
