package com.listacompra.demoWeb.repo;

import org.springframework.data.repository.CrudRepository;
import com.listacompra.demoWeb.model.Producto;
import java.util.List;

public interface IListacomprarepo extends CrudRepository<Producto,Integer>{
	List<Producto> findByDescripcion(String descripcion);
	List<Producto> findByComprar(Boolean comprar);
	List<Producto> findByIdTipoproducto(Integer idTipoproducto);
    Producto   save(Producto producto);
	
}