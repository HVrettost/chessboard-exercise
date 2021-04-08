package xm.chessboard.validator;

public class TimesToIterateValidator implements Validator<Integer> {

    @Override
    public boolean isValid(Integer timesToIterate) {
        return timesToIterate > 1 && timesToIterate < 10;
    }
}
