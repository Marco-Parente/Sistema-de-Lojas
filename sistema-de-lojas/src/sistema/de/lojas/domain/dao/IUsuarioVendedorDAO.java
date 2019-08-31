
package sistema.de.lojas.domain.dao;

import java.util.List;
import sistema.de.lojas.domain.entities.UsuarioVendedor;

public interface IUsuarioVendedorDAO {

    public void inserir(UsuarioVendedor usuariovendedor);

    public void atualizar(UsuarioVendedor usuariovendedor);

    public void remover(int id);

    public List<UsuarioVendedor> consultar();

}


    