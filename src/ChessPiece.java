abstract public class ChessPiece {

    protected String color;
    private boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract String getColor();

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract String getSymbol();

}
