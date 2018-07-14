package com.example.peiru.facbook_try;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    TextView textId;
    TextView amount;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        textId = (TextView) findViewById(R.id.textId);
        amount = (TextView) findViewById(R.id.amount);
        status = (TextView) findViewById(R.id.status);

        // get Intent

        Intent intent = getIntent();

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            shpwDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        }  catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void shpwDetails(JSONObject response, String paymentAmount) {
        try {
            textId.setText(response.getString("id"));
            amount.setText(response.getString("state"));
            status.setText(response.getString(String.format("SGD$ %s", paymentAmount)));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
