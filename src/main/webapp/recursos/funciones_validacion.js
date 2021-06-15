function validarForma(forma) {
    var usuario = forma.usuario;

    if (usuario.value() == "" || usuario.value() == "Escribir Usuario") {
        Console.warn("Hola estoy aqui");
        alert("Debe proporcionar un elementi de Usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    var password = forma.password;
    if (password.value() == "" || password.length < 3) {
        alert("Debe proporcionar uun password de al menos 3 caracteres");
        usuario.focus();
        usuario.select();
        return false;
    }
    var tecnologias = forma.tecnologia;
    var checkseleccionado = false;
    for (i = 0; i < tecnologias.length; i++) {
        if (tecnologias[i].checked) {
            checkseleccionado = true;
        }
    }
    
    if(checkseleccionado == false){
        alert("Debe seleccionar al menos una opcion");  
    }
    var genero= forma.radio;
    var radioSeleccionado = false;
    
    for(i=0; i < genero.length; i ++){
        if(genero[i].checked){
            radioSeleccionado = true;
        }
    }
    if(radioSeleccionado == false){
        alert("Debe selecionar un genero ");
        return false;
    }
    var ocupacion = forma.ocupacion();
    if(ocupacion == ""){
        alert("Debe seleccionar una opcion");
        return false;
    }
    
    // Formulario valido
    alert("Formulario valido ... enviando datos al servidor.");
    return true;
}