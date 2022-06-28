function check(input) {
   if (input.value == 0) {
     input.setCustomValidity('Debe ser diferente a 0');
   } else {
     // input is fine -- reset the error message
     input.setCustomValidity('');
   }
}

function eliminarUsuario(id) {
  swal({
  title: "Eliminar",
  text: "Está seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
    $.ajax({
      url:"/usuarios/del/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/usuarios/all";
      }
    });
    swal("Usuario Eliminado", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}
