package com.example.fssai.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fssai.R;

import java.util.List;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.ViewHolder> {

    List<SurveyModel> surveyAdapterList;
    Context context;
    int mSelectedPosition = RecyclerView.NO_POSITION;

    public SurveyAdapter(List<SurveyModel> surveyAdapterList, Context context) {
        this.surveyAdapterList = surveyAdapterList;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_survey_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        SurveyModel model = surveyAdapterList.get(position);


        holder.city.setText(model.getCity());
        holder.fsoName.setText(model.getFsoName());
        holder.date.setText(model.getDateTime());
//            holder.time.setText(model.getTime().toString());
        holder.location.setText(model.getLocation());


        holder.checkBox.setChecked(mSelectedPosition == position);

        holder.itemView.setOnClickListener(v -> {
            if (mSelectedPosition != position) {
                mSelectedPosition = position;
                notifyDataSetChanged();
                sendDataToBackend(model);
            }
        });

    }

    @Override
    public int getItemCount() {
        return surveyAdapterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView city,fsoName,date,location;
        CheckBox checkBox;
        TableRow tableRow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkbox_survey);
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

    private void sendDataToBackend(SurveyModel model) {
        // call the API to send the data to the backend
        // you can use a library like Retrofit to make the API call
        // pass the data from the selected item and any additional data as parameters
    }
}
