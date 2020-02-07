package com.listacompra.demoWeb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import com.listacompra.demoWeb.model.Producto;
import com.listacompra.demoWeb.repo.IListacomprarepo;


@Controller
public class ListarController {

	@Autowired
	private IListacomprarepo repo;

	@GetMapping("/listar")
	public String greeting(Model model) {
	//logica

     model.addAttribute("personas", repo.findAll());
     model.addAttribute("prdflt", repo.findByDescripcion("AVENA INTEGRAL SUAVE"));
	
	System.out.println("Este comentario ocurre antes del error de thymeleaf ***** ");
	
	/* articulo.setNombre_producto("carne de res");
    articulo.setDescripcion("carne picada para hamburguesa");
    articulo.setComprar(true);
    articulo.setId_producto(8);
    repo.save(articulo);
	*/
    //hacer un ciclo for each aqui para ver si funciona

	
 for (Object i: repo.findAll()) {
  System.out.println (i); //Muestra cada uno de los nombres dentro de listaDeNombres


}
return "listar";
}
	
	@GetMapping("/comprar")
	public String compra(Model model) {
     model.addAttribute("compra", repo.findByComprar(true));
    
return "comprar";
}
	
	@GetMapping("/nocomprar")
	public String nocomprar(Model model) {
     model.addAttribute("nocomprar", repo.findByComprar(false));

return "nocomprar";
}
	
	@GetMapping("/insertar")
	public String insertar(Model model) {
     Producto articulo= new Producto();
     articulo.setNombre_producto("NARANJA");
     articulo.setDescripcion("FRUTAS FRESCAS");
     articulo.setComprar(true);
     articulo.setId_producto(8);
     articulo.setIdTipoproducto(6);
     repo.save(articulo);
     
     Producto articulo1= new Producto();
     articulo1.setNombre_producto("QUESO CREMA CAMBIADO");
     articulo1.setDescripcion("QUESO PARA UNTAR LA VACA QUE RIE");
     articulo1.setComprar(true);
     articulo1.setId_producto(1);
     articulo1.setIdTipoproducto(1);
     repo.save(articulo1);
     Producto articulo2= new Producto();
     articulo2.setNombre_producto("MANDARINA");
     articulo2.setDescripcion("FRUTAS FRESCAS");
     articulo2.setComprar(true);
     articulo2.setId_producto(9);
     articulo2.setIdTipoproducto(6);
     repo.save(articulo2);
     Producto articulo3= new Producto();
     articulo3.setNombre_producto("PICADILLO CURADO");
     articulo3.setDescripcion("CARNE PICADA PARA HACER HAMBURGUESAS");
     articulo3.setComprar(true);
     articulo3.setId_producto(10);
     articulo3.setIdTipoproducto(3);
     repo.save(articulo3);
     
     model.addAttribute("personas", repo.findAll());
return "listar";
}
	
@GetMapping("/lacteo")
	public String buscar(Model model) {
     model.addAttribute("personas", repo.findByIdTipoproducto(1));

return "listar";
}

 //    http://localhost:9899/greeting?name=Leche
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		//logica
        model.addAttribute("name", name);
		return "greeting";
			
		}

}
