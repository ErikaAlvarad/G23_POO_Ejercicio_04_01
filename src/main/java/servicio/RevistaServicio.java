/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Revista;

/**
 *
 * @author erika
 */
public class RevistaServicio implements IRevistaServicio{

    private static List<Revista> revistaList = new ArrayList<>();
    
    @Override
    public Revista crear(Revista revista) {
        var revistaBuscada=this.buscarPorCodigo(revista.getCodigo());
        if(revistaBuscada==null){
            this.revistaList.add(revista);
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado a la revista:  "+revistaBuscada.getNombre());
        }
        return revista;
    }

    @Override
    public List<Revista> listar() {
        return this.revistaList;
    }

    @Override
    public Revista buscarPorCodigo(int codigoRevista) {
        Revista revista=null;
        for(var c:this.revistaList){
            if(codigoRevista==c.getCodigo()){
                revista=c;
                break;
            }
        }
        return revista;
    }
    
}
