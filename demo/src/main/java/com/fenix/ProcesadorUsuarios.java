package com.fenix;

import java.util.List;

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
            String[] partes = usuario.split(":"); // Formato "nombre:rol"
            if (partes.length == 2) {
                String nombre = partes[0];
                int rol = Integer.parseInt(partes[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    admins = procesarAdmin(admins,nombre);
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    invitados = procesarInvitado(invitados,nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    private String procesarInvitado(String admins, String nombre) {
        StringBuilder builder = new StringBuilder(admins);
        builder.append(nombre);
        builder.append(",");
        return builder.toString();
    }

    private String procesarAdmin(String invitados, String nombre) {
        StringBuilder builder = new StringBuilder(invitados);
        builder.append(nombre);
        builder.append(",");
        return builder.toString();
    }
}