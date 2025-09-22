package cis3334.java_heartrate_start;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HeartrateAdapter extends RecyclerView.Adapter<HeartrateViewHolder>{

    Application application;
    MainViewModel mainViewModel;

    public HeartrateAdapter(Application application, MainViewModel mainViewModel) {
        this.application = application;
        this.mainViewModel = mainViewModel;
    }


    @NonNull
    @Override
    public HeartrateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heartrate_row, parent, false);
        HeartrateViewHolder holder = new HeartrateViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HeartrateViewHolder holder, int position) {
     Heartrate heartrate = mainViewModel.getAllHeartrates().getValue().get(position);
     holder.textViewPulse.setText(heartrate.pulse.toString());
     holder.textViewRange.setText(heartrate.getRangeName());
     holder.textViewDescription.setText(heartrate.getRangeDescrtiption());
    }

    @Override
    public int getItemCount() {
        return mainViewModel.getAllHeartrates().getValue().size();
    }

    public void setHeartrates(List<Heartrate> allHeartrates) {
        notifyDataSetChanged();
    }
}
