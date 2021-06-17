


<%@page import="domain.Tokens"%>
<%@page import="conexion.TokensDaoJDBC"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="conexion.Conexion" %>
<%@page import="conexion.UsersDaoJDBC" %>
<%@page import="domain.Users" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/estilos.css"/> 
        <title>Pagina Node </title>
    </head>
    <body>
        <form name="form1" action="#" method="post"
              onsubmit="#">

            <table width="200" id="enfasis-columna">
                <%
                    List<Users> lista = new ArrayList<Users>();
                    List<Tokens> lista1 = new ArrayList<Tokens>();
                    TokensDaoJDBC token = null;
                    UsersDaoJDBC usuario = null;

                    try {
                        String driver = "com.mysql.cj.jdbc.Driver";
                        Class.forName(driver);
                        Connection conexion = Conexion.getConnection();
                        usuario = new UsersDaoJDBC(conexion);
                        token = new TokensDaoJDBC(conexion);
                        lista = usuario.select();

                    } catch (Exception ex) {
                        ex.printStackTrace(System.out);
                    }
                %>
                <caption>
                    Formulario de Registro Usuarios Node
                </caption>
                <tr>
                    <td class="columna">
                        Nombre (*)
                    </td>
                    <td class="columna">
                        Apellido (*)
                    </td>
                    <td class="columna">
                        Email (*)
                    </td>
                    <td class="columna">
                        Usuario (*)
                    </td>
                    <td class="columna">
                        Password (*)
                    </td>
                    <td class="columna">
                        Administrador (*)
                    </td>
                    <td class="columna">
                        Fecha Registro (*)
                    </td>
                    <td class="columna">
                        Token (*)
                    </td>
                </tr>
                <%for (Users usuario1 : lista) {
                        System.out.println("Nombre " + usuario1.getFirst_name());
                        System.out.println("Fecha" + new SimpleDateFormat("dd/MM/yyyy").format(usuario1.getDate_registered()));

                        lista1 = token.select_id(usuario1);
                %>
                <tr> 

                    <td>
                        <input class="default" type="text" name="nombre" value="<%= usuario1.getFirst_name()%>"
                               onfocus="this.select()"/>
                    </td>

                    <td>
                        <input class="default" type="text" name="apellido" value="<%= usuario1.getLast_name()%>"
                               onfocus="this.select()"/>
                    </td>
                    <td>
                        <input class="default" type="email" name="email" value="<%= usuario1.getLast_name()%>"
                               onfocus="this.select()"/>
                    </td>
                    <td>
                        <input class="default" type="text" name="usuario" value="<%= usuario1.getUsername()%>"
                               onfocus="this.select()"/>
                    </td>

                    <td>
                        <input class="default" type="password" name="password" value="<%= usuario1.getPass_phrase()%>"
                               onfocus="this.select()"/>
                    </td>

                    <td>
                        <select  name="rol" class="default">
                            <!--<option value="">Seleccionar</option>-->
                            <% if (usuario1.getIs_admin() == 1) {%>
                            <option value="">Seleccionar</option>
                            <option value="<%=usuario1.getIs_admin()%>" selected>Administrador</option>
                            <option value="2">Administrador</option>

                            <% } else {%>
                            <option value="">Seleccionar</option>
                            <option value="1">Administrador</option>
                            <option value="<%=usuario1.getIs_admin()%>" selected>Trabajador</option>
                            <% }%> 

                        </select>
                    </td>
                    <%
                        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        //String cadena=  formato.format(usuario1.getDate_registered());
                        // Date fecha_s = (Date) formato.parse(cadena);
%>
                    <td>
                        <input class="default" type="date" name="fecha_registro" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(usuario1.getDate_registered())%>"
                               onfocus="this.select()"/>
                    </td>
                    <%
                        for (Tokens tokens : lista1) {
                    %>
                    
                    <td>
                        <div class="datos">
                            <%if (tokens.getToken().equals("all")) {%> 
                               All <input  type="checkbox" name="token" value="all" checked/>
                               
                            <%}%>
                            <%if (tokens.getToken().equals("part")) {%>
                               Part <input  type="checkbox" name="token" value="part" checked/>
                            <%}%>
                            <%if (!tokens.getToken().equals("all") && !tokens.getToken().equals("part")) {%>
                                All <input  type="checkbox" name="token" value="all"/>
                                Part <input  type="checkbox" name="token" value="part"/>
                            <%}%>
                        </div>

                    </td>
                    <%}%>
                    <%}%>
                </tr>               
                <!-- <tr>
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
                </tr> -->
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
