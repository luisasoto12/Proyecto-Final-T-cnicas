<%-- 
    Document   : Insertar
    Created on : 28/05/2024, 4:35:38 p. m.
    Author     : Luisa Soto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="insertar" method="post">
            <input type="text" name="direccion" placeholder="direccion"/>
            <input type="number" name="precio" placeholder="precio"/>
             <input type="text" name="ciudad" placeholder="ciudad"/>
              <input type="text" name="pais" placeholder="pais"/>
               <input type="text" name="tipo" placeholder="tipo"/>
            <button type="submit">Boton Registrar</button>

        </form>
    </body>
</html>
