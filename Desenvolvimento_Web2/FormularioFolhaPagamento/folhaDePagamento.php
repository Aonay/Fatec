<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FOLHA DE PAGAMENTO</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container w-50 p-3 text-primary-emphasis bg-success-subtle border border-primary-subtle rounded-3 ">
    <h1>Dados do Funcionário</h1>
    <form method="post" action="#">

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Código:</label>
            <input type="text" name="txtcod" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Horas trabalhadas/Mês:</label>
            <input type="text" name="txthorast" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Horas Extras:</label>
            <input type="text" name="txthextra" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Valor Hora/Trabalho R$:</label>
            <input type="text" name="txtvlhora" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Nº Dependentes:</label>
            <input type="text" name="txtdep" class="form-control" />
        </div>
        
        <div class="d-grid pt-3 gap-2 d-md-flex justify-content-md-end">
        <input type="submit" value="Calcular" class="btn btn-success">
        </div>
        


</div>
    
    <form method="post" action="#">
    
</div>

    </form>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

<?php

if($_POST){



$codigo= $_POST['txtcod'];
$horasTrab= $_POST['txthorast'];
$horasext= $_POST['txthextra'];
$vlhora= $_POST['txtvlhora'];
$depend= $_POST['txtdep'];

$valorhoraEXT = ($vlhora/2)+$vlhora;

$salbruto= $horasTrab*$vlhora;
$valorhextra= $horasext*$valorhoraEXT;
$acrescdep = (($depend*3)*$salbruto)/100;
$descvalet = ($salbruto*6)/100;

echo "<div class='container mt-3 w-50 p-3 text-primary-emphasis bg-success-subtle border border-primary-subtle rounded-3 '>";
echo"<br><h1>Folha de Pagamento:</h1>";
echo"<br><h5>Código: ".$codigo ."</h5>";
echo"<br><h5>Salário Bruto  : R$".number_format($salbruto,2,',','.') ."</h5>";
echo"<br><h5>Valor total hora extra  R$: ".number_format($valorhextra,2,',','.') ."</h5>";
echo"<br><h5>Acréscimo Dependentes: R$".number_format($acrescdep,2,',','.') ."</h5>";
echo"<br><h5>Desconto VT: R$".number_format($descvalet,2,',','.') ."</h5>";


$salliquido = ($salbruto+$valorhextra+$acrescdep)-$descvalet;



echo "<br><h5.Salário Liquido: ".number_format($salliquido,2,',','.') ."</h5>";
echo"</div>";
}
?> 

