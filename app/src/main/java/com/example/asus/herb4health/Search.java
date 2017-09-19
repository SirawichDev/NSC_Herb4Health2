package com.example.asus.herb4health;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {


    private String[] data;
    private ListView listView;

    private ArrayList<listEmptry> data_normal;
    private  ArrayList<listEmptry> data_search;
    private EditText main_listview_edittext;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //get data
        data = getResources().getStringArray(R.array.data);

        //Loop data
        data_normal = new ArrayList<listEmptry>();
        for (int i = 0; i < data.length; i++) {
            listEmptry listEmtry = new listEmptry();
            listEmtry.setTitle(data[i]);
            data_normal.add(listEmtry);
        }
        //view matching..
        main_listview_edittext=(EditText) findViewById(R.id.main_listview_edittext2);
        listView = (ListView) findViewById(R.id.search);
        doListNormal();

        //evet Editext
        main_listview_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (main_listview_edittext.length() !=0){

                    data_search = new ArrayList<listEmptry>();

                    for (int i = 0; i < data_normal.size(); i++){
                        if (data_normal.get(i).getTitle().contains(s)){

                            listEmptry listEmptry = new listEmptry();
                                listEmptry.setTitle(data_normal.get(i).getTitle());
                                data_search.add(listEmptry);
                        }

                    }
                    doListSearch();
                }else {
                    doListNormal();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void doListSearch() {
        listView.setAdapter(new CustomAdapter(data_search));
    }

    private void doListNormal() {
        listView.setAdapter(new CustomAdapter(data_normal));

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Search Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public class CustomAdapter extends BaseAdapter {

        private ArrayList<listEmptry> mData;
        private  Holder holder =new Holder();

        public CustomAdapter(ArrayList<listEmptry> data) {
            this.mData = data;
        }


        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = View.inflate(Search.this,R.layout.listview_item_layout,null);
            if(convertView != null){
                //view matching
                holder.title = (TextView) convertView.findViewById(R.id.listview_item_title);
                // set text
                holder.title.setText(mData.get(position).getTitle());
                convertView.setTag(holder);

            }else{
                convertView = (View) convertView.getTag();
            }



            return convertView;
        }
            public  class Holder{
                public TextView title;

        }
         }
    }
