package natalia.pratica06;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Tab2Listar extends Fragment {

    private ListView listView;
    private Button botaoAtualizar;
    private ArrayAdapter<Contato> adapter;
    private List<Contato> contatos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_listar, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView_id);
        botaoAtualizar = (Button) rootView.findViewById(R.id.button_atualizar_id);
        contatos = recuperarUsuarios();
        adapter = new ArrayAdapter<Contato>(getContext().getApplicationContext(), android.R.layout.simple_list_item_1, contatos);
        //O listView não pode adicionar um tipo List, mas podemos adicionar um tipo adapter (que contem nossa lista de contatos)
        listView.setAdapter(adapter);
        botaoAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatos = recuperarUsuarios();
                adapter = new ArrayAdapter<Contato>(getContext().getApplicationContext(), android.R.layout.simple_list_item_1, contatos);
                listView.setAdapter(adapter);
            }
        });
        return rootView;
    }

    private List<Contato> recuperarUsuarios() {
        Contato contato;
        List<Contato> contatos = new ArrayList<Contato>();
        try {
            SQLiteDatabase bancoDeDados = getContext().getApplicationContext().openOrCreateDatabase("bancoContatos", MODE_PRIVATE, null);
            //recuperar dados da tabela
            Cursor cursor = bancoDeDados.rawQuery("SELECT id, nome, email, telefone, endereco FROM Contato", null);

            //recuperando o índice das colunas (o primeiro campo é 0, o segundo é 1)
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");
            int indiceEndereco = cursor.getColumnIndex("endereco");


            //o cursos se move do primeiro item ao último a medida em que a leitura ocorre
            cursor.moveToFirst();

            while (cursor != null) {
                contato = new Contato(cursor.getString(indiceNome), cursor.getString(indiceEmail), cursor.getString(indiceTelefone), cursor.getString(indiceEndereco));
                contato.setId(Integer.parseInt(cursor.getString(indiceId)));
                contatos.add(contato);
                contato = null;
                cursor.moveToNext();
                //move para o próximo registro
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contatos;
    }
}