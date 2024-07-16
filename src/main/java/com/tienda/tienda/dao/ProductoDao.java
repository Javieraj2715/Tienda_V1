
package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao extends JpaRepository <Producto,Long> {
    
}
