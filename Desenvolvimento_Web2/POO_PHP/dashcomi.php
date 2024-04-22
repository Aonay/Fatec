<?php
include "Comissionado.php";

if (isset($_POST['btEnviar'])) {
  $codigo = $_POST['txtCodigo'];
  $nome = $_POST['txtNome'];
  $vlHora = $_POST['vlHora'];
  $qtHora = $_POST['qtHoras'];
  $vendas = $_POST['vendas'];

  $c1 = new Comissionado($codigo, $nome, $vlHora, $qtHora, $vendas);
}

?>


<!doctype html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calculo Funcinário</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>

<body>

  <style>
    header {
      background-color: rgba(20, 204, 156, 0.75);
      color: white;
    }

    form {
      background-color: rgba(20, 204, 156, 0.5);
    }

    body {
      font-family: "Poppins", sans-serif;
      font-weight: 500;
      font-style: normal;
      background-image: url("/bg2.jpg");
      background-size: cover;
    }


    .imagem1 {
      display: flex;
      justify-content: end;
    }

    img#img2 {
      max-width: 550px;
      max-height: 550px;
      width: auto;
      height: auto;
      z-index: 1;

    }

    img#container2 {
      max-width: 60px;
      max-height: 60px;
      background-color: white;
      margin-right: 10px;
      border-radius: 5px;


    }


    @media only screen and (max-width: 600px) {

      img#img2 {
        max-width: 250px;
        max-height: 250px;
        width: auto;
        height: auto;
        background-color: white;

      }

      .imagem1 {
        justify-content: center;
      }

    }
  </style>

  <header class="p-3 ">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">

        </a>

        <img id="container2" src="/icon.png" alt="">

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li>
            <h1>Cálculo Salário Comissionado</h1>
          </li>
        </ul>

        <div class="text-end">

          <a href="index.php">
            <button type="button" name="voltar" class="btn btn-primary">Voltar</button>
          </a>


        </div>
      </div>
    </div>
  </header>

  <div class="container">
    <div class="row">

      <div class="col-md-8 justify-content-end">
        <form method="post" action="#" class=" container p-4 mt-5 rounded-2 ">
          <div class="mb-2 ">
            <label class="form-label">Código</label>
            <input type="text" class="form-control" name="txtCodigo" required>
          </div>
          <div class="mb-2 ">
            <label class="form-label">Nome</label>
            <input type="text" class="form-control" name="txtNome" required>
          </div>
          <div class="mb-2 ">
            <label class="form-label">Valor da Hora</label>
            <input type="number" step=".01" class="form-control" name="vlHora" required>
          </div>
          <div class="mb-2 ">
            <label class="form-label">Horas Trabalhadas</label>
            <input type="number" class="form-control" name="qtHoras" required>
          </div>
          <div class="mb-2 ">
            <label class="form-label">Total Vendido</label>
            <input type="number" class="form-control" name="vendas" required>
          </div>
          <div class="d-grid gap-2">
            <button type="submit" class="mt-2 btn btn-primary" name="btEnviar">Calcular Salário</button>
          </div>
        </form>
      </div>




      <div class="col-md-4">
        <div class="container p-3 mt-5 rounded-2" style="background-color: rgba(20, 204, 156, 0.5);">
          <h1 class="text-center">Folha de Pagamento</h1>
          <div class="container p-2 rounded-2" style="background-color: white;">
            <?php if ($_POST) {  ?>
              <table class="table">
                <tbody>
                  <tr>
                    <th scope="row"><?php echo $c1->getCodigo();  ?></th>
                    <td><?php echo $c1->getNome();  ?></td>
                  </tr>
                  <tr>
                    <th scope="row">Valor da Hora</th>
                    <td>R$ <?php echo number_format($c1->getValorHora(), 2, ',', '.'); ?></td>
                  </tr>
                  <tr>
                    <th scope="row">Horas Trabalhadas: </th>
                    <td><?php echo $c1->getHorasTrabalhadas() . " horas"; ?></td>
                  </tr>
                  <tr>
                    <th scope="row">Valor da Hora</th>
                    <td>R$ <?php echo number_format($c1->getVendas(), 2, ',', '.'); ?></td>
                  </tr>
                  <tr style="font-size: 20px; color:#14cc9c;">
                    <th scope="row">Salário Liquido: </th>
                    <td>R$ <?php echo number_format($c1->calcularSalario(), 2, ',', '.'); ?></td>
                  </tr>
                </tbody>
              </table>
            <?php } ?>
          </div>
        </div>
      </div>

    </div>
  </div>

  <div class="imagem1"><img id="img2" src="/pagamento.png" alt="imagem1"></div>



  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</html>