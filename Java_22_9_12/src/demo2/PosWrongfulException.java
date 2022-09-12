package demo2;

public class PosWrongfulException extends RuntimeException {
    public PosWrongfulException() {

    }
    public PosWrongfulException(String message) {
        super(message);
    }
}
