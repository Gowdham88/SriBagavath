package cz.sribagavathmission;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.sribagavathmission.adapter.EbookListAdapter;
import cz.sribagavathmission.adapter.PlayListVO;

/**
 * Created by macbook on 21/07/16.
 */
public class EbookActivity  extends AppCompatActivity {

    RecyclerView play_list;
    EbookListAdapter adapter;

    public static String URL_READER = "http://www.sribagavath.org/ebooks/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ebooks_list);

        play_list = (RecyclerView) findViewById(R.id.playlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(EbookActivity.this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        play_list.setLayoutManager(layoutManager);

        System.out.println("URL_READER..." + URL_READER);
        if (Globals.isConnected(EbookActivity.this)) {
            new AsyncPlaylist().execute();
        } else {
            Toast.makeText(EbookActivity.this, "No Internet Connection Available", Toast.LENGTH_LONG).show();
        }

    }

    public class AsyncPlaylist extends AsyncTask<Void, Void, Boolean> {

        ProgressDialog pd;

        PlayListVO vo = new PlayListVO();

        @Override
        protected Boolean doInBackground(Void... params) {
            Boolean boolResponse = false;
            Globals.list = new ArrayList<>();
            try {
                URL url = new URL(URL_READER);
                URLConnection conn = url.openConnection();
                // open the stream and put it into BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine = "";

                while ((inputLine = br.readLine()) != null) {
                    System.out.println("inputLine.toString()..." + inputLine.toString());
                    if (inputLine.toString().startsWith("<li><a href")) {
                        Log.e("mp", "" + inputLine.toString());
                        if ((inputLine.toString().contains("http://www.sribagavath.org/wp-content/uploads"))) {

                            Pattern p = Pattern.compile("href=\"(.*?)\"");
                            Matcher m = p.matcher(inputLine.toString());
                            String ur = null;
                            if (m.find()) {
                                ur = m.group(1); // this variable should contain the link URL
                                Log.e("sdsds", ur);
                            }

                            final Pattern pattern = Pattern.compile("<a[^>]*>(.*?)</a>");
                            final Matcher matcher = pattern.matcher(inputLine.toString());
                            matcher.find();

                            vo = new PlayListVO();

                            vo.setSongName(matcher.group(1));
                            vo.setSongURL(ur);
                            Globals.list.add(vo);
                            boolResponse = true;


                        }
                    }
                }
                br.close();


                System.out.println("Globals.list...." + Globals.list);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return boolResponse;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(EbookActivity.this);
            pd.setMessage("Loading ...");
            pd.setCancelable(false);
            pd.setCanceledOnTouchOutside(false);
            pd.show();

        }

        @Override
        protected void onPostExecute(Boolean result) {
            pd.dismiss();
            if (result) {
                adapter = new EbookListAdapter(Globals.list, EbookActivity.this);
                play_list.setAdapter(adapter);
            } else {
                Toast.makeText(EbookActivity.this, "Unable to Connect web site", Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        return;
    }

}