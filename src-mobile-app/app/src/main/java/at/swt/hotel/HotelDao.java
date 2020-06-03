package at.swt.hotel;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface HotelDao {

    @Query("SELECT * FROM hotel")
    List<Hotel> getHotels();

    @Query("SELECT * FROM hotelinterest")
    List<HotelInterest> getHotelInterests();

    @Query("SELECT * FROM hotelpicture")
    List<HotelPicture> getHotelPictures();

    @Query("SELECT * FROM hotelrating")
    List<HotelRating> getHotelratings();

    @Query("SELECT * FROM hotel WHERE id IN (:hotelIds)")
    List<Hotel> loadHotelByIds(int[] hotelIds);

    @Query("SELECT * FROM hotel WHERE id IN (:name)")
    List<Hotel> getHotelByName(String name);

    @Query("DELETE from hotel")
    void deleteAllHotels();

    @Query("DELETE from hotelinterest")
    void deleteAllHotelInterests();

    @Query("DELETE from hotelpicture")
    void deleteAllHotelPictures();

    @Query("DELETE from hotelrating")
    void deleteAllHotelRatings();

    @Insert
    void insertHotels(Hotel... hotels);

    @Insert
    void insertHotelInterests(HotelInterest... interest);

    @Insert
    void insertHotelPictures(HotelPicture... pictures);

    @Insert
    void insertHotelRatings(HotelRating... ratings);

    @Delete
    void deleteHotel(Hotel hotel);

    @Delete
    void deleteHotelInterest(HotelInterest hotel);

    @Delete
    void deleteHotelPicture(HotelPicture picture);

    @Delete
    void deleteHotelRating(HotelRating rating);
}
