package com.example.notehiveprojecttry;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Locale;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder> {

    private List<Event> activities;
    private OnItemClickListener listener;
    private Context context;

    public ActivitiesAdapter(Context context, List<Event> activities, OnItemClickListener listener) {
        this.context = context;
        this.activities = activities;
        this.listener = listener;
    }


    public interface OnItemClickListener {
        void onItemClick(Event event);
    }

    //Called when a row is displayed very first time in the screen.
    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ActivitiesViewHolder(view, listener);
    }

    //Called when a row is re-displayed on the screen, such as scrolling back.
    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
        Event activity = activities.get(position);
        holder.titleTextView.setText(activity.getTitle());
        holder.timeTextView.setText(holder.formatTime(activity.getStartTime()) + " - " + holder.formatTime(activity.getEndTime()));
        holder.categoryTextView.setText(activity.getCategory());

        String category = activity.getCategory();
        switch (category) {
            case "Education":
                holder.imageView.setImageResource(R.drawable.education_image);
                break;
            case "Health":
                holder.imageView.setImageResource(R.drawable.health_image);
                break;
            case "Meals":
                holder.imageView.setImageResource(R.drawable.meals_image);
                break;
            case "Breaks":
                holder.imageView.setImageResource(R.drawable.breaks_image);
                break;
            case "Leisure":
                holder.imageView.setImageResource(R.drawable.leisure_image);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    class ActivitiesViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, timeTextView, categoryTextView;
        ConstraintLayout root;

        ImageView imageView;

        public ActivitiesViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.activity_title);
            timeTextView = itemView.findViewById(R.id.activity_time);
            categoryTextView = itemView.findViewById(R.id.activity_category);
            imageView = itemView.findViewById(R.id.activity_image);
            root = itemView.findViewById(R.id.container);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(activities.get(position));
                    }
                }
            });
        }

        public String formatTime(int time) {
            int hours = time / 100;
            int minutes = time % 100;
            return String.format(Locale.getDefault(), "%02d:%02d", hours, minutes);
        }

    }
}
