package demo;

public class List {
    private int value;
    private List next;


    public List(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public List getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(List next) {
        this.next = next;
    }



    @Override
    public String toString() {
        return "List{" +
                "value=" + value +
                ", list=" + next +
                '}';
    }
}
