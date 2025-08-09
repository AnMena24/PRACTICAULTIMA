/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private int userId;
    private LocalDateTime fechaHora;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal impuestoIVA = BigDecimal.ZERO; // 7%
    private BigDecimal impuestoIVI = BigDecimal.ZERO; // 13%
    private BigDecimal descuento = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private List<DetalleVenta> detalles = new ArrayList<>();
    
    public List<DetalleVenta> getDetalles() { return detalles; }

}
