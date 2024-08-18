package com.tienda.tienda.Service;

import jakarta.mail.MessagingException;

public interface CorreoService {

    public void enviarCorreoHtml(
            String para,
            String asuntoString,
            String contenidoHtml)
            throws MessagingException;
}
