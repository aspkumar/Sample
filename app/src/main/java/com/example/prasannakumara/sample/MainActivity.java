package com.example.prasannakumara.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<langModelClass> laguagedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* laguagedList = new ArrayList<>();
        laguagedList.add(0, "రోజు");
        laguagedList.add(1, "బాద");
        laguagedList.add(2, "బాద");
        laguagedList.add(3, "బాద");
        laguagedList.add(4, "బాద");
        laguagedList.add(5, "బాద");
        laguagedList.add(6, "బాద");
*/

//       langModelClass la=new langModelClass("sfsdfsda");


        laguagedList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            laguagedList.add(new langModelClass(String.valueOf(i)));
        }

        ArrayList<String> newlist = new ArrayList<>();

        String[] stringArray;

        stringArray = new String[10];
        for (int i = 0; i < 10; i++) {
            stringArray[i] = String.valueOf(1 + i);
        }


        /*String[] language_list = getResources().getStringArray(R.array.language_list);
        ListView languagelistview = (ListView) findViewById(R.id.languages_listview);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, R.id.sample_text, language_list);
        adapter.getCount();
        toastMehtod(String.valueOf(adapter.getCount()));
        languagelistview.setAdapter(adapter);
        languagelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toastMehtod(String.valueOf(position));

            }
        });*/


        ListView languagelistview = (ListView) findViewById(R.id.languages_listview);
        myBaseAdapter mbaseAdapter = new myBaseAdapter(this, laguagedList);
        languagelistview.setAdapter(mbaseAdapter);
        mbaseAdapter.notifyDataSetChanged();

        languagelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void toastMehtod(String string) {
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }


    public class myBaseAdapter extends BaseAdapter {
        Context context;
        ArrayList<langModelClass> one;


        public myBaseAdapter(Context context, ArrayList<langModelClass> one) {
            this.context = context;
            this.one = one;
//            toastMehtod("constructor");
            Log.d("stage","constructor");
        }

        @Override
        public int getCount() {
//toastMehtod("getCount");
//            Log.d("stage",);
            return one.size();

        }

        @Override
        public Object getItem(int position) {
//            toastMehtod("getItem");

//            Log.d("stage",);
            return one.get(position);
        }

        @Override
        public long getItemId(int position) {
//            toastMehtod("getItemId");

//            Log.d("stage",);
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            toastMehtod("getView");

//            Log.d("stage",);

            myViewHolder viewHolder = null;
            View itemView = convertView;
            if (itemView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                itemView = layoutInflater.inflate(android.R.layout.simple_list_item_1, null);
                viewHolder = new myViewHolder(itemView);
                itemView.setTag(viewHolder);
            } else {
//                toastMehtod("gone to else");
                viewHolder = (myViewHolder) itemView.getTag();
            }

            viewHolder.sampleText.setText(one.get(position).getLang());

            return itemView;
        }


        public class myViewHolder {

            TextView sampleText;

            public myViewHolder(View view) {
                sampleText = (TextView) view.findViewById(android.R.id.text1);
//                toastMehtod("viewholde");
//                Log.d("stage",);

            }
        }


    }


    public class myArrayAdapter extends ArrayAdapter<langModelClass> {
       Context context;
        int resourceId;
        langModelClass lang[];

        public myArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull langModelClass[] objects) {
            super(context, resource, objects);
        }
    }

}
