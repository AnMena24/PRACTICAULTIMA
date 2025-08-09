# CAFETERIA - Módulo de Dominio

Este módulo define las clases de dominio del sistema de gestión de ventas para una **cafetería universitaria**.  
Su propósito es representar las entidades principales de la aplicación y servir como base para la capa de lógica de negocio y persistencia.

## 📂 Estructura de Clases

El paquete `dominio` contiene las siguientes clases:

### 1. `Producto`
Representa un producto disponible para la venta en la cafetería.
- **Atributos:**
  - `id` (int): Identificador único del producto.
  - `nombre` (String): Nombre del producto.
  - `precioUnitario` (BigDecimal): Precio unitario del producto.
  - `activo` (boolean): Indica si el producto está activo en el catálogo.
- **Uso:** Se utiliza para mostrar el menú, gestionar inventario y calcular precios.

---

### 2. `Venta`
Representa una venta realizada por un usuario.
- **Atributos:**
  - `id` (int): Identificador único de la venta.
  - `userId` (int): ID del usuario que realizó la venta.
  - `fechaHora` (LocalDateTime): Fecha y hora de la venta.
  - `subtotal` (BigDecimal): Monto antes de impuestos y descuentos.
  - `impuestoIVA` (BigDecimal): Impuesto del 7%.
  - `impuestoIVI` (BigDecimal): Impuesto del 13%.
  - `descuento` (BigDecimal): Descuento aplicado.
  - `total` (BigDecimal): Total a pagar.
  - `detalles` (List<DetalleVenta>): Lista de productos vendidos en esta venta.
- **Uso:** Permite agrupar todos los detalles de una venta y calcular el monto final.

---

### 3. `DetalleVenta`
Representa el detalle de un producto dentro de una venta.
- **Atributos:**
  - `id` (int): Identificador único del detalle.
  - `ventaId` (int): ID de la venta a la que pertenece.
  - `productId` (int): ID del producto vendido.
  - `cantidad` (int): Cantidad vendida.
  - `precioUnit` (BigDecimal): Precio unitario del producto en la venta.
  - `totalLinea` (BigDecimal): Total de esta línea (cantidad × precio unitario).
- **Uso:** Se utiliza para desglosar los productos que forman parte de una venta.

---

### 4. `Usuario`
Representa un usuario del sistema (cajero, gerente, administrador, etc.).
- **Atributos:**
  - `id` (int): Identificador único del usuario.
  - `username` (String): Nombre de usuario para iniciar sesión.
  - `passwordHash` (String): Contraseña encriptada.
  - `rol` (String): Rol del usuario (ej. `CAJERO`, `GERENTE`, `ADMIN`).
  - `activo` (boolean): Estado de la cuenta.
- **Uso:** Controla el acceso al sistema y la asignación de permisos.

---

### 5. `LogEntry`
Representa una entrada de registro para auditoría y depuración.
- **Atributos:**
  - `nivel` (String): Nivel del log (`INFO`, `WARN`, `ERROR`).
  - `evento` (String): Tipo de evento (`LOGIN_OK`, `LOGIN_FAIL`, `VENTA_OK`, etc.).
  - `detalle` (String): Descripción del evento.
  - `stacktrace` (String): Trazado de error (opcional).
- **Uso:** Almacena información de eventos importantes y errores para seguimiento.

---

## 🔄 Relación entre las clases
- Una **Venta** contiene varios **DetalleVenta**.
- Cada **DetalleVenta** está asociado a un **Producto**.
- Cada **Venta** está asociada a un **Usuario**.
- Los **LogEntry** registran eventos relacionados con ventas, inicios de sesión y operaciones críticas.

---

## 📌 Posibles Mejoras Futuras
- Agregar validaciones en los setters para garantizar datos consistentes.
- Implementar métodos de cálculo automáticos en `Venta` para subtotal, impuestos y total.
- Integrar `LogEntry` con una base de datos para persistencia histórica.
- Uso de patrones como **Builder** para construir objetos complejos.

---

## 📄 Licencia
Este código es parte del proyecto académico **CAFETERIA** y puede ser reutilizado con fines educativos.
