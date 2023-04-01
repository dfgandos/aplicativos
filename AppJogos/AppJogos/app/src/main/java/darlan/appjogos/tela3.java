package natalia.appjogos;

import androidx.appcompat.app.AppCompatActivity;

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
    Button btnEnviar;

    private TextView txt1;
    private EditText editnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        txt1 = findViewById(R.id.text1);
        editnum = findViewById(R.id.editText);
        cont = 0;
        sorteado = gerador.nextInt(101);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        //Toast.makeText(getApplicationContext(),""+sorteado,Toast.LENGTH_LONG).show();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(editnum.getText().toString());
                cont++;

                if(num == sorteado){
                    txt1.setText("Acertou!!! Parabéns! \n Tentativas: "+ cont);
                }else{
                    txt1.setText("Errou! Continue tentando.");
                    editnum.setText("");
                }
            }
        });
    }
}
