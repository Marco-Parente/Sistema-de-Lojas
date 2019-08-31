
package sistema.de.lojas.domain.dao.list;

import java.util.ArrayList;
import java.util.List;
import sistema.de.lojas.domain.dao.ICategoriaDAO;
import sistema.de.lojas.domain.entities.Categoria;

public class CategoriaDAOImpl implements ICategoriaDAO {
    private static List<Categoria> categorias = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void inserir(Categoria ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(categorias.contains(ent)){
            throw new RuntimeException("Valor repetido.");
        }
        ent.setID(lastId);
        lastId++;
        categorias.add(ent);
    }

    @Override
    public void atualizar(Categoria ent) {
        for (int i = 0; i < categorias.size(); i++) {
            Categoria get = categorias.get(i);
            if(ent.getID() == get.getID()){
                if(!categorias.contains(ent)){
                    categorias.set(i, ent);
                }
            }
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < categorias.size(); i++) {
            Categoria get = categorias.get(i);
            if(get.getID() == id){
                categorias.remove(i);
            }
            
        }
    }

    @Override
    public List<Categoria> consultar() {
        return categorias;
    }
}
   
    