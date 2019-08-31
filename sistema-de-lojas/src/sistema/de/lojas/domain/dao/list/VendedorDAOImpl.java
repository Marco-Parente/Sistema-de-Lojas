
package sistema.de.lojas.domain.dao.list;

import java.util.ArrayList;
import java.util.List;
import sistema.de.lojas.domain.dao.IVendedorDAO;
import sistema.de.lojas.domain.entities.Vendedor;

public class VendedorDAOImpl implements IVendedorDAO {
    private static List<Vendedor> vendedores = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void inserir(Vendedor ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(vendedores.contains(ent)){
            throw new RuntimeException("Valor repetido.");
        }
        ent.setID(lastId);
        lastId++;
        vendedores.add(ent);
    }

    @Override
    public void atualizar(Vendedor ent) {
        for (int i = 0; i < vendedores.size(); i++) {
            Vendedor get = vendedores.get(i);
            if(ent.getID() == get.getID()){
                if(!vendedores.contains(ent)){
                    vendedores.set(i, ent);
                }
            }
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < vendedores.size(); i++) {
            Vendedor get = vendedores.get(i);
            if(get.getID() == id){
                vendedores.remove(i);
            }
            
        }
    }

    @Override
    public List<Vendedor> consultar() {
        return vendedores;
    }
}
   
    