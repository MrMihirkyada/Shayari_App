package com.example.recyclerviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;

import java.io.IOException;
import java.util.Locale;

public class Edit_Activity extends AppCompatActivity
{

    TextView txtshayari;
    TextView txtCancel, txtshayaris;
    LinearLayout txtGallery, txtCamera;
    ImageView imgimage;
    SeekBar seekBar;
    //    Button btnbutton, btnbutton2, btnbutton3, btnbutton4;
    ImageButton imgShare, imgEdit;
    ImageButton btnDialog,btnspeek;
    TextToSpeech textToSpeak;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.Red));
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        toolbar();
    }

    private void toolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initview();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.myitem, menu);
        return true;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.setting) {
            txtshayaris.setTextColor(Color.WHITE);
            Toast.makeText(this, "White Color is Selected", Toast.LENGTH_SHORT).show();

            return true;
        } else if (id == R.id.rate) {
            txtshayaris.setTextColor(Color.BLACK);
            Toast.makeText(this, "Black Color is Selected", Toast.LENGTH_SHORT).show();

            return true;
        }
        if (id == R.id.review) {
            txtshayaris.setTextColor(Color.DKGRAY);
            Toast.makeText(this, "DarkGrey Color is Selected", Toast.LENGTH_SHORT).show();

            return true;
        } else if (id == R.id.profile) {
            txtshayaris.setTextColor(Color.RED);
            Toast.makeText(this, "Red Color is Selected", Toast.LENGTH_SHORT).show();

            return true;
        } else if (id == R.id.exit) {
            txtshayaris.setTextColor(Color.GREEN);
            Toast.makeText(this, "Green Color is Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color) {
            txtshayaris.setTextColor(Color.YELLOW);
            Toast.makeText(this, "Yellow Color is Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color2) {
            txtshayaris.setTextColor(Color.BLUE);
            Toast.makeText(this, "Blue Color is Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color3) {
            txtshayaris.setTextColor(Color.GRAY);
            Toast.makeText(this, "Grey Color is Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color4) {
            txtshayaris.setTextColor(Color.MAGENTA);
            Toast.makeText(this, "Magenta Color is Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void initview() {
        txtshayari = (TextView) findViewById(R.id.txtshayari);

//        btnbutton = (Button) findViewById(R.id.btnbutton);
//        btnbutton2 = (Button) findViewById(R.id.btnbutton2);
//        btnbutton3 = (Button) findViewById(R.id.btnbutton3);
//        btnbutton4 = (Button) findViewById(R.id.btnbutton4);

        seekBar = (SeekBar) findViewById(R.id.SeekBar);

        btnspeek = (ImageButton) findViewById(R.id.btnspeek);

        btnDialog = findViewById(R.id.btnDialog);
        imgShare = findViewById(R.id.imgShare);
        imgEdit = findViewById(R.id.imgEdit);
        txtshayaris = findViewById(R.id.txtshayaris);

        imgimage = findViewById(R.id.imgimage);

//        colorPickerView = findViewById(R.id.colorPickerView);

        Dialog dialog = new Dialog(Edit_Activity.this);

        Intent i = getIntent();
        String Shayari = i.getStringExtra("Shayari");
        txtshayaris.setText(Shayari);

        textToSpeak = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status)
            {
                if(status!=TextToSpeech.ERROR)
                {
                    textToSpeak.setLanguage(Locale.ENGLISH  );
                }
            }
        });

        btnspeek.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                textToSpeak.speak(Shayari.toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.custom_dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                txtGallery = dialog.findViewById(R.id.txtGallery);
                txtCamera = dialog.findViewById(R.id.txtCamera);
                txtCancel = dialog.findViewById(R.id.txtCancel);

                txtGallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent();
                        i.setType("image/*");
                        i.setAction(Intent.ACTION_GET_CONTENT);

                        startActivityForResult(Intent.createChooser(i, "Select Picture"), 100);

                        dialog.dismiss();
                    }
                });

                txtCamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(camera_intent, 101);

                        dialog.dismiss();
                    }
                });
                txtCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
//            private Uri imageUri;

            @Override
            public void onClick(View v) {
                String sharebody = Shayari;

//                imageUri = Uri.parse("android.resource://"+ getPackageName() + "/drawable/"+"add");

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
//                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

                intent.putExtra(Intent.EXTRA_TEXT, sharebody);
//                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });


//        btnbutton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                txtshayaris.setTextColor(Color.WHITE);
////              txtshayaris.setTextColor(Color.BLUE);
////              txtshayaris.setTextColor(Color.GREEN);
////              txtshayaris.setTextColor(Color.GRAY);
////              txtshayaris.setTextColor(Color.DKGRAY);
////              txtshayaris.setTextColor(Color.MAGENTA);
////              txtshayaris.setTextColor(Color.YELLOW);
////              txtshayaris.setTextColor(Color.WHITE);
//            }
//        });
//        btnbutton2.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                txtshayaris.setTextColor(Color.BLUE);
//            }
//        });
//        btnbutton3.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                txtshayaris.setTextColor(Color.BLACK);
//            }
//        });
//
//        btnbutton4.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                txtshayaris.setTextColor(Color.DKGRAY);
//            }
//        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seebbarValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtshayaris.setTextSize(progress + 10);
                seebbarValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Text Size:- " + seebbarValue, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK)
        {
            if (data != null && data.getData() != null)
            {
                Uri selectedImageUri = data.getData();
                Bitmap selectedImageBitmap = null;
                try
                {
                    selectedImageBitmap
                            = MediaStore.Images.Media.getBitmap(
                            this.getContentResolver(),
                            selectedImageUri);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                imgimage.setImageBitmap(selectedImageBitmap);
            }
        }
        else if (requestCode == 101 && resultCode == RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            imgimage.setImageBitmap(photo);
        }

    }

}