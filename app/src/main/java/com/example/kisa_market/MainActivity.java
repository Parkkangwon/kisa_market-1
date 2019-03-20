package com.example.kisa_market;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import static java.security.AccessController.getContext;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  Button scanbutton;
    private Button switchbutton;
    private IntentIntegrator qrScan;
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private ArrayList<Notice> noticeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noticeListView = (ListView) findViewById(R.id.orderList);
        noticeList=new ArrayList<Notice>();
        adapter=new NoticeListAdapter(getApplicationContext(),noticeList);
        noticeListView.setAdapter(adapter);

        scanbutton =(Button)findViewById(R.id.scanButton);
        switchbutton = (Button)findViewById(R.id.switchButton);
        qrScan =new IntentIntegrator(this);

        scanbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                qrScan.setPrompt("Scanning...");
                qrScan.initiateScan();
            }
        });
        switchbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sellerIntent = new Intent(MainActivity.this,Seller.class);
                MainActivity.this.startActivity(sellerIntent);
            }
        });
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //qrcode 가 없으면
            if (result.getContents() == null) {
           //     Toast.makeText(MainActivity.this, "취소!", Toast.LENGTH_SHORT).show();
            } else {
                //qrcode 결과가 있으면
                Toast.makeText(MainActivity.this, "스캔완료!", Toast.LENGTH_SHORT).show();
                try {
                    //data를 json으로 변환
                    JSONObject obj = new JSONObject(result.getContents());
                    textViewName.setText(obj.getString("name"));
                    textViewAddress.setText(obj.getString("address"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
                    textViewResult.setText(result.getContents());
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }*/
}
