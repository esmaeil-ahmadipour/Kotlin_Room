package ir.sample.kotlinroom.roomLayer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.sample.kotlinroom.roomLayer.dataAccessObjects.UserDao
import ir.sample.kotlinroom.roomLayer.entities.UserEntity

//Setting & Configuration Database ;
@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun user():UserDao
    companion object{
        private var instance : AppDatabase? = null

        public val DB_NAME = "basic_room"

        fun getInstance(context : Context) : AppDatabase{
           if(instance == null){
               instance= Room.databaseBuilder(context,AppDatabase::class.java,DB_NAME)
                   .allowMainThreadQueries()
                   .fallbackToDestructiveMigration()
                   .build()
           }
            return instance!!
        }
    }



}