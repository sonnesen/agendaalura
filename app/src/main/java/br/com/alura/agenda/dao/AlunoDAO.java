package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno alunoCriado) {
        alunos.add(alunoCriado);
    }

    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }
}
