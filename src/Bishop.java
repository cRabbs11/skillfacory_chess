public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        return isBishopMove(line, column, toLine, toColumn) &&
                !isCollisionOnMove(chessBoard, line, column, toLine, toColumn) &&
                isCanEating(chessBoard, toLine, toColumn);
    }

    private boolean isBishopMove(int line, int column, int toLine, int toColumn) {
        return (Math.abs(line-toLine)==Math.abs(column-toColumn));
    }

    @Override
    String getSymbol() {
        return "B";
    }

    @Override
    protected boolean isCollisionOnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int c = column;
        if (line<toLine && column<toColumn) { //вверх вправо
            for (int l=line+1; l<=toLine-1; l++) {
                c++;
                if (chessBoard.board[l][c]!=null) {
                    return true;
                }
            }
        } else if (line<toLine && column>toColumn) { //вверх влево
            for (int l=line+1; l<=toLine-1; l++) {
                c--;
                if (chessBoard.board[l][c]!=null) {
                    return true;
                }
            }
        } else if (line>toLine && column<toColumn) { //вниз вправо
            for (int l=line-1; l>=toLine+1; l--) {
                c++;
                if (chessBoard.board[l][c]!=null) {
                    return true;
                }
            }
        } else if (line>toLine && column>toColumn) { //вниз влево
            for (int l=line-1; l>=toLine+1; l--) {
                c--;
                if (chessBoard.board[l][c]!=null) {
                    return true;
                }
            }
        }
        return false;
    }
}
