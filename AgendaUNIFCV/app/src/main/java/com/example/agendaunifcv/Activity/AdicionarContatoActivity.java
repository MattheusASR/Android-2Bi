package com.example.agendaunifcv.Activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.agendaunifcv.Helper.TarefaDAO;
import com.example.agendaunifcv.Model.Tarefa;
import com.example.agendaunifcv.R;

public class AdicionarContatoActivity extends AppCompatActivity {

    private TextInputEditText editNome;
    private TextInputEditText editEndereco;
    private TextInputEditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_contato);

        editNome = findViewById(R.id.id_nomecontato);
        editEndereco = findViewById(R.id.id_enderecocontato);
        editEmail = findViewById(R.id.id_emailcontato);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Salvar:
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                Tarefa tarefa = new Tarefa();
                tarefaDAO.salvar(tarefa);


        }

                return super.onOptionsItemSelected(item);
        }


    }








