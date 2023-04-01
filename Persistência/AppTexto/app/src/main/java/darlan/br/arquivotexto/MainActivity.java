package pucminas.br.arquivotexto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button botaoSalvar;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaAtributos();
        botaoSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                alteraCorTexto();
                String texto = editText.getText().toString();
                //o arquivo texto fica armazenado dentro da estrutura de pastas do Android
                salvaArquivo(texto);
                Toast.makeText(MainActivity.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
        if(abreArquivo()!=null)
            editText.setText(abreArquivo());
    }
    private void inicializaAtributos(){
        editText = (EditText) findViewById(R.id.multiline_texto_id);
        botaoSalvar = (Button) findViewById(R.id.button_salvar_id);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);
    }
    private void alteraCorTexto(){
        int idRadioButton = radioGroup.getCheckedRadioButtonId();
        if(idRadioButton>0){
            radioButton = (RadioButton) findViewById(idRadioButton);
            String textoRadioButton = radioButton.getText().toString();
            if(textoRadioButton.equals("Azul"))
                editText.setTextColor(Color.parseColor("#FF3F51B5"));
            else
                editText.setTextColor(Color.parseColor("#FFCC0000"));
        }
    }
    private void salvaArquivo(String texto){
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("blocoDeNotas.txt", Context.MODE_PRIVATE));

            outputStreamWriter.write(texto);
            outputStreamWriter.close();
        }catch (IOException e){
            Log.v("MainActivity",e.toString());
        }
    }
    private String abreArquivo(){
        String textoFinal="";
        try{
            InputStream arquivo = openFileInput("blocoDeNotas.txt");
            if(arquivo!=null){
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line ="";
                while((line = bufferedReader.readLine())!=null){
                    textoFinal+=line+"\n";
                }
                arquivo.close();
            }
        }catch (IOException e){
            Log.v("MainActivity",e.toString());
        }
        return textoFinal;
    }
}
