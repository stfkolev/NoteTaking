package com.example.notetaking

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person (
    var name:       String,
    var age:        Int,
    var address:    String,
    var city:       String
) : Parcelable