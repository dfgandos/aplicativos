package natalia.appjogos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class tela2 extends AppCompatActivity {

    private ImageView imageCat;
    private ImageView imageCow;
    private ImageView imageApe;
    private ImageView imageDog;
    private ImageView imageDuck;
    private ImageView imageElephant;
    private ImageView imageHorse;
    private ImageView imageLion;
    private ImageView imageMoose;
    private ImageView imageOwl;
    private ImageView imagePig;
    private ImageView imageRooster;
    private ImageView imageSheep;
    private ImageView imageTiger;
    private ImageView imageTurkey;
    private ImageView imageZebra;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        imageCat = findViewById(R.id.image_cat);
        imageCow = findViewById(R.id.image_cow);
        imageApe = findViewById(R.id.image_ape);
        imageDog = findViewById(R.id.image_dog);
        imageDuck = findViewById(R.id.image_duck);
        imageElephant = findViewById(R.id.image_elephant);
        imageHorse = findViewById(R.id.image_horse);
        imageLion = findViewById(R.id.image_lion);
        imageMoose = findViewById(R.id.image_moose);
        imageOwl = findViewById(R.id.image_owl);
        imagePig = findViewById(R.id.image_pig);
        imageRooster = findViewById(R.id.image_rooster);
        imageSheep = findViewById(R.id.image_sheep);
        imageTiger = findViewById(R.id.image_tiger);
        imageTurkey = findViewById(R.id.image_turkey);
        imageZebra = findViewById(R.id.image_zebra);

        imageCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.cat);
                mediaPlayer.start();
            }
        });

        imageCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.cow);
                mediaPlayer.start();
            }
        });

        imageApe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.ape);
                mediaPlayer.start();
            }
        });

        imageDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.dog);
                mediaPlayer.start();
            }
        });

        imageDuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.duck);
                mediaPlayer.start();
            }
        });


        imageElephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.elephant);
                mediaPlayer.start();
            }
        });


        imageHorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.horse);
                mediaPlayer.start();
            }
        });


        imageLion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.lion);
                mediaPlayer.start();
            }
        });


        imageMoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.moose);
                mediaPlayer.start();
            }
        });


        imageOwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.owl);
                mediaPlayer.start();
            }
        });


        imagePig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.pig);
                mediaPlayer.start();
            }
        });


        imageRooster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.rooster);
                mediaPlayer.start();
            }
        });


        imageSheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.sheep);
                mediaPlayer.start();
            }
        });


        imageTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.tiger);
                mediaPlayer.start();
            }
        });


        imageTurkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.turkey);
                mediaPlayer.start();
            }
        });


        imageZebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(tela2.this, R.raw.zebra);
                mediaPlayer.start();
            }
        });



    }
}
