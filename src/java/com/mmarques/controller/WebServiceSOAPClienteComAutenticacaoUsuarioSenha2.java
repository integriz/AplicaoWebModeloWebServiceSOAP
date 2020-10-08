package com.mmarques.controller;

import com.mmarques.bd.ClienteBD;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

/*
    Webservice SOAP utilizando Java 8 e annotations (JAX-WS)
    Com autenticação de usuário e senha no header.
    Caso não quiser autenticar é só remover o método autenticado.
*/

@WebService
public class WebServiceSOAPClienteComAutenticacaoUsuarioSenha2 {
    private final ClienteBD clienteBD;
    @Resource
    private WebServiceContext wsctx;
    
    public WebServiceSOAPClienteComAutenticacaoUsuarioSenha2() {
        clienteBD = new ClienteBD();
    }
    
    @WebMethod
    public String eco(@WebParam(name="parametro1",header = false) String parametro1,
                      @WebParam(name="Username", header = true) String usuario,
                      @WebParam(name = "Password", header = true) String senha) throws Exception{
        
        if(autenticado(usuario,senha)){
            return "Você digitou " + parametro1;
        }else{
           throw new Exception("Erro na autenticação!");
        }
    }
    
    private boolean autenticado(String usuario,String senha){
        return usuario.equals("marcos") && senha.equals("123");
    }
}
