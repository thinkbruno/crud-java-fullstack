package com.usuario.crud.controller;

import com.usuario.crud.model.Usuario;
import com.usuario.crud.repository.UsuarioRepository;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Component
public class UsuarioController implements Serializable {

    @Autowired
    private UsuarioRepository repository;

    @Getter @Setter
    private Usuario usuario = new Usuario();

    @Getter @Setter
    private List<Usuario> usuarios;


    public void init() {
        listar();
    }

    public void salvar() {
        repository.save(usuario);
        usuario = new Usuario(); // Limpa o formulário
        listar(); // Atualiza a lista
    }

    public void listar() {
        usuarios = repository.findAll();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
        listar();
    }

    public void prepararEdicao(Usuario selecionado) {
        this.usuario = selecionado;
    }
}