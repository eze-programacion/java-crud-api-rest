package com.proyecto.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.apirest.apirest.Entities.Producto;


//<tipo identidad, tipo Identificador>
public interface ProductoRepository extends JpaRepository<Producto, Long> {
        
}

