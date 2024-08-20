package com.hmncube.template.di


import android.content.Context
import androidx.room.Room
import com.hmncube.template.data.local.PostsDatabase
import com.hmncube.template.data.local.daos.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun providePostDao(postsDatabase: PostsDatabase): PostDao {
        return postsDatabase.postDao()
    }

    @Provides
    @Singleton
    fun providePostDatabase(@ApplicationContext context: Context): PostsDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = PostsDatabase::class.java,
            name = "posts_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}