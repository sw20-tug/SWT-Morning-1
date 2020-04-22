package at.swt.hotel;

import android.app.Activity;
import android.content.Context;

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
        Rating ratingHotel1 = new Rating();
        ratingHotel1.comment = "Moderne Ausstattung, sehr gute Lage, tolles Design. Nicht gefallen · Der Trend zu Badezimmern mit Glaswänden und halbdurchsichtigen Vorhängen ist für Pärchen ggf. ganz nett. Für alle anderen kann es schnell auch unangenehm werden.";
        ratingHotel1.rating = 7;
        ratingHotel1.user = "Mausi Lugner";

        Rating ratingHotel1_2 = new Rating();
        ratingHotel1_2.comment = "Das Bad mit Glasscheibe ohne Türe. Der Vorhang ist durchsichtig, den kann man sich sparen. Es ist keinerlei Privatsphäre möglich. Außerdem entweicht jeglicher Dampf ins Zimmer, z.b.beim Duschen friert man, Haarspray und Deo verteilt sich im ganzen Zimmer.. Die Abstellfläche ist zu gering...";
        ratingHotel1_2.user = "Sebastian Short";
        ratingHotel1_2.rating = 3;

        Rating ratingHotel1_3 = new Rating();
        ratingHotel1_3.comment = "Das Frühstück war reichhaltig und gut.\n" +
                "Personal immer freundlich und hilfsbereit\n" +
                "Gute Lage zum ÖPNV.\n" +
                "\n" +
                "Nicht gefallen · Zimmer nur durch Klimaanlage belüftet,\n" +
                "Keine separate Klimatisierung von Zimmer und Bad.\n" +
                "Terrasse in der 16. Etage leider geschlossen";
        ratingHotel1_3.user = "Mimi";
        ratingHotel1_3.rating = 8;

        HotelActivity activityHotel1_1 = new HotelActivity();
        activityHotel1_1.type = "Fitnesscenter";
        activityHotel1_1.description = "Fitnesscenter";

        HotelActivity activityHotel1_2 = new HotelActivity();
        activityHotel1_2.type = "Spa und Wellnesscenter";
        activityHotel1_2.description = "Spa und Wellnesscenter";

        HotelActivity activityHotel1_3 = new HotelActivity();
        activityHotel1_3.type = "Bibliothek";
        activityHotel1_3.description = "Bibliothek";

        HotelActivity activityHotel1_4 = new HotelActivity();
        activityHotel1_4.type = "Kino";
        activityHotel1_4.description = "Kino";

        Hotel firstHotel = new Hotel();
        firstHotel.name = "Arte-Salzburg";
        firstHotel.description = "Direkt beim Bahnhof und nur 10 Minuten vom Zentrum entfernt liegt unser neues arte Hotel Salzburg, das im Frühling 2019 eröffnet wurde. " +
                "Das Gebäude ist ein beeindruckender Hochbau aus Stahl, Beton und Glas und bietet einen atemberaubenden Blick auf die Altstadt und das Umland. Besonders das Frühstück im 15. " +
                "Stock und ein Drink abends von der Rooftop-Bar „hu:goes14“ mit Dachterrasse im 16. Stock werden einen einzigartigen Eindruck hinterlassen";
        firstHotel.price = "270";
        firstHotel.category = "Romantisch";
        firstHotel.location = "Salzburg Rainerstraße 28 5020 Salzburg Österreich";
        firstHotel.stars = 4;
        firstHotel.ratings.add(ratingHotel1);
        firstHotel.ratings.add(ratingHotel1_2);
        firstHotel.ratings.add(ratingHotel1_3);
        firstHotel.activities.add(activityHotel1_1);
        firstHotel.activities.add(activityHotel1_2);
        firstHotel.activities.add(activityHotel1_3);
        firstHotel.activities.add(activityHotel1_4);

        Rating ratingHotel2 = new Rating();
        ratingHotel2.comment = "+Betreiber super nett, Aussicht war trotz Regen super, ein tolles Erlebnis.\n" +
                "-Ein Heizstrahler bei kalten Temperaturen ist etwas zu wenig.";
        ratingHotel2.rating = 9;
        ratingHotel2.user = "Pamela";

        Rating ratingHotel2_1 = new Rating();
        ratingHotel2_1.comment = "Ein super Erlebnis!! War alles Spitze. Ein großes Lob an das gesamte Bubbletent Team! Toller Service, super freundlich und sehr sehr sauber!";
        ratingHotel2_1.rating = 10;
        ratingHotel2_1.user = "IOI";

        Rating ratingHotel2_2 = new Rating();
        ratingHotel2_2.comment = "Super alternative zu einem langweiligen Hotel. Diese Unterkunft hat alles zu bieten, was man braucht. Champing der Extraklasse.\n" +
                "Sternenhimmel inklusive, eine tolle Lage mit Aussicht, der See direkt in der Nähe und Wanderwege, sowie Klettersteig fast direkt vor der Zelttür.\n" +
                "War alles sauber und ist mit liebe zum Detail gestaltet. Auch der Betreiber ist super nett und locker unterwegs.\n" +
                "Für Klimaanlage an heißen Sommertag ist gesorgt. Ebenso gibt es eine Heizdecke für kühle Sommernächte.\n" +
                "Wir sind hellauf begeistert und können es jeden nur ans Herz legen, diese Erfahrung zu machen.\n" +
                "P.S. Das ist kein Werbetext, sondern eine ehrliche Bewertung. Wir hatten tolle zwei Nächte.";
        ratingHotel2_2.rating = 10;
        ratingHotel2_2.user = "Svania";

        HotelActivity activityHotel2_1 = new HotelActivity();
        activityHotel2_1.type = "Wandern";
        activityHotel2_1.description = "Wandern";

        HotelActivity activityHotel2_2 = new HotelActivity();
        activityHotel2_2.type = "Mountain Biken";
        activityHotel2_2.description = "Mountain Biken";

        HotelActivity activityHotel2_3 = new HotelActivity();
        activityHotel2_3.type = "Paragliding";
        activityHotel2_3.description = "Paragliding";

        HotelActivity activityHotel2_4 = new HotelActivity();
        activityHotel2_4.type = "Bungee Jumping";
        activityHotel2_4.description = "Bungee Jumping";

        Hotel secondHotel = new Hotel();
        secondHotel.name = "Bubble Tent Salzburg";
        secondHotel.description = "Erlebe einzigartige Nächte im Salzkammergut.\n" +
                "In unseren Bubble Tents – den transparenten Kugelzelten.\n" +
                "Eine Übernachtung im BubbleTent ist ein echtes Natur-Erlebnis, abseits des Gewoehnlichen.\n" +
                "Geniesse die einzigartiger Lage mit freiem Blick auf die vielfältige Landschaft des Salzkammerguts. Abseits vom Stadttrubel, kannst du Körper und Seele baumeln lassen ohne auf den Komfort eines Hotels zu verzichten.\n";
        secondHotel.price = "95";
        secondHotel.category = "Abenteuer";
        secondHotel.stars = 1;
        secondHotel.location = "Feld 2, 4853 Steinbach am Attersee";
        secondHotel.ratings.add(ratingHotel2);
        secondHotel.ratings.add(ratingHotel2_1);
        secondHotel.ratings.add(ratingHotel2_2);
        secondHotel.activities.add(activityHotel2_1);
        secondHotel.activities.add(activityHotel2_2);
        secondHotel.activities.add(activityHotel2_3);
        secondHotel.activities.add(activityHotel2_4);

        Rating ratingHotel3_1 = new Rating();
        ratingHotel3_1.comment = "Das Frühstück war sehr gut, die Abwicklung sehr unkompliziert.\n" +
                "Besonders gefallen hat mir das wirklich sehr freundliche Personal. Das Fenster im Zimmer war gekippt (wohl über mehrere Stunden) und wir haben am Anfang ziemlich gefroren, weil es sehr lange dauerte, bis der Raum wieder angenehm temperiert war.\n" +
                "Das ist aber wirklich der einzige Kritikpunkt, sonst hat alles super gepasst.";
        ratingHotel3_1.rating = 7;
        ratingHotel3_1.user = "Alex";

        Rating ratingHotel3_2 = new Rating();
        ratingHotel3_2.comment = "The room was like a hotel room, with a nice double-bed, tv, and some hangers and shelves. It was clean and the towels were there waiting for us already when we came.\n" +
                " The bathroom was very nice and we were both surprised by what we got for our money";
        ratingHotel3_2.rating = 6;
        ratingHotel3_2.user = "Susanne";

        Rating ratingHotel3_3 = new Rating();
        ratingHotel3_3.comment = "The rooms are huge, good location next to Hauptbahnhof although a bit of a walk to the tourist attractions. My room faced onto a main road so a bit noisy";
        ratingHotel3_3.rating = 4;
        ratingHotel3_3.user = "Michael";

        HotelActivity activityHotel3_1 = new HotelActivity();
        activityHotel3_1.type = "Live-Sportveranstaltung";
        activityHotel3_1.description = "Live-Sportveranstaltung";

        HotelActivity activityHotel3_2 = new HotelActivity();
        activityHotel3_2.type = "Bibliothek";
        activityHotel3_2.description = "Bibliothek";

        HotelActivity activityHotel3_3 = new HotelActivity();
        activityHotel3_3.type = "Fahrradverleih";
        activityHotel3_3.description = "Fahrradverleih";

        HotelActivity activityHotel3_4 = new HotelActivity();
        activityHotel3_4.type = "Billard";
        activityHotel3_4.description = "Billard";

        Hotel thirdHotel = new Hotel();
        thirdHotel.name = "a&o Graz Hauptbahnhof";
        thirdHotel.description = "Das a&o Graz Hauptbahnhof liegt nur 100 m vom Grazer Hauptbahnhof entfernt. Im eigenen Bad liegen kostenfreie Pflegeprodukte und ein Haartrockner für Sie bereit. WLAN nutzen Sie in allen Bereichen kostenfrei.\n" +
                "Von der Bar auf der Dachterrasse können Sie den Panoramablick über die Stadt genießen. In der Lobby können Sie Tischfußball und Billard spielen. Für die Erkundung der Stadt können Sie den Fahrradverleih nutzen.\n" +
                "In der Lobby und in der Bar sorgt Sat-TV mit verschiedenen Sportkanälen für Unterhaltung.\n" +
                "Verschiedene Restaurants und Geschäfte im Zentrum von Graz können Sie vom a&o Graz Hauptbahnhof in 5 Gehminuten erreichen.\n" +
                "Gries ist bei Reisenden, die an einer schönen Altstadt, Spazieren gehen und Sightseeing interessiert sind, sehr beliebt.\n\n";
        thirdHotel.price = "40";
        thirdHotel.category = "Hostel";
        thirdHotel.stars = 3;
        thirdHotel.location = "Eggenberger Straße 7, Gries, 8020 Graz, Österreich";
        thirdHotel.ratings.add(ratingHotel3_1);
        thirdHotel.ratings.add(ratingHotel3_2);
        thirdHotel.ratings.add(ratingHotel3_3);
        thirdHotel.activities.add(activityHotel3_1);
        thirdHotel.activities.add(activityHotel3_2);
        thirdHotel.activities.add(activityHotel3_3);
        thirdHotel.activities.add(activityHotel3_4);
        thirdHotel.pictures.add("Hotel3_1.jpg");
        thirdHotel.pictures.add("Hotel3_2.jpg");
        thirdHotel.pictures.add("Hotel3_3.jpg");
        thirdHotel.pictures.add("Hotel3_4.jpg");
        thirdHotel.pictures.add("Hotel3_5.jpg");

        Rating ratingHotel4_1 = new Rating();
        ratingHotel3_1.comment = "Tolle Location, super freundlich. Ein wirklich tolles, hippes Design (außen Jugendstil, innen künstlerisch gestaltet, modern), " +
                "ein fabelhaftes Frühstück und wirklich nettes Personal. Sehr nah zur Innenstadt. Würde wiederkommen.";
        ratingHotel3_1.rating = 9;
        ratingHotel3_1.user = "Hans";

        Rating ratingHotel4_2 = new Rating();
        ratingHotel3_2.comment = "Everybody was very helpful and very friendly. Also the dinner was a real experience and the service was excellent. " +
                "It is seen the staff enjoys and know what they do. Very recommendable. Thanks!";
        ratingHotel3_2.rating = 8;
        ratingHotel3_2.user = "Peter";

        Rating ratingHotel4_3 = new Rating();
        ratingHotel3_3.comment = "Rooms have a great comfort, very modern and clean hotel, quiet as well, although in center. breakfast is amazing. " +
                "Staff is very friendly. Definetly will return!";
        ratingHotel3_3.rating = 10;
        ratingHotel3_3.user = "Bob";

        HotelActivity activityHotel4_1 = new HotelActivity();
        activityHotel3_1.type = "Fitnesscenter";
        activityHotel3_1.description = "Fitnesscenter";

        HotelActivity activityHotel4_2 = new HotelActivity();
        activityHotel3_2.type = "Spa und Wellnesscenter";
        activityHotel3_2.description = "Spa und Wellnesscenter";

        User userSeven = new User();
        userFour.name = "Alex";
        userFour.email = "alex@gmail.com";

        User userEigth = new User();
        userFive.name = "Susanne";
        userFive.email = "susanne@office.at";

        User userNine = new User();
        userSix.name = "Michael";
        userSix.email = "michael@test.nice";

        Rating ratingHotel3_1 = new Rating();
        ratingHotel3_1.comment = "Das Frühstück war sehr gut, die Abwicklung sehr unkompliziert.\n" +
                "Besonders gefallen hat mir das wirklich sehr freundliche Personal. Das Fenster im Zimmer war gekippt (wohl über mehrere Stunden) und wir haben am Anfang ziemlich gefroren, weil es sehr lange dauerte, bis der Raum wieder angenehm temperiert war.\n" +
                "Das ist aber wirklich der einzige Kritikpunkt, sonst hat alles super gepasst.";
        ratingHotel3_1.rating = 7;
        ratingHotel3_1.user = userSeven;

        Rating ratingHotel3_2 = new Rating();
        ratingHotel3_2.comment = "The room was like a hotel room, with a nice double-bed, tv, and some hangers and shelves. It was clean and the towels were there waiting for us already when we came.\n" +
                " The bathroom was very nice and we were both surprised by what we got for our money";
        ratingHotel3_2.rating = 6;
        ratingHotel3_2.user = userEigth;

        Rating ratingHotel3_3 = new Rating();
        ratingHotel3_3.comment = "The rooms are huge, good location next to Hauptbahnhof although a bit of a walk to the tourist attractions. My room faced onto a main road so a bit noisy";
        ratingHotel3_3.rating = 4;
        ratingHotel3_3.user = userNine;

        HotelActivity activityHotel3_1 = new HotelActivity();
        activityHotel3_1.type = "Live-Sportveranstaltung";
        activityHotel3_1.description = "Live-Sportveranstaltung";

        HotelActivity activityHotel3_2 = new HotelActivity();
        activityHotel3_2.type = "Bibliothek";
        activityHotel3_2.description = "Bibliothek";

        HotelActivity activityHotel3_3 = new HotelActivity();
        activityHotel3_3.type = "Fahrradverleih";
        activityHotel3_3.description = "Fahrradverleih";

        HotelActivity activityHotel3_4 = new HotelActivity();
        activityHotel3_4.type = "Billard";
        activityHotel3_4.description = "Billard";

        Hotel thirdHotel = new Hotel();
        thirdHotel.name = "a&o Graz Hauptbahnhof";
        thirdHotel.description = "Das a&o Graz Hauptbahnhof liegt nur 100 m vom Grazer Hauptbahnhof entfernt. Im eigenen Bad liegen kostenfreie Pflegeprodukte und ein Haartrockner für Sie bereit. WLAN nutzen Sie in allen Bereichen kostenfrei.\n" +
                "Von der Bar auf der Dachterrasse können Sie den Panoramablick über die Stadt genießen. In der Lobby können Sie Tischfußball und Billard spielen. Für die Erkundung der Stadt können Sie den Fahrradverleih nutzen.\n" +
                "In der Lobby und in der Bar sorgt Sat-TV mit verschiedenen Sportkanälen für Unterhaltung.\n" +
                "Verschiedene Restaurants und Geschäfte im Zentrum von Graz können Sie vom a&o Graz Hauptbahnhof in 5 Gehminuten erreichen.\n" +
                "Gries ist bei Reisenden, die an einer schönen Altstadt, Spazieren gehen und Sightseeing interessiert sind, sehr beliebt.\n\n";
        thirdHotel.price = "40";
        thirdHotel.category = "Hostel";
        thirdHotel.stars = 3;
        thirdHotel.location = "Eggenberger Straße 7, Gries, 8020 Graz, Österreich";
        thirdHotel.ratings.add(ratingHotel3_1);
        thirdHotel.ratings.add(ratingHotel3_2);
        thirdHotel.ratings.add(ratingHotel3_3);
        thirdHotel.activities.add(activityHotel3_1);
        thirdHotel.activities.add(activityHotel3_2);
        thirdHotel.activities.add(activityHotel3_3);
        thirdHotel.activities.add(activityHotel3_4);


        User userTen = new User();
        userFour.name = "Hans";
        userFour.email = "hans@gmail.com";

        User userEleven = new User();
        userFive.name = "Peter";
        userFive.email = "peter@office.at";

        User userTwelve = new User();
        userSix.name = "bob";
        userSix.email = "bob@test.nice";

        Rating ratingHotel4_1 = new Rating();
        ratingHotel3_1.comment = "Tolle Location, super freundlich. Ein wirklich tolles, hippes Design (außen Jugendstil, innen künstlerisch gestaltet, modern), " +
                "ein fabelhaftes Frühstück und wirklich nettes Personal. Sehr nah zur Innenstadt. Würde wiederkommen.";
        ratingHotel3_1.rating = 9;
        ratingHotel3_1.user = userTen;

        Rating ratingHotel4_2 = new Rating();
        ratingHotel3_2.comment = "Everybody was very helpful and very friendly. Also the dinner was a real experience and the service was excellent. " +
                "It is seen the staff enjoys and know what they do. Very recommendable. Thanks!";
        ratingHotel3_2.rating = 8;
        ratingHotel3_2.user = userEleven;

        Rating ratingHotel4_3 = new Rating();
        ratingHotel3_3.comment = "Rooms have a great comfort, very modern and clean hotel, quiet as well, although in center. breakfast is amazing. " +
                "Staff is very friendly. Definetly will return!";
        ratingHotel3_3.rating = 10;
        ratingHotel3_3.user = userTwelve;

        HotelActivity activityHotel4_1 = new HotelActivity();
        activityHotel3_1.type = "Fitnesscenter";
        activityHotel3_1.description = "Fitnesscenter";

        HotelActivity activityHotel4_2 = new HotelActivity();
        activityHotel3_2.type = "Spa und Wellnesscenter";
        activityHotel3_2.description = "Spa und Wellnesscenter";

        HotelActivity activityHotel4_3 = new HotelActivity();
        activityHotel3_3.type = "Fahrradverleih";
        activityHotel3_3.description = "Fahrradverleih";

        HotelActivity activityHotel4_4 = new HotelActivity();
        activityHotel3_4.type = "Shuttleservice";
        activityHotel3_4.description = "Shuttleservice";

        Hotel fourthHotel = new Hotel();
        fourthHotel.name = "Grand Hotel Wiesler";
        fourthHotel.description = "Das Hotel Wiesler in Graz liegt direkt an der Mur in der Grazer Altstadt und verfügt über eine Sauna, einen Fitnessbereich und einen Friseur. Das Hotel bietet auch eine 24-Stunden-Rezeption und kostenloses WLAN.\n" +
                "Das Restaurant Salon Marie serviert österreichische und internationale Küche. Hier wird Ihnen auch das reichhaltige und abwechslungsreiche Frühstücksbuffet serviert.\n" +
                "Das Kunsthaus befindet sich 100 m entfernt, und die Murinsel erreichen Sie bereits nach 300 m vom Hotel Wiesler in Graz. Die Schlossbergbahn liegt 5 Gehminuten entfernt. Leihfahrräder erhalten Sie in der Unterkunft.\n" +
                "Gries ist bei Reisenden, die an einer schönen Altstadt, Spazieren gehen und Sightseeing interessiert sind, sehr beliebt.\n" +
                "Laut unabhängiger Gästebewertungen ist das der beliebteste Teil von Graz.";
        fourthHotel.price = "120";
        fourthHotel.category = "Luxurious";
        fourthHotel.stars = 4;
        fourthHotel.location = "Grieskai 4-8, Gries, 8020 Graz, Österreich";
        fourthHotel.ratings.add(ratingHotel4_1);
        fourthHotel.ratings.add(ratingHotel4_2);
        fourthHotel.ratings.add(ratingHotel4_3);
        fourthHotel.activities.add(activityHotel4_1);
        fourthHotel.activities.add(activityHotel4_2);
        fourthHotel.activities.add(activityHotel4_3);
        fourthHotel.activities.add(activityHotel4_4);

        fourthHotel.pictures.add("Hotel4_1.jpg");
        fourthHotel.pictures.add("Hotel4_2.jpg");
        fourthHotel.pictures.add("Hotel4_3.jpg");
        fourthHotel.pictures.add("Hotel4_4.jpg");
        fourthHotel.pictures.add("Hotel4_5.jpg");
        fourthHotel.pictures.add("Hotel4_6.jpg");
    }
}
