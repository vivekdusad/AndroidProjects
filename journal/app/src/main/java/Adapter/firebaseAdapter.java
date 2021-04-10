package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import model.classesModel;

public class firebaseAdapter extends FirebaseRecyclerAdapter<classesModel,firebaseAdapter.ViewHolder> {
    private onButtonClick buttonClick;
    Context mContext;
    public interface onButtonClick{
        public void buttonClick(int position);
    }
    public void setOnButtonClik(onButtonClick buttonClik){
        buttonClick = buttonClik;
    }
    public firebaseAdapter(@NonNull FirebaseRecyclerOptions<classesModel> options,Context mContext) {
        super(options);
        this.mContext = mContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull classesModel model) {
        holder.constraintLayout.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.item_animation));
        holder.teacher_textView.setText(model.getTeacher());

        holder.code_textView.setText(model.getCode());
        holder.name_textView.setText(model.getName());
        holder.time_textView.setText(model.getTime());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView link_textView,code_textView,name_textView,teacher_textView,time_textView;
        Button join_now_button;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constraint_layout_id);

            teacher_textView = itemView.findViewById(R.id.class_teacher_id);
            name_textView = itemView.findViewById(R.id.class_name_id);
            time_textView = itemView.findViewById(R.id.time_text_id);
            code_textView = itemView.findViewById(R.id.class_code_id);
            join_now_button = itemView.findViewById(R.id.join_now_id);
            join_now_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(buttonClick != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            buttonClick.buttonClick(position);
                        }
                    }
                }
            });

        }
    }
}
