package com.example.muhtamimnahid.alone;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.muhtamimnahid.alone.Adapter.CustomAdapter;
import com.example.muhtamimnahid.alone.Helper.HttpDataHandler;
import com.example.muhtamimnahid.alone.Models.ChatModel;
import com.example.muhtamimnahid.alone.Models.Simsimi_Model;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    List<ChatModel>list_chat = new ArrayList<>();
    FloatingActionButton btn_send_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_of_message);
        editText = findViewById(R.id.user_message);
        btn_send_message = findViewById(R.id.fab);

        btn_send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                ChatModel model = new ChatModel(text,true);//user send message
                list_chat.add(model);
                new SimSimiAPI().execute(list_chat);

                //remove user message

                editText.setText(",");
            }
        });
    }

    private class SimSimiAPI extends AsyncTask<List<ChatModel>,Void,String> {

        String stream = null;
        List<ChatModel>models;
        String text = editText.getText().toString();
        @Override
        protected String doInBackground(List<ChatModel>... lists) {
           String url = String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=bn&ft=1.0&text=%s",getString(R.string.simsimi_api),text);
            models = lists[0];
            HttpDataHandler  httpDataHandler = new HttpDataHandler();
            stream = httpDataHandler.GetHttpData(url);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            Simsimi_Model response = gson.fromJson(s,Simsimi_Model.class);

            ChatModel chatModel = new ChatModel(response.getResponse(),false); // get response from simsimi
            models.add(chatModel);
            CustomAdapter adapter = new CustomAdapter(models,getApplicationContext());
            listView.setAdapter(adapter);
        }
    }
}
