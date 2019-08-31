
package sistema.de.lojas.domain.dao.list;

import java.util.ArrayList;
import java.util.List;
import sistema.de.lojas.domain.dao.ILojaDAO;
import sistema.de.lojas.domain.entities.Loja;

public class LojaDAOImpl implements ILojaDAO {
    private static List<Loja> lojas = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void inserir(Loja ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(lojas.contains(ent)){
            throw new RuntimeException("Valor repetido.");
        }
        ent.setID(lastId);
        lastId++;
        lojas.add(ent);
    }

    @Override
    public void atualizar(Loja ent) {
        for (int i = 0; i < lojas.size(); i++) {
            Loja get = lojas.get(i);
            if(ent.getID() == get.getID()){
                if(!lojas.contains(ent)){
                    lojas.set(i, ent);
                }
            }
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < lojas.size(); i++) {
            Loja get = lojas.get(i);
            if(get.getID() == id){
                lojas.remove(i);
            }
            
        }
    }

    @Override
    public List<Loja> consultar() {
        return lojas;
    }
}
   
    