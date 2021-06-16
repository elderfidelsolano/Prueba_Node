

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/estilos.css"/> 
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" action="#" method="post"
          onsubmit="return validarForma(this)">
        <input type="hidden" name="oculto" value="valorOculto">
        <table width="200" id="enfasis-columna">
            <caption>
                Formulario de Registro de Datos Ususarios
            </caption>
            <tr>
                <td class="columna">
                    Primer Nombre
                </td>
                <td>
                    <input class="default" type="text" name="nombre" value="EIngresar Nombre"
                           onfocus="this.select()"/>
                </td>
            </tr>
            <tr>
                <td class="columna">
                    Apellido
                </td>
                <td>
                    <input class="default" type="text" name="apellido" value="Ingresar Apellido"
                           onfocus="this.select()"/>
                </td>
            </tr>
            
            <tr>
                <td class="columna">
                    Email
                </td>
                <td>
                    <input class="default" type="text" name="email" value="Ingresar Email"
                           onfocus="this.select()"/>
                </td>
            </tr>
            
            <tr>
                <td class="columna">
                    Email
                </td>
                <td>
                    <input class="default" type="text" name="usuario" value="Ingresar Usuario"
                           onfocus="this.select()"/>
                </td>
            </tr>
            
            <tr>
                <td class="columna">
                    Email
                </td>
                <td>
                    <input class="default" type="text" name="frase" value="Ingresar Frase"
                           onfocus="this.select()"/>
                </td>
            </tr>
            <tr>
                <td class="columna">
                    Email
                </td>
                <td>
                    <input class="default" type="date" name="fecha" value="Seleecionar Fecha"
                           onfocus="this.select()"/>
                </td>
            </tr>
            <tr>
                <td class="columna">
                    Tecnologias de Internet(*)
                </td>
                <td>
                    Java <input  type="checkbox" name="tecnologia" value="Java"/>
                    &nbsp;&nbsp;&nbsp;
                    .Net <input  type="checkbox" name="tecnologia" value="net"/>
                    &nbsp;&nbsp;&nbsp;
                    Php <input  type="checkbox" name="tecnologia" value="php"/>
                </td>
            </tr>
            <tr>
                <td class="columna">
                    Genero (*)
                </td>
                <td>
                    Hombre <input type="radio" name="genero" value="H"/>
                    &nbsp;&nbsp;&nbsp;
                    Mujer <input type="radio" name="genero" value="F"/>
                </td>

            </tr>
            <tr>
                <td class="columna">
                    Ocupacion (*)
                </td>
                <td>
                    <select  name="ocupacion" class="default">
                        <option value="">Seleccionar</option>
                        <option value="1">Profesor</option>
                        <option value="2">Ingeniero</option>
                        <option value="3">Jubilado</option>
                        <option value="4">Otro</option>
                    </select>
                <td>
            </tr>
            <tr>
                <td class="columna">
                    Musica Favorita :
                </td>
                <td>
                    <select  name="musica" multiple class="default">
                        <option value="rock">Rock</option>
                        <option value="pop">Pop</option>
                        <option value="salsa">Salsa</option>
                    </select>
                <td>
            </tr>
            <tr>
                <td class="columna">
                    Comentarios :
                </td>
                <td>
                    <textarea  name="comentarios" rows="2" cols="30"
                               class ="default" onfocus="this.select()"/> 
                    Escribir un texto    
                    </textarea>
                <td>
            </tr>
            <tr style="text-align: center">
                <td>
                    <input type="reset" value="Limpiar" class="default"/>
                </td>
                <td>
                    <input type="submit" value="Enviar" class="default"/>
                </td>
            </tr>
        </table>
    </form>
    </body> 
</html>
