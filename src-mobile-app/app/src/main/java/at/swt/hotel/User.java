package at.swt.hotel;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    public User(
            final int    id,
            final String name,
            final String email,
            final byte[] password_hash,
            final byte[] seed
    ) {
        this.id            = id;
        this.name          = name;
        this.email         = email;
        this.password_hash = password_hash;
        this.seed          = seed;
    }

    public User(){}

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "password_hash")
    public byte[] password_hash;

    @ColumnInfo(name = "seed")
    public byte[] seed;
}

