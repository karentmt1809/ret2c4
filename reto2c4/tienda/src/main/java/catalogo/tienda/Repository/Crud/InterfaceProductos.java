package catalogo.tienda.Repository.Crud;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import catalogo.tienda.Model.Productos;

/**
 *
 * @author karent_saenz
 */
public interface InterfaceProductos extends CrudRepository<Productos, Integer>{
    
    public Optional <Productos> findByReference(String reference);
    
    public void deleteByReference(String reference);
    
}
