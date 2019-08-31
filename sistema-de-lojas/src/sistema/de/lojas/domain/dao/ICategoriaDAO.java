
package sistema.de.lojas.domain.dao;

import java.util.List;
import sistema.de.lojas.domain.entities.Categoria;

public interface ICategoriaDAO {

    public void inserir(Categoria categoria);

    public void atualizar(Categoria categoria);

    public void remover(int id);

    public List<Categoria> consultar();

}


    