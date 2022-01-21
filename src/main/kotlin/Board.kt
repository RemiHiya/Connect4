import jdk.nashorn.internal.objects.Global.println

class Board(row: Int, column: Int, players: Int) {

    private val rowNum = row
    private val columnNum = column
    private val playersNum = players

    private val board = Array(columnNum) {
        arrayOfNulls<String>(rowNum)
    }

    private var turn = 0


    fun getColumnSize(col: Int): Int {
        var temp = 0
        for(i in 0..board[col].size-1) {
            if(board[col][i] != null) {
                temp++
            }
        }
        return temp
    }

    fun boardToString(separator: String = "", empty: String = "."): String {
        var s = ""
        for(i in 0..rowNum-1) {
            s += separator
            for(j in 0..columnNum-1) {
                s += if(board[j][rowNum-1-i] != null) {
                    board[j][rowNum-1-i]
                } else {
                    empty
                }
                s += separator
            }
            s += "\n"
        }
        return s
    }

    fun newTurn(): Int {
        turn += 1
        return turn
    }

    fun getPlayer(): Int {
        return turn - playersNum * (turn / playersNum)
    }

    fun addPiece(col: Int, color: String?) {
        if (col <= columnNum) {
            board[col][getColumnSize(col)] = color
        }
    }
}