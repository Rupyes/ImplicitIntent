package com.example.sdc.implicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        final EditText receivers = (EditText) findViewById(R.id.receiver);
        final EditText subject = (EditText) findViewById(R.id.subject);
        final EditText message = (EditText) findViewById(R.id.message);

        Button btn_send = (Button) findViewById(R.id.send_btn);
        Button btn_reset = (Button) findViewById(R.id.btn_reset);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = receivers.getText().toString();
                String sub = subject.getText().toString();
                String msg = message.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, sub);
                email.putExtra(Intent.EXTRA_TEXT, msg);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "rupyesmhj@gmail.com"));
                Toast.makeText(getApplicationContext(),"Sending...", Toast.LENGTH_SHORT ).show();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receivers.setText("");
                subject.setText("");
                message.setText("");
            }
        });

    }
}
