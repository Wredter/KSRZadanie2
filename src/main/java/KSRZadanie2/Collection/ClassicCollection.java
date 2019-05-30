package KSRZadanie2.Collection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class ClassicCollection<T> implements ICollection<ClassicCollection> {
    public ArrayList<T> values;

    @Override
    public ClassicCollection Union(ClassicCollection collection) {
        return null;
    }

    @Override
    public ClassicCollection Complement(ClassicCollection collection) {
        return null;
    }

    @Override
    public ClassicCollection Intersection(ClassicCollection collection) {
        return null;
    }

    @Override
    public Boolean Equal(ClassicCollection collection) {
        return null;
    }
}
