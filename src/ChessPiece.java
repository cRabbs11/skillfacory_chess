abstract public class ChessPiece {

    protected String color;

    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract String getColor();

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract String getSymbol();

    abstract protected boolean isCollisionOnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    boolean isMoveOnSamePosition(int line, int column, int toLine, int toColumn) {
        return (line==toLine && column==toColumn);
    }

    boolean isMoveOffTheBoard(int line, int column, int toLine, int toColumn) {
        return (toLine<0 || toLine>7 || toColumn<0 || toColumn>7);
    }

    protected boolean isCanEating(ChessBoard chessBoard, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn]==null) {
            return true;
        } else {
            if (!chessBoard.board[toLine][toColumn].color.equals(chessBoard.nowPlayer)) {
                return true;
            } else {
                return false;
            }
        }
    }

}
