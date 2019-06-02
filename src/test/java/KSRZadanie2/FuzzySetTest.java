package KSRZadanie2;

import KSRZadanie2.Collection.FuzzySet;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FuzzySetTest {
    @Test
    public void FuzzySetUnionMethodTest() {
        TriangleMemberFunc f1 = new TriangleMemberFunc(1.0, 10.0, 5.0, 1.0);
        TriangleMemberFunc f2 = new TriangleMemberFunc(2.0, 10.0, 5.0, 1.0);

        FuzzySet set1 = new FuzzySet(f1);
        FuzzySet set2 = new FuzzySet(f2);

        assertEquals(set1.Union(set2, 3.0), (Double) 0.5);
    }

    @Test
    public void FuzzySetUnionTwoMethodTest() {
        TriangleMemberFunc f1 = new TriangleMemberFunc(1.0, 10.0, 5.0, 1.0);

        FuzzySet set1 = new FuzzySet(f1);
        FuzzySet set2 = new FuzzySet(f1);

        assertEquals(set1.Union(set2, 2.0, 3.0), (Double) 0.5);
    }

    @Test
    public void FuzzySetComplementMethodTest() {
        TriangleMemberFunc f1 = new TriangleMemberFunc(1.0, 10.0, 5.0, 1.0);
        TriangleMemberFunc f2 = new TriangleMemberFunc(2.0, 10.0, 5.0, 1.0);

        FuzzySet set1 = new FuzzySet(f1);
        FuzzySet set2 = new FuzzySet(f2);

        assertEquals(set1.Complement(set2, 3.0), (Double) (1.0 / 3.0));
    }

    @Test
    public void FuzzySetComplementTwoMethodTest() {
        TriangleMemberFunc f1 = new TriangleMemberFunc(1.0, 10.0, 5.0, 1.0);

        FuzzySet set1 = new FuzzySet(f1);
        FuzzySet set2 = new FuzzySet(f1);

        assertEquals(set1.Complement(set2, 2.0, 3.0), (Double) 0.25);
    }

    @Test
    public void FuzzySetIntersectionMethodTest() {
        TriangleMemberFunc f1 = new TriangleMemberFunc(1.0, 10.0, 5.0, 1.0);

        FuzzySet set1 = new FuzzySet(f1);

        assertEquals(set1.Intersection(3.0), (Double) 0.5);
    }

    @Test
    public void FuzzySetDifferenceMethodTest() {
        TriangleMemberFunc f1 = new TriangleMemberFunc(1.0, 10.0, 5.0, 1.0);
        TriangleMemberFunc f2 = new TriangleMemberFunc(3.0, 10.0, 5.0, 1.0);

        FuzzySet set1 = new FuzzySet(f1);
        FuzzySet set2 = new FuzzySet(f2);

        assertEquals(set1.Difference(set2, 4.0), (Double) (0.5));
    }

    @Test
    public void FuzzySetEqualMethodTest() {
        TriangleMemberFunc f1 = new TriangleMemberFunc(1.0, 10.0, 5.0, 1.0);

        FuzzySet set1 = new FuzzySet(f1);
        FuzzySet set2 = new FuzzySet(f1);

        assertTrue(set1.Equal(set2, 4.0));
    }
}
