package com.hmncube.template.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hmncube.template.data.local.daos.PostDao
import com.hmncube.template.data.local.entities.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}