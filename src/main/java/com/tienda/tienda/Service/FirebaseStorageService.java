package com.tienda.tienda.Service;

import org.springframework.web.multipart.MultipartFile;


public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalClienteFile, String carpeta, Long id);
        
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-240fd.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-240fd-firebase-adminsdk-385fo-f778503e70.json";
}
