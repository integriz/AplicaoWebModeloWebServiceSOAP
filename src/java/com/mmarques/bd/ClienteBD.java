package com.mmarques.bd;

import com.mmarques.vo.Cliente;
import java.util.ArrayList;
import java.util.List;

/*
  Esta classe tem o único objetivo de servir para o exemplo deste projeto que tem foco 
  nas formas de criar webservices SOAP e REST.
*/

public class ClienteBD {
    public List<Cliente> listar(){
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente(100, "João da Silva"));
        lista.add(new Cliente(200, "Ana Neri"));
        return lista;    
    }
   
   
}
