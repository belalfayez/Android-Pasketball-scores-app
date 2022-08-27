package com.scores.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class WinnerTeam(val team:String?,val score:Int) : Parcelable