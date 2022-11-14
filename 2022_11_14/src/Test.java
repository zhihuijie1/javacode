import java.util.Objects;
class person {
    int id;

    public person(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class Test {
    public static void main(String[] args) {
        HashBuck2<person,Integer> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(new person(1),11);
        hashBuck2.put(new person(1),11);
        hashBuck2.put(new person(3),11);
        hashBuck2.put(new person(5),11);
        hashBuck2.put(new person(8),11);
        hashBuck2.put(new person(10),11);
        hashBuck2.put(new person(16),11);
    }
}
