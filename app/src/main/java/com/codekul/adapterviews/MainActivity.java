package com.codekul.adapterviews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ListView listCities;

    private GridView gridView;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> listDataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listCities = (ListView) findViewById(R.id.listCities);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // here you will get clicked view


            }
        });

        //listDataSet.add("Pune");
        //listDataSet.add("Mumbai");
        //listDataSet.add("Delhi");
        //listDataSet.add("Bengolore");

        //arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listDataSet);
        //listCities.setAdapter(arrayAdapter);

        List<MyItem> listMyItems = new ArrayList<>();

        MyItem item1 = new MyItem();
        item1.setImageId(R.drawable.ic_add_shopping_cart_black_24dp);
        item1.setImageName("Cart");
        listMyItems.add(item1);

        MyItem item2 = new MyItem();
        item2.setImageId(R.drawable.ic_alarm_black_24dp);
        item2.setImageName("Lock");
        listMyItems.add(item2);

        MyItem item3 = new MyItem();
        item3.setImageId(R.drawable.ic_add_shopping_cart_black_24dp);
        item3.setImageName("UnLock");
        listMyItems.add(item3);

        MyItem item4 = new MyItem();
        item4.setImageId(R.drawable.ic_add_shopping_cart_black_24dp);
        item4.setImageName("Password");
        listMyItems.add(item4);

        MyAdapter adapter = new MyAdapter(this,listMyItems);
        gridView.setAdapter(adapter);
    }

    private class MyItem {

        private Integer imageId;
        private String imageName;

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public Integer getImageId() {
            return imageId;
        }

        public void setImageId(Integer imageId) {
            this.imageId = imageId;
        }
    }
    private class MyAdapter extends BaseAdapter{

        private Context context;
        private List<MyItem> listMyItem;
        private LayoutInflater inflater;

        public MyAdapter(Context context,List<MyItem> listItems){

            this.context = context;
            this.listMyItem = listItems;

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return listMyItem.size();
        }

        @Override
        public Object getItem(int position) {
            return listMyItem.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position * 7;
        }

        @Override
         public View getView(int position, View convertView, ViewGroup parent) {

            View view = inflater.inflate(R.layout.grid_compound_view,null, false);
            MyItem item = listMyItem.get(position);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageGridItem);
            imageView.setImageResource(item.getImageId());

            TextView textView = (TextView) view.findViewById(R.id.textGridItem);
            textView.setText(item.getImageName());

            return view;
        }
    }
}
