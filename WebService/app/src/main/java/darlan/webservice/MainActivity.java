package natalia.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText edtCep;
    private EditText edtLogradouro;
    private EditText edtComplemento;
    private EditText edtBairro;
    private EditText edtCidade;
    private EditText edtUF;


    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference contaoDatabaseReference = databaseReference.child("Enderecos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCep = (EditText) findViewById(R.id.edtCepId);
        edtLogradouro = (EditText) findViewById(R.id.edtLogradouroId);
        edtComplemento = (EditText) findViewById(R.id.edtComplementoId);
        edtBairro = (EditText) findViewById(R.id.edtBairroId);
        edtCidade = (EditText) findViewById(R.id.edtCidadeId);
        edtUF = (EditText) findViewById(R.id.edtUFId);
    }

    // EXIBE UMA MENSAGEM TOAST PARA O USUÁRIO
    public void print(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    // PROCEDIMENTO PARA EXECUTAR O ONCLICK DO BOTÃO
    public void onClickPesquisar(View view) {
        String cep = edtCep.getText().toString();
        if (cep == null || cep.equals("")) {
            print("Obrigatório informar o CEP!");
        } else {
            WebServiceEndereco webServiceEndereco = new WebServiceEndereco();
            webServiceEndereco.execute(cep);
        }
    }

    public class WebServiceEndereco extends AsyncTask<String, Void, String> {
        // MÉTODO QUE FAZ A REQUISIÇÃO HTTP
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("https://viacep.com.br/ws/" + strings[0] + "/json/");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String linha;
                StringBuffer buffer = new StringBuffer();
                while ((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                    buffer.append("\n");
                }
                return buffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            return null;
        } // MÉTODO QUE CONFIGURA A RESPOSTA DO MÉTODO HTTP

        @Override
        protected void onPostExecute(String s) {
            if (s == null) print("Não foi possível recuperar os dados...");
            else {
                try {
                    JSONObject json = new JSONObject(s);
                    edtLogradouro.setText(json.getString("logradouro"));
                    edtComplemento.setText(json.getString("complemento"));
                    edtBairro.setText(json.getString("bairro"));
                    edtCidade.setText(json.getString("localidade"));
                    edtUF.setText(json.getString("uf"));
                    print("Endereço recuperado com sucesso!");

                    String cep = edtCep.getText().toString();
                    String logradouro = edtLogradouro.getText().toString();
                    String complemento = edtComplemento.getText().toString();
                    String bairro = edtBairro.getText().toString();
                    String cidade = edtCidade.getText().toString();
                    String uf = edtUF.getText().toString();

                    if (cep != ""){
                        Enderecos endereco = new Enderecos(cep);
                        endereco.setCep(cep);
                        endereco.setLogradouro(logradouro);
                        endereco.setComplemento(complemento);
                        endereco.setBairro(bairro);
                        endereco.setCidade(cidade);
                        endereco.setUf(uf);
                        salvarEndereco(endereco);
                        Toast.makeText(getApplicationContext(), "Endereço pesquisado com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        private void salvarEndereco(final Enderecos endereco) {
            contaoDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String cepEndereco = Base64.encodeToString(endereco.getCep().getBytes(), Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
                    endereco.setCep(cepEndereco);
                    boolean contatoJaCadastrado = dataSnapshot.hasChild(cepEndereco);
                    if (contatoJaCadastrado)
                        Toast.makeText(getApplicationContext(), "Endereco já pesquisado anteriormente.", Toast.LENGTH_SHORT).show();
                    else {
                        contaoDatabaseReference.child(cepEndereco).setValue(endereco);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }
    }
}