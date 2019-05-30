package KSRZadanie2.Collection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class ClassicSet implements ISet {
    public ArrayList<Double> values;

    public ClassicSet Union(ClassicSet set) {
        ArrayList<Double> result = this.values;

        for (Double val : set.values) {
            if (!this.values.contains(val)) {
                result.add(val);
            }
        }
        return new ClassicSet(result);
    }

    public ClassicSet Intersection(ClassicSet set) {
        ArrayList<Double> result = new ArrayList<>();

        for (Double val : set.values) {
            if (this.values.contains(val)) {
                result.add(val);
            }
        }
        return new ClassicSet(result);
    }

    public ClassicSet Complemention(ClassicSet set) {
        ArrayList<Double> result = new ArrayList<>();

        for (Double val : set.values) {
            if (!this.values.contains(val)) {
                result.add(val);
            }
        }
        return new ClassicSet(result);
    }

    public Boolean Equal(ClassicSet set) {
        return set.values.containsAll(this.values);
        //return this.values.containsAll(set.values);
    }
}
