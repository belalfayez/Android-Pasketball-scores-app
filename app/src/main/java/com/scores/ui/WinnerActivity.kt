package com.scores.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.scores.MainActivity
import com.scores.R
import com.scores.model.WinnerTeam

class WinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        val winnerTeam = intent.getParcelableExtra<WinnerTeam>("WINNER_TEAM")
        val winnerMsg : TextView = findViewById(R.id.winner_team)
        winnerMsg.text = "${winnerTeam?.team} with score ${winnerTeam?.score}"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        returnToMainActivity()
    }

    private fun returnToMainActivity(){
        val intent  = Intent(this,MainActivity::class.java)
        intent.putExtra("RESET_VALUES",true)
        startActivity(intent)
    }
}