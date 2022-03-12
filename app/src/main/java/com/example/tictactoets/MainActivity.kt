package com.example.tictactoets

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

val buttons = Array(3) {
    arrayOfNulls<Button>(
        3
    )
}

var player1Turn = true
var winCount = 0

var Player1Rounds = 0
var Player2Rounds = 0

var Player1Txt: TextView? = null
var Player2Txt: TextView? = null

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Player1Txt = findViewById(R.id.text_view_p1)
        Player2Txt = findViewById(R.id.text_view_p2)



        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "button_$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                buttons[i][j] = findViewById(resID)
                buttons[i][j]?.setOnClickListener(this)
            }
        }
        val buttonReset: Button = findViewById(R.id.button_reset)
        buttonReset.setOnClickListener { restart() }
    }

    override fun onClick(v: View) {
        if ((v as Button).text.toString() != "") {
            return
        }
        if (player1Turn) {
            v.text = "X"
        } else {
            v.text = "O"
        }
        winCount++
        if (isWin()) {
            if (player1Turn) {
                p1Win()
            } else {
                p2Win()
            }
        } else if (winCount == 9) {
            tie()
        } else {
            player1Turn = !player1Turn
        }
    }

    fun p1Win() {
        Player1Rounds++
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show()
        playerPoints()
        resetScore()
    }

    fun p2Win() {
        Player2Rounds++
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show()
        playerPoints()
        resetScore()
    }

    fun tie() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show()
        resetScore()
    }

}