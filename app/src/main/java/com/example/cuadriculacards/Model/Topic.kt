package com.example.cuadriculacards.Model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val modelVersion: Int,
    @DrawableRes val imageResourceId: Int
)
