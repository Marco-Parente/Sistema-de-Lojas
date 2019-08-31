
package sistema.de.lojas.domain.dao.list;

import java.util.ArrayList;
import java.util.List;
import sistema.de.lojas.domain.dao.IUsuarioDAO;
import sistema.de.lojas.domain.entities.Usuario;

public class UsuarioDAOImpl implements IUsuarioDAO {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void inserir(Usuario ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(usuarios.contains(ent)){
            throw new RuntimeException("Valor repetido.");
        }
        ent.setID(lastId);
        lastId++;
        usuarios.add(ent);
    }

    @Override
    public void atualizar(Usuario ent) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario get = usuarios.get(i);
            if(ent.getID() == get.getID()){
                if(!usuarios.contains(ent)){
                    usuarios.set(i, ent);
                }
            }
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario get = usuarios.get(i);
            if(get.getID() == id){
                usuarios.remove(i);
            }
            
        }
    }

    @Override
    public List<Usuario> consultar() {
        return usuarios;
    }
}
   
    