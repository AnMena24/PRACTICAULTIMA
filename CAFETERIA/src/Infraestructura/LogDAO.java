package infraestructura;

import dominio.LogEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LogDAO {
    public void guardar(LogEntry log) {
        String sql = "INSERT INTO LOGS(nivel, evento, detalle, stacktrace) VALUES(?,?,?,?)";
        try (Connection con = ConexionDB.get();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, log.getNivel());
            ps.setString(2, log.getEvento());
            ps.setString(3, log.getDetalle());
            ps.setString(4, log.getStacktrace());
            ps.executeUpdate();
        } catch (Exception e) {
            // última línea de defensa: evita reventar la app por un fallo de logging
            System.err.println("Error guardando log: " + e.getMessage());
        }
    }
}