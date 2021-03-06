package org.example.project.api.projetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjetoRepository {
    List<Projeto> projetos = new ArrayList<>();

    public Projeto save(Projeto projeto) {
        this.projetos.add(projeto);
        return projeto;
    }

    public List<Projeto> getAll() {
        return this.projetos;
    }

    public Projeto getById(int id) {
        return this.projetos.stream()
                .filter(projeto -> projeto.getCodigo() == id)
                .findAny()
                .orElse(null);
    }

    public Projeto update(Projeto newProjeto) {
        Projeto projetoFound = this.getById(newProjeto.getCodigo());
        projetos.set(projetos.indexOf(projetoFound), newProjeto);
        return newProjeto;
    }

    public void delete(Projeto projeto) {
        projetos.remove(projeto);
    }
}
