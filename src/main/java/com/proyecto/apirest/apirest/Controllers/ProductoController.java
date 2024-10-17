package com.proyecto.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apirest.apirest.Entities.Producto;
import com.proyecto.apirest.apirest.Repositories.ProductoRepository;

@RestController
@RequestMapping("/productos") // Indicamos que paginaweb/producto es una direccion accesible
public class ProductoController {

    @Autowired /*con esto sabe a que repositorio corresponde lo que vamos a utilizar y hace una inyeccion de una instancia de ese repositorio.
    En este caso, el repositorio seria "productoRepository".*/
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> obteneProductos() {
        return productoRepository.findAll(); // Aca traemos todos los productos que tenga el repositorio
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));
    }

    @PostMapping
    public Producto creaProductos(@RequestBody Producto producto) { // Estamos recibiendo un producto.
        // Lo guardamos en la base de datos y a la vez mostramos el producto guardado.
        return productoRepository.save(producto); 
    }

    @PutMapping("/{id}")
    // Mediante la url nos mandan el Id del producto a modificar y recibimos el producto.
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));

        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));

        productoRepository.delete(producto);
        return "El producto con el ID: " + id + " fue eliminado correctamente";
    }

}
