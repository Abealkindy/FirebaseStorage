package com.rosinante24.firebasestorage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 05/10/17.
 */

public class ListUploadAdapter extends RecyclerView.Adapter<ListUploadAdapter.ViewHolder> {

    private Context context;
    private List<Upload> uploadList;

    public ListUploadAdapter(Context context, List<Upload> uploadList) {
        this.context = context;
        this.uploadList = uploadList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recycler_upload, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Upload upload = uploadList.get(position);

        holder.textRowRecyclerUpload.setText(upload.getName());

        Glide.with(context)
                .load(upload.getUrl())
                .into(holder.imageRowRecylerUpload);
    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_row_recyler_upload)
        ImageView imageRowRecylerUpload;
        @BindView(R.id.text_row_recycler_upload)
        TextView textRowRecyclerUpload;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
