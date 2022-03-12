package com.example.tictactoets

import android.widget.Toast
import com.google.android.material.internal.ContextUtils.getActivity


fun playerPoints() {
    Player1Txt!!.text = "Player 1: $Player1Rounds"
    Player2Txt!!.text = "Player 2: $Player2Rounds"
}

fun resetScore() {
    for (i in 0..2) {
        for (j in 0..2) {
            buttons[i][j]!!.text = ""
        }
    }
    winCount = 0
    player1Turn = true
}