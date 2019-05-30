package KSRZadanie2.Collection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class FuzzyCollection<T> implements ICollection<FuzzyCollection>{
    public ArrayList<T> values;

    @Override
    public FuzzyCollection Union(FuzzyCollection collection) {
        return null;
    }

    @Override
    public FuzzyCollection Complement(FuzzyCollection collection) {
        return null;
    }

    @Override
    public FuzzyCollection Intersection(FuzzyCollection collection) {
        return null;
    }

    @Override
    public Boolean Equal(FuzzyCollection collection) {
        return null;
    }
}
