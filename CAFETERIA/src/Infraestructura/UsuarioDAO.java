package infraestructura;

import dominio.Usuario;
import java.sql.*;

public class UsuarioDAO {
    public Usuario findByUsername(String username) {
        String sql = "SELECT id, username, password_hash, rol, activo FROM USUARIOS WHERE username = ?";
        try (Connection con = ConexionDB.get();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPasswordHash(rs.getString("password_hash"));
                    u.setRol(rs.getString("rol"));
                    u.setActivo(rs.getBoolean("activo"));
                    return u;
                }
            }
        } catch (Exception e) {
            new LogDAO().guardar(new dominio.LogEntry("ERROR","DAO_USUARIO",
                "findByUsername("+username+")", e.toString()));
        }
        return null;
    }
}