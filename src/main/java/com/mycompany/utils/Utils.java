package com.mycompany.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
    
    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) throws ParseException {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        fechaFinal = df.parse(fechaFinalString);

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date stringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String parseDateToMysql(String input) throws Exception {
        if (input == null || input.isBlank()) throw new Exception("Fecha vacía");
        String trimmed = input.trim();
        java.time.LocalDate date;

        // Formato ya en yyyy-MM-dd
        if (trimmed.matches("\\d{4}-\\d{2}-\\d{2}")) {
            try {
                date = java.time.LocalDate.parse(trimmed);
                return date.toString();
            } catch (Exception e) {
                throw new Exception("Fecha inválida");
            }
        }

        // Formato dd/MM/yyyy
        if (trimmed.matches("\\d{2}/\\d{2}/\\d{4}")) {
            java.time.format.DateTimeFormatter f = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                date = java.time.LocalDate.parse(trimmed, f);
                return date.toString(); // ISO = yyyy-MM-dd
            } catch (Exception e) {
                throw new Exception("Fecha inválida");
            }
        }

        throw new Exception("Formato de fecha no admitido (use dd/MM/yyyy o yyyy-MM-dd)");
    }
    
}