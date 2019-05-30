package KSRZadanie2.Collection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class ClassicCollection implements ICollection {
    public ArrayList<Double> values;

    public ClassicCollection Union(ClassicCollection collection) {
        return null;
    }

    public ClassicCollection Complement(ClassicCollection collection) {
        return null;
    }

    public ClassicCollection Intersection(ClassicCollection collection) {
        return null;
    }

    public Boolean Equal(ClassicCollection collection) {
        return null;
    }
}
