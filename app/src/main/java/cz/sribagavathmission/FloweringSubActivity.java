package cz.sribagavathmission;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import cz.sribagavathmission.adapter.FloweringListAdapter;

/**
 * Created by macbook on 22/07/16.
 */
public class FloweringSubActivity extends AppCompatActivity {


    String[] Categories_name = new String[]{"Understanding","Agam Puram","Naan Yaar","Confirmation","Gnana viduthalai ebook"};

    int[] Categories_images = new int[] {R.drawable.icon4,R.drawable.icon4,R.drawable.icon4,R.drawable.icon4,
            R.drawable.icon4};

    FloweringListAdapter adapter;
    ListView CategoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_sub_list);


        CategoryList = (ListView) findViewById(R.id.category_list);

        adapter = new FloweringListAdapter(this,Categories_name,Categories_images);
        CategoryList.setAdapter(adapter);

        CategoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Intent intent = new Intent(getApplicationContext(),UnderstandActivity.class);
                    startActivity(intent);


                } else if(position == 4){

                    Intent intent=new Intent(getApplicationContext(), WebViewActivity.class);
                    intent.putExtra("url","http://www.sribagavath.org/wp-content/uploads/2012/11/Gnanaviduthalai2.pdf");
                    intent.putExtra("type","pdf");
                    startActivity(intent);

                }



            }
        });


    }
}
