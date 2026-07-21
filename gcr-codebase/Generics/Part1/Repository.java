import java.util.ArrayList;
import java.util.List;

public class Repository<T> {

    private List<T> records;

    public Repository() {
        records = new ArrayList<>();
    }

    public void add(T value) {
        records.add(value);
    }

    public T get(int index) {
        return records.get(index);
    }

    public List<T> getAll() {
        return records;
    }
}