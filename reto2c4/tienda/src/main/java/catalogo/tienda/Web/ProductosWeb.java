package catalogo.tienda.Web;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import catalogo.tienda.Model.Productos;
import catalogo.tienda.Service.ServiceProductos;

/**
 *
 * @author karent_saenz
 */
@RestController
@Transactional
@RequestMapping("/api/fragance")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductosWeb {
    @Autowired
    
    private ServiceProductos serProductos;
    
    @GetMapping("/all")
    public List<Productos> getProducto(){
        return serProductos.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Productos> getProducto(@PathVariable("reference") String reference){
        return serProductos.getProducto(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos save(@RequestBody Productos productos){
        return serProductos.save(productos);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos update(@RequestBody Productos productos){
        return serProductos.update(productos);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return serProductos.delete(reference);
    }
}


