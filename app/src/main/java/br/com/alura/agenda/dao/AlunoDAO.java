package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private final static Map<Long, Aluno> alunos = new HashMap<>();
    private static Long contadorID = 1L;

    public void cria(Aluno alunoCriado) {
        alunoCriado.setId(contadorID);
        alunos.put(contadorID, alunoCriado);
        contadorID++;
    }

    public void atualiza(Aluno aluno) {
        if (alunos.containsKey(aluno.getId())) {
            alunos.put(aluno.getId(), aluno);
        }
    }

    public List<Aluno> getAll() {
        return new ArrayList<>(alunos.values());
    }
}
