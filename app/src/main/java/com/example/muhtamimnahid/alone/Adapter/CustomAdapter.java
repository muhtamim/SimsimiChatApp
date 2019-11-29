package com.example.muhtamimnahid.alone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.muhtamimnahid.alone.Models.ChatModel;
import com.example.muhtamimnahid.alone.R;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<ChatModel> list_Chat_models;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<ChatModel> list_Chat_models, Context context) {
        this.list_Chat_models = list_Chat_models;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_Chat_models.size();
    }

    @Override
    public Object getItem(int i) {
        return list_Chat_models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            if (list_Chat_models.get(i).isSend)
                view = layoutInflater.inflate(R.layout.list_item_message_send, null);
        } else {
            view = layoutInflater.inflate(R.layout.list_item_message_recv, null);

            BubbleTextView text_message = (BubbleTextView) view.findViewById(R.id.text_message);
            text_message.setText(list_Chat_models.get(i).message);

        }

        return view;
    }
}
