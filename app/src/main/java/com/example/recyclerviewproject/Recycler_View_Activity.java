package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerviewproject.MyAdapter.MyCustomAdapter;
import com.example.recyclerviewproject.MyInterface.MyClickInterface;

import java.util.ArrayList;

public class Recycler_View_Activity extends AppCompatActivity {
    ArrayList<String> shayariList = new ArrayList<>();
    RecyclerView recyclerView;
    TextView txtshayari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initview();
    }

    private void initview() {
        recyclerView = findViewById(R.id.recyclerview);

        txtshayari = (TextView) findViewById(R.id.txtshayari);

        shayariList.add("na koi kisi se door hota hai\n" + "na koi kisi ke krib hota hai\n" +
                "wo khud he chal ke aata hai\n" + "jo jiska nasib hota hai");

        shayariList.add("If you ever get tired, then tell us, \n" + "We'll lift you up in our arms, \n" +
                "If you fall in love with us once, \n" + "We will spread happiness in your path.");

        shayariList.add("Your eyes are like the stars in the sky\n" + "Your lips are like the honey, so sweet\n" +
                "Your voice is like the music to my ears\n" + "Your touch is like the warmth I need");

        shayariList.add("तेरी मुस्कुराहट मेरी पहचान है,\n" + "तेरी खुशी मेरी शान है कुछ भी नही मेरी जिंदगी में,\n" + "बस इतना समझ ले तू ही मेरी जान है।");

        shayariList.add("I don't need any words to say\n" + "What you mean to me every day" +
                "You are my soul, my heart, my life" + "You are my everything, my love, my wife");

        shayariList.add("nigaho mein aur koi pyaar ke kabil na rahe," + "is smandar ka aur koi sahil na rahe,\n" +
                "chand jaisa yaar mila hume zamin par,\n" + "asman ka chand bi ab didar ke kabil na rahe........");

        shayariList.add("Because of your smile,\n" + "your make your life more beautiful.\n");

        shayariList.add("Change your life today.\n" + "Don't gamble your future,\n" + "act now without delay.\n");

        shayariList.add("You make me laugh when I am sad\n" + "You make me strong when I am weak\n" +
                "You make me brave when I am scared\n" + "You make me whole when I am incomplete");

        shayariList.add("तेरी मुस्कुराहट मेरी पहचान है,\n" + "तेरी खुशी मेरी शान है कुछ भी नही मेरी जिंदगी में,\n" + "बस इतना समझ ले तू ही मेरी जान है।");

        shayariList.add("I don't need any words to say\n" + "What you mean to me every day" +
                "You are my soul, my heart, my life" + "You are my everything, my love, my wife");

        shayariList.add("nigaho mein aur koi pyaar ke kabil na rahe," + "is smandar ka aur koi sahil na rahe,\n" +
                "chand jaisa yaar mila hume zamin par,\n" + "asman ka chand bi ab didar ke kabil na rahe........");

        shayariList.add("na koi kisi se door hota hai\n" + "na koi kisi ke krib hota hai\n" +
                "wo khud he chal ke aata hai\n" + "jo jiska nasib hota hai");

        shayariList.add("If you ever get tired, then tell us, \n" + "We'll lift you up in our arms, \n" +
                "If you fall in love with us once, \n" + "We will spread happiness in your path.");

        shayariList.add("Your eyes are like the stars in the sky\n" + "Your lips are like the honey, so sweet\n" +
                "Your voice is like the music to my ears\n" + "Your touch is like the warmth I need");

        shayariList.add("तेरी मुस्कुराहट मेरी पहचान है,\n" + "तेरी खुशी मेरी शान है कुछ भी नही मेरी जिंदगी में,\n" + "बस इतना समझ ले तू ही मेरी जान है।");

        shayariList.add("I don't need any words to say\n" + "What you mean to me every day" +
                "You are my soul, my heart, my life" + "You are my everything, my love, my wife");

        shayariList.add("nigaho mein aur koi pyaar ke kabil na rahe," + "is smandar ka aur koi sahil na rahe,\n" +
                "chand jaisa yaar mila hume zamin par,\n" + "asman ka chand bi ab didar ke kabil na rahe........");

        shayariList.add("Because of your smile,\n" + "your make your life more beautiful.\n");

        shayariList.add("Change your life today.\n" + "Don't gamble your future,\n" + "act now without delay.\n");

        shayariList.add("You make me laugh when I am sad\n" + "You make me strong when I am weak\n" +
                "You make me brave when I am scared\n" + "You make me whole when I am incomplete");

        shayariList.add("तेरी मुस्कुराहट मेरी पहचान है,\n" + "तेरी खुशी मेरी शान है कुछ भी नही मेरी जिंदगी में,\n" + "बस इतना समझ ले तू ही मेरी जान है।");

        shayariList.add("I don't need any words to say\n" + "What you mean to me every day" +
                "You are my soul, my heart, my life" + "You are my everything, my love, my wife");

        shayariList.add("nigaho mein aur koi pyaar ke kabil na rahe," + "is smandar ka aur koi sahil na rahe,\n" +
                "chand jaisa yaar mila hume zamin par,\n" + "asman ka chand bi ab didar ke kabil na rahe........");

        MyClickInterface myClickInterface1 = new MyClickInterface()
        {
            @Override
            public void ClickShare(String edit, int position)
            {
                String sharebody = shayariList.get(position);

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

                intent.putExtra(Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(intent, "Share Via"));
            }

            @Override
            public void ClickCopy(String edit, int position)
            {
                Toast.makeText(Recycler_View_Activity.this, "Copied", Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", shayariList.get(position));
                clipboard.setPrimaryClip(clip);
            }

            @Override
            public void ClickEdit(String edit, int position)
            {
                Intent i = new Intent(Recycler_View_Activity.this, Edit_Activity.class);
                i.putExtra("Shayari",shayariList.get(position));
                startActivity(i);
            }
        };


        MyCustomAdapter adapter = new MyCustomAdapter(shayariList,myClickInterface1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }
}