package xm.chessboard.context;

import xm.chessboard.validator.ChessboardPositionValidator;

public class ChessboardContext {

    public ChessboardPositionValidator getChessboardPositionValidator() {
        return new ChessboardPositionValidator();
    }




}
