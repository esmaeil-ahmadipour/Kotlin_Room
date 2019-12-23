package ir.sample.kotlinroom.roomLayer.dataAccessObjects

import androidx.room.*
import ir.sample.kotlinroom.roomLayer.entities.UserEntity

@Dao
interface UserDao {
    @Query("select * from users")
    fun getAll(): List<UserEntity>

    @Insert
    fun insert(user: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("delete from users")
    fun deleteAll()
}