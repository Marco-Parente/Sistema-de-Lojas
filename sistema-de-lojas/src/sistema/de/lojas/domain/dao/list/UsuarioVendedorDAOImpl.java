
package sistema.de.lojas.domain.dao.list;

import java.util.ArrayList;
import java.util.List;
import sistema.de.lojas.domain.dao.IUsuarioVendedorDAO;
import sistema.de.lojas.domain.entities.UsuarioVendedor;

public class UsuarioVendedorDAOImpl implements IUsuarioVendedorDAO {
    private static List<UsuarioVendedor> usuarioVendedores = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void inserir(UsuarioVendedor ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(usuarioVendedores.contains(ent)){
            throw new RuntimeException("Valor repetido.");
        }
        ent.setID(lastId);
        lastId++;
        usuarioVendedores.add(ent);
    }

    @Override
    public void atualizar(UsuarioVendedor ent) {
        for (int i = 0; i < usuarioVendedores.size(); i++) {
            UsuarioVendedor get = usuarioVendedores.get(i);
            if(ent.getID() == get.getID()){
                if(!usuarioVendedores.contains(ent)){
                    usuarioVendedores.set(i, ent);
                }
            }
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < usuarioVendedores.size(); i++) {
            UsuarioVendedor get = usuarioVendedores.get(i);
            if(get.getID() == id){
                usuarioVendedores.remove(i);
            }
            
        }
    }

    @Override
    public List<UsuarioVendedor> consultar() {
        return usuarioVendedores;
    }
}
   
    