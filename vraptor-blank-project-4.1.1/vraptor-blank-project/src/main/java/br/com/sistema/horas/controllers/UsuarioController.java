package br.com.sistema.horas.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.sistema.horas.dao.UsuarioDao;
import br.com.sistema.horas.modelos.Usuario;

@Controller
public class UsuarioController{
    private Result result;
    private UsuarioDao usuarioDAO;
    private Validator validator;
    public UsuarioController(){}
    @Inject
    public UsuarioController(Result result, UsuarioDao usuarioDAO, Validator validator){
        this.result = result;
        this.usuarioDAO = usuarioDAO;
        this.validator = validator;
    }
    
   
    public void form(){}
    
    @IncludeParameters
    @Post
    public void adiciona(@Valid Usuario usuario){
        validator.onErrorRedirectTo(this).form();
        usuarioDAO.adiciona(usuario);
        result.redirectTo(this).lista();
    }
    public void lista(){
        result.include("usuarios", usuarioDAO.lista());
    }
}