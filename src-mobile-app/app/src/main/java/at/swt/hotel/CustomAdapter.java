package at.swt.hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Hotel> hotelList;
    String[] hotelNames;
    int pictures[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<Hotel> hotelList, int[] pictures) {
        this.context = context;
        this.hotelList = hotelList;
        this.pictures = pictures;
        inflter = (LayoutInflater.from(applicationContext));
        hotelNames = new String[hotelList.size()];
        int position = 0;
        for(Hotel h : hotelList){
            hotelNames[position++] = h.name;
        }
    }

    @Override
    public int getCount() {
        return hotelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_view, null);
        TextView hotelName = (TextView)view.findViewById(R.id.hotel_text);
        ImageView picture = (ImageView)view.findViewById(R.id.hotel_picture);

        hotelName.setText(hotelNames[i]);
        picture.setImageResource(pictures[i]);
        return view;
    }
}
