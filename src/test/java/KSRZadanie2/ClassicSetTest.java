package KSRZadanie2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import KSRZadanie2.Collection.ClassicSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ClassicSetTest {

    @Test
    public void ClassicSetUnionMethodTest() {
        ArrayList<Double> t1 = new ArrayList<>();
        t1.add(1.0);
        t1.add(2.0);
        t1.add(3.0);
        ArrayList<Double> t2 = new ArrayList<>();
        t2.add(1.0);
        t2.add(4.0);
        t2.add(5.0);
        ArrayList<Double> t3 = new ArrayList<>();
        t3.add(1.0);
        t3.add(2.0);
        t3.add(3.0);
        t3.add(4.0);
        t3.add(5.0);

        ClassicSet set1 = new ClassicSet(t1);
        ClassicSet set2 = new ClassicSet(t2);
        ClassicSet set3 = set1.Union(set2);

        assertEquals(set3.values, t3);
    }

    @Test
    public void ClassicSetIntersectionMethodTest() {
        ArrayList<Double> t1 = new ArrayList<>();
        t1.add(1.0);
        t1.add(2.0);
        t1.add(3.0);
        ArrayList<Double> t2 = new ArrayList<>();
        t2.add(1.0);
        t2.add(4.0);
        t2.add(5.0);
        ArrayList<Double> t3 = new ArrayList<>();
        t3.add(1.0);

        ClassicSet set1 = new ClassicSet(t1);
        ClassicSet set2 = new ClassicSet(t2);
        ClassicSet set3 = set1.Intersection(set2);

        assertEquals(set3.values, t3);
    }

    @Test
    public void ClassicSetComplementionMethodTest() {
        ArrayList<Double> t1 = new ArrayList<>();
        t1.add(1.0);
        t1.add(2.0);
        t1.add(3.0);
        ArrayList<Double> t2 = new ArrayList<>();
        t2.add(1.0);
        t2.add(4.0);
        t2.add(5.0);
        ArrayList<Double> t3 = new ArrayList<>();
        t3.add(4.0);
        t3.add(5.0);

        ClassicSet set1 = new ClassicSet(t1);
        ClassicSet set2 = new ClassicSet(t2);
        ClassicSet set3 = set1.Complemention(set2);

        assertEquals(set3.values, t3);
    }

    @Test
    public void ClassicSetEqualMethodTest() {
        ArrayList<Double> t1 = new ArrayList<>();
        t1.add(1.0);
        t1.add(2.0);
        t1.add(3.0);
        ArrayList<Double> t2 = new ArrayList<>();
        t2.add(1.0);
        t2.add(2.0);
        t2.add(3.0);

        ClassicSet set1 = new ClassicSet(t1);
        ClassicSet set2 = new ClassicSet(t2);

        assertTrue(set1.Equal(set2));
    }
}
