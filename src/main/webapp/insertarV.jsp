<%-- 
    Document   : insertarV
    Created on : 31/05/2024, 9:25:14 p. m.
    Author     : Luisa Soto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insertar Venta</title>
</head>
<body>
    <h1>Insertar Venta</h1>
    <form action="insertarV" method="post">
        <label for="propietario_id">ID del Propietario:</label>
        <input type="text" name="propietario_id" placeholder="Id del Propietario"/><br/>
        
        <label for="propiedad_id">ID de la Casa:</label> <!-- Corregido a casa_id -->
        <input type="text" name="propiedad_id" placeholder="Direccion de la Casa"/><br/> <!-- Corregido a casa_id -->
        
        <label for="fecha_adquisicion">Fecha de Adquisición:</label>
        <input type="date" name="fecha_adquisicion"/><br/>
        
        <label for="precio_casa">Precio de la Casa:</label>
        <input type="text" name="precio_casa" placeholder="Precio de la Casa"/><br/>
        
        <button type="submit">Registrar Venta</button>
    </form>
</body>
</html>