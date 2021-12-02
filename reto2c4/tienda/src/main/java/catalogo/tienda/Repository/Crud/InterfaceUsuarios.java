package catalogo.tienda.Repository.Crud;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import catalogo.tienda.Model.Usuarios;

/**
 *
 * @author karent_saenz
 */
public interface InterfaceUsuarios extends CrudRepository<Usuarios, Integer>{
    
    public Optional <Usuarios> findByEmail(String email);
    
    public Optional <Usuarios> findByEmailAndPassword(String email, String password);
}
