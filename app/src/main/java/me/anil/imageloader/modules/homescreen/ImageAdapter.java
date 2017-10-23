package me.anil.imageloader.modules.homescreen;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.anil.imageloader.BuildConfig;
import me.anil.imageloader.R;
import me.anil.imageloader.modules.detail.DetailActivity;
import me.anil.imageloader.repository.FeedResponse;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {


    private ArrayList<FeedResponse> responses;
    private Context context;

    public ImageAdapter(Context context, ArrayList<FeedResponse> responses) {
        this.context = context;
        System.out.println(responses.size());
        this.responses = responses;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override

    public void onBindViewHolder(ImageViewHolder holder, int position) {
        final FeedResponse feedResponse = responses.get(position);
        final String imageUriString = String.format(BuildConfig.HOST_API + "/%d" + "/%d?image=%d", 200, 300, feedResponse.id);
        Uri imageUri = Uri.parse(imageUriString);
        holder.setData(feedResponse);
        Picasso.with(context).load(imageUri)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        public AppCompatImageView imageView;
        private FeedResponse response;


        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("IMAGE_DATA", response);
                    context.startActivity(intent);

                }
            });
        }

        void setData(FeedResponse response) {

            this.response = response;
        }
    }
}
