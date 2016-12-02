package com.example.keeplone.project_android2;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutFragment extends Fragment {

    private ListView listView;
    private ListViewAdapter listAdapter;
    private YooutubeResult youtube;


    public WorkoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup workView = (ViewGroup) inflater.inflate(R.layout.fragment_workout, container,
                false);
        listView = (ListView) workView.findViewById(R.id.listview);
        listAdapter = new ListViewAdapter();
        listView.setAdapter(listAdapter);

        getActivity().setTitle("Workout");

        return workView;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_workout, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        new FeedTask().execute("http://www.office365thailand.com/youtube/array_youtube.php ");
    }

    private class ListViewAdapter extends BaseAdapter{
        @Override
        public int getCount() {

            if (youtube == null){
                return 0;
            }else {
                return youtube.getYoutube().size();
            }

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
            ViewHolder holder = null;
            if (view == null){
                view = getActivity().getLayoutInflater().inflate(R.layout.item_listview, null);
                holder = new ViewHolder();
                holder.titleTextView = (TextView)view.findViewById(R.id.item_listview_title);
                holder.authorImageView = (ImageView) view.findViewById(R.id.item_listview_authorIcon);
                holder.youtubeThumbnail = (ImageView) view.findViewById(R.id.item_listview_youtube_image);

                view.setTag(holder);
            }else {
                holder = (ViewHolder) view.getTag();
            }

            holder.youtubeThumbnail.setTag(R.id.item_listview_youtube_image, i);

            holder.youtubeThumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = (int) view.getTag(R.id.item_listview_youtube_image);

                    Intent intent = new Intent(getActivity(), ClickPlayActivity.class);

                    intent.putExtra("videoId", youtube.getYoutube().get(index).getId());
                    startActivity(intent);
                }
            });

            YooutubeResult.YoutubeBean item = youtube.getYoutube().get(i);

            holder.titleTextView.setText(item.getTitle());

            String authorUrl = item.getLogo();
            Glide.with(getActivity().getApplicationContext()).load(authorUrl)
            .transform(new CircleTransform(getActivity().getApplicationContext(), "#00ff00", 1))
            .into(holder.authorImageView);

            String imageUrl = item.getImage();
            Glide.with(getActivity().getApplicationContext()).load(imageUrl).into(holder.youtubeThumbnail);
            return view;
        }
    }
    public class FeedTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            Log.i("Test","doInBackground");
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(strings[0]).build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }
            catch (IOException e){
                Log.i("Test",e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("Test","onPreExecute");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("Test","onPostExecute");
            Gson gson = new Gson();
            youtube = gson.fromJson(s, YooutubeResult.class);
            listAdapter.notifyDataSetChanged();
        }
    }

    public class ViewHolder{
        TextView titleTextView;
        ImageView authorImageView;
        ImageView youtubeThumbnail;
    }
}
