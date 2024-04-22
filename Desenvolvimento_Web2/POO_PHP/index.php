<!doctype html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calculadora Salário</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>

<body>



  <style>
    #container1 {
      margin-top: 80px;
      width: 50%;
      padding: 20px;
      background-color: rgb(255, 255, 255);
      box-shadow: 10px 10px 20px #14cc9c;
      border: solid;
      border-top-color: #14cc9c;
      border-left-color: #14cc9c;
      border-width: 1px;
      border-right: none;
      border-bottom: none;
      z-index: 2;


    }


    #container3 {
      width: 95%;
    }

    #container4 {
      margin-top: 40px;
      margin-bottom: 20px;
    }

    body {
      font-family: "Poppins", sans-serif;
      font-weight: 500;
      font-style: normal;
      background-image: url("/bg2.jpg");
      background-size: cover;
    }

    img#container2 {
      max-width: 150px;
      max-height: 150px;
      width: auto;
      height: auto;
    }

    img#img2 {
      max-width: 550px;
      max-height: 550px;
      width: auto;
      height: auto;
      z-index: 1;

    }

    .imagem1 {
      display: flex;
      justify-content: end;
    }


    a {
      text-decoration: none;
    }

    #txt {
      font-size: 35px;
      color: #14cc9c;
      font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;

    }

    @media only screen and (max-width: 600px) {
      #container1 {
        margin-top: 10px;
        width: 100%;
        padding: 0px;
        padding-bottom: 20px;

      }

      #container2 {
        padding-top: 20px;


      }

      #container3 {
        width: 100%;
        margin-top: 0px;


      }

      #container4 {
        margin-top: 0px;

      }

      img#container2 {
        max-width: 100px;
        max-height: 100px;

      }

      img#img2 {
        max-width: 250px;
        max-height: 250px;
        width: auto;
        height: auto;

      }

      #txt {
        font-size: 20px;
      }
    }
  </style>
  <div class="container rounded-2" id="container1">

    <div class="container text-center">
      <img id="container2" src="/icon.png" alt="logo">
      <p id="txt">TECHCON</p>
    </div>

    <div class="container text-center" id="container3">
      <h3>Bem vindo ao nosso sistema de cálculo de Folha de Pagamento!</h3><br>
      <p>Selecione abaixo qual o tipo de folha que deseja calcular, se funcionário comum ou de funcionário comissionado:</p>
    </div>



    <div class="container text-center " id="container4">
      <div class="row ">


        <div class="col">
          <a href="/dashfunc.php">
            <div class="d-grid gap-2">
              <button class="btn btn-primary m-1 btn-lg" type="button">Funcionário</button>
            </div>
          </a>
        </div>


        <div class="col">
          <a href="/dashcomi.php">
            <div class="d-grid gap-2">
              <button class="btn btn-primary m-1  btn-lg" type="button">Comissionado</button>
            </div>
          </a>
        </div>

      </div>
    </div>
  </div>

  <div class="imagem1"><img id="img2" src="/inicio.png" alt="imagem1"></div>



















  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</html>