package com.androidhive.androidlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SingleListItem extends Activity{
	Button send;
    EditText msgText;
    LinearLayout listOfMsg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);
        send=(Button)findViewById(R.id.button);
        msgText=(EditText)findViewById(R.id.msg);
        listOfMsg=(LinearLayout)findViewById(R.id.listOfMsg);
        TextView txtProduct = (TextView) findViewById(R.id.product_label);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMsg();
            }
        });
        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("Contact");
        // displaying selected product name
        txtProduct.setText(product);


        
	}
    void sendMsg(){
        if(msgText.getText().toString()!=""){
            int N=1;
            TextView[] myTextViews = new TextView[N];
            for (int i = 0; i < N; i++) {
                // create a new textview
                final TextView rowTextView = new TextView(this);

                // set some properties of rowTextView or something
                rowTextView.setText(msgText.getText().toString());
                msgText.setText("");
                Toast.makeText(SingleListItem.this, "Msg Sent", Toast.LENGTH_SHORT).show();
                // add the textview to the linearlayout
                listOfMsg.addView(rowTextView);

                // save a reference to the textview for later
                myTextViews[i] = rowTextView;
            }

        }
    }
}
