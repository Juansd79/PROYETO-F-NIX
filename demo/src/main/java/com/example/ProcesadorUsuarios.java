package com.example;

import java.util.List;
// Comentario para probar GitHub Actions


/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */
public class ProcesadorUsuarios {

    /**
     * Procesa una lista de strings y genera un resumen de roles.
     * * @param usuarios Lista de strings en formato "nombre:rol".
     * @return Un String con los nombres de Admins e Invitados separados.
     */

    private static final int ROL_INVITADO = 2;
    private static final int ROL_ADMIN = 1;

    // Método con 'code smells': largo, números mágicos, malos nombres.
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String usuario : usuarios) {
            String[] parts = procesarAdmin(procesarInvitado(usuario)).split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    admins += procesarAdmin(procesarInvitado(nombre)) + ",";
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    invitados += procesarAdmin(procesarInvitado(nombre)) + ",";
                }
            }
        }
        return "Admins: " + procesarAdmin(procesarInvitado(admins)) + " | Invitados: " + procesarAdmin(procesarInvitado(invitados));
    }

    private String procesarInvitado(String nombre) {
        return nombre;
    }

    private String procesarAdmin(String nombre) {
        return procesarInvitado(nombre);
    }
}