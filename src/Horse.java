public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isMoveOffTheBoard(line, column, toLine, toColumn)) return false;

        if (isMoveOnSamePosition(line, column, toLine, toColumn)) return false;

        return canHorseMove(line, column, toLine, toColumn) && isCanEating(chessBoard, toLine, toColumn);
    }

    private boolean canHorseMove(int line, int column, int toLine, int toColumn) {
        if (Math.abs(line-toLine)==2 && Math.abs(column-toColumn)==1) {
            return true;
        } else if (Math.abs(line-toLine)==1 && Math.abs(column-toColumn)==2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    String getSymbol() {
        return "H";
    }

    @Override
    protected boolean isCollisionOnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }
}
