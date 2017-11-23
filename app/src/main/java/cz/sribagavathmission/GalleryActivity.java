package cz.sribagavathmission;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import cz.sribagavathmission.adapter.CategoriesListAdapter;

/**
 * Created by macbook on 27/07/16.
 */
public class GalleryActivity extends AppCompatActivity {

    String[] Categories_name = new String[]{"Audios Tamil","Audio English","Ayya Messages"};

    int[] Categories_images = new int[]{R.drawable.icon1,R.drawable.icon1,R.drawable.icon2};

    CategoriesListAdapter adapter;
    ListView CategoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_list);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        CategoryList = (ListView) findViewById(R.id.gallerylist);

        adapter  = new CategoriesListAdapter(this, Categories_name, Categories_images);
        CategoryList.setAdapter(adapter);

        CategoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent audios = new Intent(getApplicationContext(),PlayList.class);
                    startActivity(audios);


                } else if(position == 1){

                    Intent audios = new Intent(getApplicationContext(),EnglishPlayList.class);
                    startActivity(audios);

                }

                else if (position == 2) {

                    Intent messages = new Intent(getApplicationContext(),WebViewActivity.class);
                    messages.putExtra("url","http://www.sribagavath.org/magazine/");
                    startActivity(messages);

                }

            }
        });


    }

}
