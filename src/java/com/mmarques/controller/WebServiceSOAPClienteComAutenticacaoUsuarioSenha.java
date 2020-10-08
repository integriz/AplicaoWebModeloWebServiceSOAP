package com.mmarques.controller;

import com.mmarques.bd.ClienteBD;
import com.mmarques.vo.Cliente;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/*
    Webservice SOAP utilizando Java 8 e annotations (JAX-WS)
    Com autenticação de usuário e senha no header.
    Caso não quiser autenticar é só remover o método autenticado.
*/

@WebService
public class WebServiceSOAPClienteComAutenticacaoUsuarioSenha {
    private final ClienteBD clienteBD;
    @Resource
    private WebServiceContext wsctx;
    
    public WebServiceSOAPClienteComAutenticacaoUsuarioSenha() {
        clienteBD = new ClienteBD();
    }
    
   
    @WebMethod
    public List<Cliente> listar() throws Exception{
        if(autenticado()){
            return clienteBD.listar();
        }else{
           throw new Exception("Erro na autenticação!");
        }
    }
    
    private boolean autenticado(){
        MessageContext mctx = wsctx.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List usuarios = (List) http_headers.get("Username");
        List senhas = (List) http_headers.get("Password");
        
        String usuario = "";
        String senha = "";
        
        if(usuarios!=null) usuario = usuarios.get(0).toString();
        if(senhas!=null) senha = senhas.get(0).toString();
        
        return usuario.equals("marcos") && senha.equals("123");
    }
}
