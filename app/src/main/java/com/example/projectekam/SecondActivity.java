package com.example.projectekam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView fullName;
    private TextView mobileNumber;
    private CardView cardView;
    private EditText comment;
    private Button commentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        fullName =findViewById(R.id.fullName_textView);
        mobileNumber=findViewById(R.id.mobileNum_textView);
        cardView=findViewById(R.id.user_cV_cardView);
        comment=findViewById(R.id.comment_editText);
        commentBtn=findViewById(R.id.commentBtn_button);
        commentBtn.setOnClickListener(this);

        cardView.setCardBackgroundColor(getResources().getColor(R.color.colorCardColor));
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            fullName.setText(bundle.getString("FullName"));
            mobileNumber.setText(String.valueOf(bundle.getLong("MobNumber")));
            Log.d("SECONDACT", "onCreate: "+bundle.getString("FullName")+", "+bundle.getLong("MobNumber"));
        }else{
            Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_LONG).
                    show();
        }
    }

    @Override
    public void onClick(View view) {
        String newComment = comment.getText().toString().trim();
        if(!newComment.isEmpty()){
            Intent intent = getIntent();
            intent.putExtra("comment",newComment);
            setResult(RESULT_OK,intent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Make sure to comment properly",Toast.LENGTH_LONG).
                    show();
        }
    }
}
