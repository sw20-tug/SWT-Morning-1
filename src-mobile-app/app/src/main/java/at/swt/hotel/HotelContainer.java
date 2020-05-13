package at.swt.hotel;

import java.util.List;

public class HotelContainer{
    public HotelContainer(Hotel hotel, List<HotelPicture> hotelpictures, List<HotelInterest> hotelinterest) {
        this.hotel = hotel;
        this.hotelpictures = hotelpictures;
        this.hotelinterest = hotelinterest;
    }

    public Hotel hotel;
    public List<HotelPicture> hotelpictures;
    public List<HotelInterest> hotelinterest;


}
