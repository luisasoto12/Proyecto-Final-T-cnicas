/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.Dao.VentaDAO;
import com.mycompany.Modelos.Casa;
import jakarta.servlet.annotation.WebServlet;
import com.mycompany.Modelos.Propietario;
import com.mycompany.Modelos.Venta;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luisa Soto
 */


@WebServlet("/insertarV")
public class InsertarServlet2 extends HttpServlet {
    private VentaDAO ventaDAO;

    public InsertarServlet2() {
        this.ventaDAO = new VentaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String propietarioId = request.getParameter("propietario_id");
    String casaId = request.getParameter("propiedad_id");

    // Obtener la fecha de adquisición del formulario HTML
    String fechaAdquisicionParam = request.getParameter("fecha_adquisicion");

    // Convertir la fecha de adquisición a un objeto Date
    Date fecha = null;
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato esperado del campo de fecha
        fecha = new Date(dateFormat.parse(fechaAdquisicionParam).getTime());
    } catch (ParseException e) {
        // Manejar el error de análisis de la fecha
        e.printStackTrace(); // O mostrar un mensaje de error al usuario, redirigir, etc.
    }

    // Verificar que el parámetro de precio_adquisicion no sea nulo ni esté vacío antes de convertirlo a float
    String precioAdquisicionParam = request.getParameter("precio_adquisicion");
    float precio = 0; // Precio inicializado a 0
    if (precioAdquisicionParam != null && !precioAdquisicionParam.trim().isEmpty()) {
        precio = Float.parseFloat(precioAdquisicionParam.trim());
    } else {
        // Manejar el caso cuando el parámetro de precio_adquisicion es nulo o vacío
        // Por ejemplo, mostrar un mensaje de error o redireccionar a una página de error
        response.sendRedirect("/error.jsp");
        return; // Terminar la ejecución del método para evitar más procesamiento
    }

    Propietario propietario = new Propietario(propietarioId, "", ""); // Suponiendo que solo necesitas el ID

    Casa casa = new Casa(); // Suponiendo que solo necesitas el ID

    Venta venta = new Venta(propietario, casa, (java.sql.Date) fecha, precio);

    ventaDAO.insertarVenta(venta);

    response.sendRedirect("/");
}
}