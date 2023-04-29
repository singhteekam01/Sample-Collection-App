package com.example.fssai.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fssai.R;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    Context context;
    List<ScheduleModel> scheduleModelList;

    public ScheduleAdapter(Context context, List<ScheduleModel> scheduleModelList) {
        this.context = context;
        this.scheduleModelList = scheduleModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_schedule_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(scheduleModelList != null && scheduleModelList.size() > 0){

            ScheduleModel model = scheduleModelList.get(position);
//            holder.samplerName.setText(model.getSamplerName());

            Integer i = model.getStatus_view();
            if(i == 1){
                int color = Color.parseColor("#00FF00");
                holder.view_status.setColorFilter(color); // get your desired color
            }else{
                int color = Color.parseColor("#FF0000");
                holder.view_status.setColorFilter(color);
            }

            holder.city.setText(model.getCity());
            holder.fsoName.setText(model.getFsoName());
            holder.date.setText(model.getDateTime());
//            holder.time.setText(model.getTime().toString());
            holder.location.setText(model.getLocation());

        }else{
            return;
        }

    }

    @Override
    public int getItemCount() {
        return scheduleModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView city,fsoName,date,location;
        ImageView view_status;
        TableRow tableRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view_status = itemView.findViewById(R.id.view_status);
            city = itemView.findViewById(R.id.tv_city);
            fsoName = itemView.findViewById(R.id.tv_fso);
            date = itemView.findViewById(R.id.tv_datetime);
            location = itemView.findViewById(R.id.tv_location);
            tableRow = itemView.findViewById(R.id.row_table);


            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // inflate the layout file for the pop-up window
                    View popupView = LayoutInflater.from(context).inflate(R.layout.table_popup, null);

                    // create a new instance of a PopupWindow
                    PopupWindow popupWindow = new PopupWindow(popupView,
                            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                    // set a background color for the pop-up window
                    popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                    // set the pop-up window to dismiss when the user clicks outside of it
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setFocusable(true);


                    TextView textView1 = popupView.findViewById(R.id.tv1);
                    TextView textView2 = popupView.findViewById(R.id.tv2);
                    TextView textView3 = popupView.findViewById(R.id.tv3);
                    TextView textView4 = popupView.findViewById(R.id.tv4);


                    textView1.setText("Date:-"+date.getText().toString());
                    textView2.setText("City:-"+city.getText().toString());
                    textView3.setText("FSO:-"+fsoName.getText().toString());
                    textView4.setText("Location:-"+location.getText().toString());

                    // show the pop-up window at the center of the screen
                    popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
                }
            });
        }
    }

}
