package com.example.tictactoets

fun isWin(): Boolean {
    val field = Array(3) {
        arrayOfNulls<String>(
            3
        )
    }
    for (i in 0..2) {
        for (j in 0..2) {
            field[i][j] = buttons[i][j]!!.text.toString()
        }
    }
    for (i in 0..2) {
        if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != "") {
            return true
        }
    }
    for (i in 0..2) {
        if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != "") {
            return true
        }
    }
    if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != "") {
        return true
    }
    return if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] != "") {
        true
    } else false
}