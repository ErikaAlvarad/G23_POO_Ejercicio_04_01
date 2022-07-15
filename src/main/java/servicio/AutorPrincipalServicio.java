/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.AutorPrincipal;

/**
 *
 * @author erika
 */
public class AutorPrincipalServicio implements IAutorPrincipalServicio{

    private static List<AutorPrincipal> autorPrincipalList = new ArrayList<>();
    
    @Override
    public AutorPrincipal crear(AutorPrincipal autorPrincipal) {
        var autorBuscado=this.buscarPorCodigo(autorPrincipal.getCodigo());
        if(autorBuscado==null){
            this.autorPrincipalList.add(autorPrincipal);
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al autor: "+autorBuscado.getNombre());
        }
    return autorPrincipal;
    }

    @Override
    public List<AutorPrincipal> listar() {
        return this.autorPrincipalList;
    }

    @Override
    public AutorPrincipal buscarPorCodigo(int codigoAutorPrincipal) {
    
          AutorPrincipal autorPrincipal=null;
        for(var c:this.autorPrincipalList){
            if(codigoAutorPrincipal==c.getCodigo()){
                autorPrincipal=c;
                break;
            }
        }
        return autorPrincipal;
    }

  
    
    
}
