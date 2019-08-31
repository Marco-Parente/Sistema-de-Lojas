
package sistema.de.lojas.domain.dao;

import java.util.List;
import sistema.de.lojas.domain.entities.Vendedor;

public interface IVendedorDAO {

    public void inserir(Vendedor vendedor);

    public void atualizar(Vendedor vendedor);

    public void remover(int id);

    public List<Vendedor> consultar();

}


    