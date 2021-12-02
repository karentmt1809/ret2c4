package catalogo.tienda.Repository;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import catalogo.tienda.Model.Productos;
import catalogo.tienda.Repository.Crud.InterfaceProductos;

/**
 *
 * @author karent_saenz
 */
@Repository
public class RepositoryProductos {
    @Autowired
    private InterfaceProductos crProductos;
    
    public List<Productos> getAll(){
        return (List<Productos>) crProductos.findAll();
    }
    
    public Optional <Productos> getProducto(String reference){
        return crProductos.findByReference(reference);
    }
    
    public Productos save(Productos productos){
        return crProductos.save(productos);
    }
    
    public void delete(String reference){
        crProductos.deleteByReference(reference);
    }
}
