package cz.sribagavathmission.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cz.sribagavathmission.R;

/**
 * Created by macbook on 22/07/16.
 */
public class FloweringListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater Inflater;
    String[] Categories_names;
    int[] Categories_images;

    public  FloweringListAdapter(Context context,String[] Categories_names,int[] Categories_images){

        this.context            = context;
        this.Categories_names   = Categories_names;
        this.Categories_images  = Categories_images;


    }



    @Override
    public int getCount() {
        return this.Categories_names.length;
    }

    @Override
    public Object getItem(int position) {
        return this.Categories_names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(Inflater == null)

            Inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        if(convertView == null){

            convertView = Inflater.inflate(R.layout.flower_sub_categories,null);

            holder     = new ViewHolder();

            holder.Txt_category_name = (TextView) convertView.findViewById(R.id.category_name);
            holder.Img_category      = (ImageView) convertView.findViewById(R.id.category_image);

            convertView.setTag(holder);


        } else {

            holder = (ViewHolder)convertView.getTag();

        }

        holder.Txt_category_name.setText(this.Categories_names[position]);

        holder.Img_category.setBackgroundResource(this.Categories_images[position]);


        return convertView;
    }

    static class ViewHolder{

        TextView Txt_category_name;
        ImageView Img_category;

    }
}


