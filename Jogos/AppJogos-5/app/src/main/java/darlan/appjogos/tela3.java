package natalia.appjogos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class tela3 extends AppCompatActivity {

    Random gerador = new Random();
    int sorteado;
    int cont;
    int num;
    int rank = 100;
    int rankk;
    Button btnEnviar;

    private static final String PREFERENCE = "filePreference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        cont = 0;
        sorteado = gerador.nextInt(101);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        Toast.makeText(getApplicationContext(),""+sorteado,Toast.LENGTH_LONG).show();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView txt1 = findViewById(R.id.text1);
                EditText editnum = findViewById(R.id.editText);
                TextView txtRank = findViewById(R.id.txtRank);
                num = Integer.parseInt(editnum.getText().toString());
                cont++;

                SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(num == sorteado){
                    txt1.setText("Acertou!!! Parabéns! \nTentativas: "+ cont);

                    if(cont < sharedPreferences.getInt("rank", rank)){
                        rank = cont;
                        editor.putInt("rank", rank);
                        editor.commit();
                    }

                }else{
                    txt1.setText("Errou! Continue tentando! \nTentativas: "+ cont);
                    editnum.setText("");
                }

                if(sharedPreferences.contains("rank")){
                    rankk = sharedPreferences.getInt("rank", rank);
                    txtRank.setText("Rank: " + rankk);
                }
            }
        });
    }
}
