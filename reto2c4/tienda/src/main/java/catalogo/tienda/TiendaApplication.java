package catalogo.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author karent_saenz
 */

@SpringBootApplication
@EntityScan(basePackages = {"tienda.catalogo.tienda.Model"})
@ComponentScan(basePackages = {"tienda.catalogo.tienda"})
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

}
