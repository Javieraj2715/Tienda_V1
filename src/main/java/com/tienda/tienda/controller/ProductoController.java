package com.tienda.Tienda.controller;
 
import com.tienda.tienda.Service.CategoriaService;
import com.tienda.tienda.domain.Producto;
import lombok.extern.slf4j.Slf4j;
import com.tienda.tienda.Service.ProductoService;
import com.tienda.tienda.Service.service.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
 
 
@Controller
@Slf4j
@RequestMapping("/producto") //(/producto/listado)
public class ProductoController {
 
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;
    
 
    @GetMapping("/listado")
    public String inicio(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos); //lista de productos
        model.addAttribute("totalProductos", productos.size()); //
        return "/producto/listado";
    }
     @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }
 
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
 
    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
 
    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        var categoria = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categoria);
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }   

}