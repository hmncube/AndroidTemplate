package com.hmncube.template.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val body: String
)
