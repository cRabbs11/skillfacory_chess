public class Pawn extends ChessPiece {

    public Pawn(String color) {
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

        return isPawnMove(chessBoard, line, column, toLine, toColumn) &&
                !isCollisionOnMove(chessBoard, line, column, toLine, toColumn);
    }

    private boolean isPawnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[line][column].color.equals("White")) {
            if (column==toColumn) {
                if (toLine-line==1) {
                    return true;
                } else if (toLine-line==2 && isFirstMove(line)) {
                    return true;
                } else {
                    return false;
                }
            } else if (toLine-line==1 &&
                    Math.abs(column-toColumn)==1 &&
                    chessBoard.board[toLine][toColumn]!=null &&
                    isCanEating(chessBoard, toLine, toColumn)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (column==toColumn) {
                if (toLine-line==-1) {
                    return true;
                } else if (toLine-line==-2 && isFirstMove(line)) {
                    return true;
                } else {
                    return false;
                }
            } else if (toLine-line==-1 &&
                    Math.abs(column-toColumn)==1 &&
                    chessBoard.board[toLine][toColumn]!=null &&
                    isCanEating(chessBoard, toLine, toColumn)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    protected boolean isCanEating(ChessBoard chessBoard, int toLine, int toColumn) {
        if (!chessBoard.board[toLine][toColumn].color.equals(chessBoard.nowPlayer)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFirstMove(int line) {
        if (color.equals("White") && line==1) return true;

        return (color.equals("Black") && line==6);
    }

    @Override
    String getSymbol() {
        return "P";
    }

    @Override
    protected boolean isCollisionOnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.nowPlayer.equals("White")) {
            for (int i=line; i<toLine-1; i++) {
                if (chessBoard.board[i][column]!=null) return true;
            }
        } else {
            for (int i=toLine-1; i<line; i++) {
                if (chessBoard.board[i][column]!=null) return true;
            }
        }

        return false;
    }
}
