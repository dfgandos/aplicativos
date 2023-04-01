package natalia.pratica06;

import android.database.Cursor;
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

public class Tab3Atualizar extends Fragment {

    private Button buttonBuscar;
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private EditText editTextEndereco;
    private Button buttonAtualizar;
    private Button buttonDeletar;
    private EditText editTextUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3_atualizar, container, false);
        buttonBuscar = (Button) rootView.findViewById(R.id.button_buscar_id);
        editTextNome = (EditText) rootView.findViewById(R.id.editText_nome_id);
        editTextEmail = (EditText) rootView.findViewById(R.id.editText_email_id);
        editTextTelefone = (EditText) rootView.findViewById(R.id.editText_telefone_id);
        editTextEndereco = (EditText) rootView.findViewById(R.id.editText_endereco_id);
        buttonAtualizar = (Button) rootView.findViewById(R.id.button_atualizar_id1);
        buttonDeletar = (Button) rootView.findViewById((R.id.button_delete_id));
        editTextUserId = (EditText) rootView.findViewById(R.id.editText_iduser_id);
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editTextUserId.getText().toString());
                Contato contato = recuperarUsuarios(id);
                if (contato != null) {
                    editTextNome.setText(contato.getNome());
                    editTextEmail.setText(contato.getEmail());
                    editTextTelefone.setText(contato.getTelefone());
                    editTextEndereco.setText(contato.getEndereco());
                } else
                    Toast.makeText(getContext().getApplicationContext(), "Usuário não encontrado.", Toast.LENGTH_SHORT).show();
            }
        });
        buttonAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String telefone = editTextTelefone.getText().toString();
                String endereco = editTextEndereco.getText().toString();
                int id = Integer.parseInt(editTextUserId.getText().toString());
                Contato contato = new Contato(nome, email, telefone, endereco);
                contato.setId(id);
                atualizaUsuarios(contato);
                Toast.makeText(getContext().getApplicationContext(), "Atualizado com sucesso", Toast.LENGTH_SHORT).show();
                editTextNome.setText("");
                editTextEmail.setText("");
                editTextTelefone.setText("");
                editTextEndereco.setText("");
            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editTextUserId.getText().toString());
                deleteUsuarios(id);
                Toast.makeText(getContext().getApplicationContext(), "Excluído com sucesso", Toast.LENGTH_SHORT).show();
                editTextNome.setText("");
                editTextEmail.setText("");
                editTextTelefone.setText("");
                editTextEndereco.setText("");

            }
        });
        return rootView;
    }

    private Contato recuperarUsuarios(int id) {
        Contato contato = null;
        try {
            SQLiteDatabase bancoDeDados = getContext().getApplicationContext().openOrCreateDatabase("bancoContatos", MODE_PRIVATE, null);
            Cursor cursor = bancoDeDados.rawQuery("SELECT id, nome, email, telefone, endereco FROM Contato WHERE id = " + String.valueOf(id), null);
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");
            int indiceEndereco = cursor.getColumnIndex("endereco");
            cursor.moveToFirst();
            while (cursor != null) {
                contato = new Contato(cursor.getString(indiceNome), cursor.getString(indiceEmail), cursor.getString(indiceTelefone), cursor.getString(indiceEndereco));
                contato.setId(Integer.parseInt(cursor.getString(indiceId)));
                cursor.moveToNext(); //move para o próximo registro
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contato;
    }

    private void atualizaUsuarios(Contato contato) {
        try {
            SQLiteDatabase bancoDeDados = getContext().getApplicationContext().openOrCreateDatabase("bancoContatos", MODE_PRIVATE, null);
            String update = "UPDATE Contato " + "SET nome = '" + contato.getNome() + "', " + "email = '" + contato.getEmail() + "', " + "telefone = '" + contato.getTelefone() + "', " + "Endereco = '" + contato.getEndereco() + "' " + "WHERE id = " + contato.getId();
            bancoDeDados.execSQL(update);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteUsuarios(int id) {
        try {
            SQLiteDatabase bancoDeDados = getContext().getApplicationContext().openOrCreateDatabase("bancoContatos", MODE_PRIVATE, null);
            String delete = "DELETE FROM Contato " + "WHERE id = " + id;
            bancoDeDados.execSQL(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
