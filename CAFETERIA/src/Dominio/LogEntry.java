/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

public class LogEntry {
    private String nivel;   // INFO/WARN/ERROR
    private String evento;  // LOGIN_OK, LOGIN_FAIL, VENTA_OK
    private String detalle;
    private String stacktrace;

    public LogEntry(String nivel, String evento, String detalle, String stacktrace) {
        this.nivel = nivel; this.evento = evento; this.detalle = detalle; this.stacktrace = stacktrace;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

}
