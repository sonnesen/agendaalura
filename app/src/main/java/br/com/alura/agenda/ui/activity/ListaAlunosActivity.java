package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity implements BaseActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener((view) -> {
            abreFormularioNovoAluno();
        });
    }

    private void abreFormularioNovoAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView alunosView = findViewById(R.id.activity_lista_alunos_listview);
        final List<Aluno> alunos = alunoDAO.getAll();
        configuraAdapter(alunosView, alunos);
        configuraListenerDeCliquePorItem(alunosView);
    }

    private void configuraListenerDeCliquePorItem(ListView alunosView) {
        alunosView.setOnItemClickListener((parent, view, position, id) -> {
            Aluno alunoSelecionado = (Aluno) parent.getItemAtPosition(position);
            abreFormularioAtualizaAluno(alunoSelecionado);
        });
    }

    private void abreFormularioAtualizaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }

    private void configuraAdapter(ListView alunosView, List<Aluno> alunos) {
        alunosView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alunos));
    }
}
