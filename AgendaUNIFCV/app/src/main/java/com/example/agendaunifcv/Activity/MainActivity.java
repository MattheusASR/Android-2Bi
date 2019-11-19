package com.example.agendaunifcv.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


//com.example.agendaunifcv.Adapter.TarefaAdapter;
import com.example.agendaunifcv.Adapter.TarefaAdapter;
import com.example.agendaunifcv.Helper.DBHelper;
import com.example.agendaunifcv.Helper.TarefaDAO;
import com.example.agendaunifcv.Model.Tarefa;
import com.example.agendaunifcv.R;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configurando RecyclerView
        recyclerView = findViewById(R.id.recyclerView1);
        DBHelper db = new DBHelper(getApplicationContext());
        ContentValues cv = new ContentValues();
        cv.put("nome", R.id.id_nomecontato);
        db.getWritableDatabase().insert("tarefas", "Nome", cv);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarContatoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaContatos(){

        //Listagem dos Atributos dos contatos

        //Exibe a lista de Contatos
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();

        //Adapter
        tarefaAdapter = new TarefaAdapter(listaTarefas);

        //RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(tarefaAdapter);
    }

    @Override
    protected void onStart() {

        carregarListaContatos();
        super.onStart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Salvar) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}






