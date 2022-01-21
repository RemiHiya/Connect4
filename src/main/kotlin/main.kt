fun main(args: Array<String>) {

    val playerNum = 2
    val row = 6
    val column = 7

    val board = Board(row, column, playerNum)
    board.addPiece(2, "O")
    board.addPiece(2, "R")

    System.out.println(board.boardToString("|"))
}