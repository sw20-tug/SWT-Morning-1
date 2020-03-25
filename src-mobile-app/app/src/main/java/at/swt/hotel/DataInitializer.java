package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class DataInitializer extends AppCompatActivity {

    /* The name of the data base. */
    public static final String DB_NAME = "Hotel_db";

    public AppDatabase init() {
        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                DB_NAME).build();

        //TODO: fill database like this
        //db.userDao().insertAll();

        return db;
    }

    private void initBasicData() {

        User userOne = new User();
        userOne.name = "Mimi";
        userOne.email = "mimi@one.pro";

        Rating ratingHotel1 = new Rating();
        ratingHotel1.comment = "Moderne Ausstattung, sehr gute Lage, tolles Design. Nicht gefallen · Der Trend zu Badezimmern mit Glaswänden und halbdurchsichtigen Vorhängen ist für Pärchen ggf. ganz nett. Für alle anderen kann es schnell auch unangenehm werden.";
        ratingHotel1.rating = 7;
        ratingHotel1.user = userOne;


        Hotel firstHotel = new Hotel();
        firstHotel.name = "Arte-Salzburg";
        firstHotel.description = "Direkt beim Bahnhof und nur 10 Minuten vom Zentrum entfernt liegt unser neues arte Hotel Salzburg, das im Frühling 2019 eröffnet wurde. Das Gebäude ist ein beeindruckender Hochbau aus Stahl, Beton und Glas und bietet einen atemberaubenden Blick auf die Altstadt und das Umland. Besonders das Frühstück im 15. Stock und ein Drink abends von der Rooftop-Bar „hu:goes14“ mit Dachterrasse im 16. Stock werden einen einzigartigen Eindruck hinterlassen";
        firstHotel.price = "270";
        firstHotel.category = "Romantisch";
        firstHotel.location = "Salzburg Rainerstraße 28 5020 Salzburg Österreich";
        firstHotel.stars = 4;
        firstHotel.ratings.add(ratingHotel1);



    }
}
