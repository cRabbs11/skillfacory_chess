public class Rook extends ChessPiece {

    public Rook(String color) {
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

        return isRookMove(line, column, toLine, toColumn) &&
                !isCollisionOnMove(chessBoard, line, column, toLine, toColumn) &&
                isCanEating(chessBoard, toLine, toColumn);
    }

    private boolean isRookMove(int line, int column, int toLine, int toColumn) {
        return (line==toLine || column==toColumn);
    }

    @Override
    String getSymbol() {
        return "R";
    }

    @Override
    protected boolean isCollisionOnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column==toColumn) { //двигается по вертикали
            if (line<toLine) {
                for (int i = line+1; i<=toLine-1; i++) {
                    if (chessBoard.board[i][column]!=null) return true;
                }
            } else {
                for (int i = line-1; i>=toLine+1; i--) {
                    if (chessBoard.board[i][column]!=null) return true;
                }
            }
        } else { //двигается по горизонтали
            if (column<toColumn) {
                for (int i = column + 1; i<=toColumn-1; i++) {
                    if (chessBoard.board[line][i]!=null) return true;
                }
            } else {
                for (int i = column - 1; i>=toColumn+1; i--) {
                    if (chessBoard.board[line][i]!=null) return true;
                }
            }
        }
        return false;
    }
}
