package cz.sribagavathmission.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import cz.sribagavathmission.R;
import cz.sribagavathmission.WebViewActivity;

/**
 * Created by macbook on 21/07/16.
 */
public class EbookListAdapter  extends RecyclerView.Adapter<EbookListAdapter.ViewHolder> {

    List<PlayListVO> listVOs;
    Context c;
    public EbookListAdapter(List<PlayListVO> listVOs,Context con) {
        this.listVOs = listVOs;
        c=con;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.ebooks_list_item,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(listVOs.get(position).getSongName());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(c, WebViewActivity.class);
                intent.putExtra("url",listVOs.get(position).getSongURL());
                intent.putExtra("type","pdf");
                c.startActivity(intent);

//                new DownloadFile().execute(listVOs.get(position).getSongURL(), listVOs.get(position).getSongName()+".pdf");

            }
        });
    }

    @Override
    public int getItemCount() {
        return listVOs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView play;
        View v;
        public ViewHolder(View v) {
            super(v);
            this.v=v;
            name=(TextView) v.findViewById(R.id.songname);

        }
    }


    private class DownloadFile extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "testthreepdf");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;
        }
    }
}

