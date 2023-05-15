<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
        <div class="row">
            <h2 id="titulo" class="text-center mt-2">Menú principal</h2>
        </div>
        <div class="row mt-4">
            <div class="col-3"></div>
            <div class="col-2">
                <form action="/WebProject/registro/registro.jsp" method="GET">
                  <button type="submit" class="btn btn-primary" id="botonRegistro">Registrarse</button>
                </form>
            </div>
            <div class="col-2">
                <form action="/WebProject/setup/setup.jsp" method="GET">
                  <button type="submit" class="btn btn-primary" id="botonComienzo">Comenzar juego</button>
                </form>
            </div>
            <div class="col-3">
                <form action="/WebProject/busqueda/busqueda.jsp" method="GET">
                  <button type="submit" class="btn btn-primary" id="botonBusqueda">Buscar partidas</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>