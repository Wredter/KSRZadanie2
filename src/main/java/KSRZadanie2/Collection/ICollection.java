package KSRZadanie2.Collection;

public interface ICollection<T> {
    public T Union(T collection);
    public T Complement(T collection);
    public T Intersection(T collection);
    public Boolean Equal(T collection);
}
