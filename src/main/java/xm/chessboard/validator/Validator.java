package xm.chessboard.validator;

public interface Validator<T> {

    boolean isValid(T value);
}
