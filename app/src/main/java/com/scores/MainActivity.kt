package com.scores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private  val keyIndex = "index"
    private var scoreValues = arrayListOf(0,0)
    private lateinit var teamAScore : TextView
    private lateinit var teamBScore : TextView
    private lateinit var teamAPl3 : Button
    private lateinit var teamBPl3 : Button
    private lateinit var teamAPl2 : Button
    private lateinit var teamBPl2 : Button
    private lateinit var teamAPl1 : Button
    private lateinit var teamBPl1 : Button
    private lateinit var resetScores : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        teamAScore.text = scoreValues[0].toString()
        teamBScore.text = scoreValues[1].toString()
        teamAPl1.setOnClickListener {
            scoreValues[0] = add1(scoreValues[0])
            teamAScore.text = scoreValues[0].toString()
        }
        teamAPl2.setOnClickListener {
            scoreValues[0] = add2(scoreValues[0])
            teamAScore.text = scoreValues[0].toString()
        }
        teamAPl3.setOnClickListener {
            scoreValues[0] = add3(scoreValues[0])
            teamAScore.text = scoreValues[0].toString()
        }

        teamBPl1.setOnClickListener {
            scoreValues[1] = add1(scoreValues[1])
            teamBScore.text = scoreValues[1].toString()
        }
        teamBPl2.setOnClickListener {
            scoreValues[1] = add2(scoreValues[1])
            teamBScore.text = scoreValues[1].toString()
        }
        teamBPl3.setOnClickListener {
            scoreValues[1] = add3(scoreValues[1])
            teamBScore.text = scoreValues[1].toString()
        }
        resetScores.setOnClickListener {
            resetScore()

        }



    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreValues = savedInstanceState.getIntegerArrayList(keyIndex)!!
        if (scoreValues.isNotEmpty()){
            updateScores(scoreValues)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (scoreValues.isNotEmpty()) outState.putIntegerArrayList(keyIndex,scoreValues)
        super.onSaveInstanceState(outState)
    }


    private fun init() {
        teamAScore = findViewById(R.id.scoreA)
        teamBScore = findViewById(R.id.scoreB)
        teamBPl1   = findViewById(R.id.addB1)
        teamBPl2   = findViewById(R.id.addB2)
        teamBPl3   = findViewById(R.id.addB3)
        teamAPl1   = findViewById(R.id.addA1)
        teamAPl2   = findViewById(R.id.addA2)
        teamAPl3   = findViewById(R.id.addA3)
        resetScores = findViewById(R.id.reset)
    }
    private fun updateScores(values: ArrayList<Int>){
        teamAScore.text = values[0].toString()
        teamBScore.text = values[1].toString()
    }


    private fun add3 (score : Int) : Int{

        return  score +3
    }
    private fun add2 (score : Int) : Int{

        return  score +2
    }
    private fun add1 (score : Int) : Int{

        return  score +1
    }

    private fun resetScore(){
        scoreValues[0] = 0
        scoreValues[1] = 0
        updateScores(scoreValues)
    }

}