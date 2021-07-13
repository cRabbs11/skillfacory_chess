public class King extends ChessPiece {

    public King(String color) {
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

        return isKingMove(line, column, toLine, toColumn) &&
                !isUnderAttack(chessBoard, line, column) &&
                isCanEating(chessBoard, toLine, toColumn);
    }

    private boolean isKingMove(int line, int column, int toLine, int toColumn) {
        return  (Math.abs(line-toLine)==1 || Math.abs(column-toColumn)==1);
    }

    @Override
    String getSymbol() {
        return "K";
    }

    @Override
    protected boolean isCollisionOnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int l = 0; l < 7; l++) {
            for (int c = 0; c < 7; c++) {
                 if (chessBoard.board[l][c]!=null && !chessBoard.nowPlayer.equals(getColor())) {
                    if (chessBoard.board[l][c].canMoveToPosition(chessBoard, l, c, line, column)) return true;
                 }
            }
        }

        return false;
    }
}
