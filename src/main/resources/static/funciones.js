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
      url:"/deleteUser/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/usuarios";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarDepartamento(id) {
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
      url:"/deleteDepto/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="redirect:/departamentos";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarMateria(id) {
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
      url:"/deleteMateria/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/materias";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarCiclo(id) {
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
      url:"/deleteCiclo/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/ciclos";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarMateriaImp(id_c,id_m) {
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
      url:"/delMateriaImp/"+id_m,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/ciclos/"+id_c+"/materias-imp";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarEvaluacion(id_m,id_ev) {
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
      url:"/deleteEval/"+id_ev,
      success: function(res){
        console.log(res);
      }
    }).then((ok)=>{
      if(ok){
        location.href="/materia-imp/"+id_m+"/evaluaciones";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarSolicitud(id) {
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
      url:"/deleteSolicitud/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((ok)=>{
      if(ok){
        location.href="/solicitudes/lista-solicitudes";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}