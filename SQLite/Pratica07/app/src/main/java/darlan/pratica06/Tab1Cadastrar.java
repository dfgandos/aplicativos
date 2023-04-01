package natalia.pratica06;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class Tab1Cadastrar extends Fragment {

    private Button buttonSalvar;
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private EditText editTextEndereco;
    private Button buttonAtualizar;
    private Button buttonDeletar;
    private EditText editTextUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_cadastrar, container, false);
        buttonSalvar = (Button) rootView.findViewById(R.id.button_salvar_id);
        editTextNome = (EditText) rootView.findViewById(R.id.editText_nome_id);
        editTextEmail = (EditText) rootView.findViewById(R.id.editText_email_id);
        editTextTelefone = (EditText) rootView.findViewById(R.id.editText_telefone_id);
        editTextEndereco = (EditText) rootView.findViewById(R.id.editText_endereco_id);
        buttonAtualizar = (Button) rootView.findViewById(R.id.button_atualizar_id);
        buttonDeletar = (Button) rootView.findViewById((R.id.button_delete_id));
        editTextUserId = (EditText) rootView.findViewById(R.id.editText_iduser_id);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String telefone = editTextTelefone.getText().toString();
                String endereco = editTextEndereco.getText().toString();

                if ((nome != "") && (email != "")&& (telefone != "")&& (endereco != "")) {
                    Contato pessoa = new Contato(nome, email, telefone, endereco);
                    cadastrarUsuarios(pessoa);
                    Toast.makeText(getContext().getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                }

                editTextNome.setText("");
                editTextEmail.setText("");
                editTextTelefone.setText("");
                editTextEndereco.setText("");
            }
        });

        return rootView;
    }

    private void cadastrarUsuarios (Contato pessoa) {
        try {
            //Apaga o banco de dadados
            //getContext().getApplicationContext().deleteDatabase("bancoContatos");
            //definimos o nome e o modo do banco de dados.
            SQLiteDatabase bancoDeDados = getContext().getApplicationContext().openOrCreateDatabase("bancoContatos", MODE_PRIVATE, null);

            //criar tabela no banco de dados
            bancoDeDados.execSQL(" CREATE TABLE IF NOT EXISTS Contato(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, email VARCHAR, telefone VARCHAR, endereco VARCHAR) ");
            String insert = "INSERT INTO Contato " + "(nome, email, telefone, endereco) VALUES " + "('" + pessoa.getNome() + "','" + pessoa.getEmail() + "','" + pessoa.getTelefone() + "','" + pessoa.getEndereco() + "')";

            //inserir dados na tabela
            bancoDeDados.execSQL(insert);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
