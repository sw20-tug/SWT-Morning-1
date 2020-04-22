package at.swt.hotel;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user where name IN (:name)")
    List<User> getByName(String name);

    @Query("DELETE from user")
    void deleteAll();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}

