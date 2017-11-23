package cz.sribagavathmission;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import cz.sribagavathmission.adapter.CategoriesListAdapter;

/**
 * Created by macbook on 18/07/16.
 */
public class CategoriesActivity extends AppCompatActivity {

    String[] Categories_name = new String[]{"Videos","Gallery","Free E-Books","Programme","Question & Answers","Ask Ayya","Buy a Book","Buy a Subscription","Your Flowering","Social Media","Contact","Powered by"};

    int[] Categories_images = new int[] {R.drawable.icon0,R.drawable.galleryicon,
            R.drawable.icon3,R.drawable.icon4,R.drawable.icon5,R.drawable.icon6,R.drawable.icon7,R.drawable.icon8,R.drawable.icon9,R.drawable.icon10,R.drawable.icon11,R.drawable.icon12sub
            };

   CategoriesListAdapter adapter;
    ListView CategoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        CategoryList = (ListView) findViewById(R.id.category_list);

        adapter = new CategoriesListAdapter(this,Categories_name,Categories_images);
        CategoryList.setAdapter(adapter);

        CategoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position == 0) {

                    Intent videos = new Intent(getApplicationContext(),WebViewActivity.class);
                    videos.putExtra("url","https://www.youtube.com/channel/UCEkikBK-fwmmxJWoACfELug");
                    startActivity(videos);

                } else if(position == 1){

                    Intent gallery = new Intent(getApplicationContext(),GalleryActivity.class);
                    startActivity(gallery);


                } else if(position == 2) {

                    Intent ebooks = new Intent(getApplicationContext(),EbookActivity.class);
                    startActivity(ebooks);


                } else if(position == 3) {

                    Intent programme = new Intent(getApplicationContext(),WebViewActivity.class);
                    programme.putExtra("url","http://www.sribagavath.org/events/");
                    startActivity(programme);


                } else if(position == 4) {

                    Intent qa = new Intent(getApplicationContext(),WebViewActivity.class);
                    qa.putExtra("url","https://drive.google.com/folderview?id=0B2B_0GnmD9Mia2E1YjNWdDhWSTg");
                    startActivity(qa);


                } else if(position == 5) {

                    Intent askayya = new Intent(getApplicationContext(),WebViewActivity.class);
                    askayya.putExtra("url","http://pravaagam.org/your_qus.php");
                    startActivity(askayya);


                } else if(position == 6){

                    Intent book = new Intent(getApplicationContext(),WebViewActivity.class);
                    book.putExtra("url","http://pravaagam.org/buy_book.php");
                    startActivity(book);

                } else if(position == 7){

                    Intent subscription = new Intent(getApplicationContext(),WebViewActivity.class);
                    subscription.putExtra("url","http://pravaagam.org/magazine.php");
                    startActivity(subscription);

                } else if(position == 8){

                    Intent flowering = new Intent(getApplicationContext(),UnderstandActivity.class);
                    startActivity(flowering);

                } else if(position == 9){

                   popup();

                }


                else if(position == 10) {

                    Intent contact_us = new Intent(getApplicationContext(),ContactUsActivity.class);
                    startActivity(contact_us);


                } else if(position == 11) {

                    Intent profile = new Intent(getApplicationContext(),ProfileActivity.class);
                    profile.putExtra("url","http://czsm.co.in/");
                    startActivity(profile);


                }



            }
        });


    }


    public void popup(){

        final Dialog dialog = new Dialog(CategoriesActivity.this);

        //tell the Dialog to use the dialog.xml as it's layout description
        dialog.setContentView(R.layout.social_popup);
        dialog.setTitle("Follow us on");

        ImageView Img_fb = (ImageView) dialog.findViewById(R.id.Img_fb);
        ImageView Img_twitter = (ImageView) dialog.findViewById(R.id.Img_twitter);

        Img_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fb = new Intent(getApplicationContext(),WebViewActivity.class);
                fb.putExtra("url","https://www.facebook.com/BagavathPath/");
                startActivity(fb);

                dialog.dismiss();
            }
        });

        Img_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent twitter = new Intent(getApplicationContext(),WebViewActivity.class);
                twitter.putExtra("url","https://twitter.com/bagavathpath");
                startActivity(twitter);

                dialog.dismiss();
            }
        });

        dialog.show();




    }
}
