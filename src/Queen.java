public class Queen extends ChessPiece {

    public Queen(String color) {
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

        return isQueenMove(line, column, toLine, toColumn) &&
                !isCollisionOnMove(chessBoard, line, column, toLine, toColumn) &&
                isCanEating(chessBoard, toLine, toColumn);
    }

    private boolean isQueenMove(int line, int column, int toLine, int toColumn) {
        if (line==toLine || column==toColumn) return true;

        if (Math.abs(toLine)==Math.abs(toColumn)) return true;

        return false;
    }

    @Override
    String getSymbol() {
        return "Q";
    }

    @Override
    protected boolean isCollisionOnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column==toColumn || line==toLine) { //движение по прямой
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
        } else { //движение по диагонали
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
        }
        return false;
    }
}
