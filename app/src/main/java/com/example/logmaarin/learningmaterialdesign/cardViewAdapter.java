package com.example.logmaarin.learningmaterialdesign;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by LogMaarIn on 16-5-2015.
 */
public class cardViewAdapter extends RecyclerView.Adapter<cardViewAdapter.ViewHolder> {

    private ArrayList<Tweet> tweets;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View tweet;


        public ViewHolder(View t) {
            super(t);
            tweet = t;

        }
    }

    public cardViewAdapter(ArrayList<Tweet> twt) {
        tweets = twt;
    }
    @Override
    public cardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet, parent, false);
        ViewHolder vh = new ViewHolder (v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Tweet currentItem = tweets.get(position);
        SpannableStringBuilder sb = new SpannableStringBuilder(currentItem.getTweet());
        ForegroundColorSpan color = new ForegroundColorSpan(Color.rgb(0, 0, 180));

        Entity entity = currentItem.getEntity();
        for (int i = 0; i< entity.getHashtags().size();i++){
            Hashtag h = entity.getHashtags().get(i);
            sb.setSpan(color, h.getBegin(), h.getEind(), sb.SPAN_EXCLUSIVE_EXCLUSIVE);
        }





        TextView t = (TextView) holder.tweet.findViewById(R.id.tweet);
        TextView u = (TextView) holder.tweet.findViewById(R.id.username);
        TextView n = (TextView) holder.tweet.findViewById(R.id.naam);
        ImageView img = (ImageView) holder.tweet.findViewById(R.id.profilePicture);
        ImageView media = (ImageView) holder.tweet.findViewById(R.id.imageView);
        if (currentItem.getUser().getPf() == null){
            img.setImageResource(R.drawable.ic_launcher);
        } else {
            img.setImageBitmap(currentItem.getUser().getPf());
        }
        if (entity.getMedias().size()>0) {
            media.setImageBitmap(entity.getMedias().get(0).getImage());
        }
        /**try {
            Bitmap bmp =  new MyAsyncTask().execute(currentItem.getPf()).get();
            if (entity.getMedias().size()>0){
                Bitmap image = new MyAsyncTask().execute(currentItem.entity.getMedias().get(0).getMediaURL()).get();
                media.setImageBitmap(image);
            }

            if (bmp == null){
                img.setImageResource(R.drawable.ic_launcher);
            } else {
                img.setImageBitmap(bmp);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        */

        t.setText(sb);
        u.setText(currentItem.getUser().getUserName());
        n.setText(currentItem.getUser().getNaam());


    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }


}
