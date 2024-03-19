<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Formulario HTML e PHP</title>

</head>
<body>
<div class="container w-25 p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3 ">
    <h1>Folha de pagamento</h1>
    <form method="post" action="#">

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Código do funcionário</label>
            <input type="text" name="txtCod" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Nome do funcionário</label>
            <input type="text" name="txtNome" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Horas trabalhadas/mês:</label>
            <input type="text" name="txtHoras" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Horas EXTRAS trabalhadas/mês:</label>
            <input type="text" name="txtHorasExtras" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Valor R$/hora:</label>
            <input type="text" name="txtValorHoras" class="form-control" />
        </div>

        <div class="form-outline" data-mdb-input-init>
            <label class="form-label" for="typeText">Número de dependentes</label>
            <input type="text" name="txtDependentes" class="form-control" />
        </div>
        
        <input type="submit" value="Calcular">
    
    <form method="post" action="#">
    
</div>

    </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>

<?php

if($_POST){

$cod = $_POST['txtCod'];    
$nome = $_POST['txtNome'];
$horas = $_POST['txtHoras'];
$horas_extras = $_POST['txtHorasExtras'];
$valor_horas = $_POST['txtValorHoras'];
$dependentes = $_POST['txtDependentes'];

echo "<br> Código do funcionário: " . $cod;
echo "<br> Nome: " . $nome;
echo "<br> Horas trabalhadas no mês: " . $horas;
echo "<br> Valor por hora: R$" . number_format($valor_horas,2,',','.');
echo "<br> Quantidade de dependentes: " . $dependentes;

$salario_bruto = $horas*$valor_horas;
$valor_hora_extra = $salario_bruto+($horas*1.5);
$valor_dependente = $salario_bruto+($dependentes*($salario_bruto*0.03));
$vl_transporte = $salario_bruto-($salario_bruto*0.06);
$sal_final = $valor_hora_extra+($dependentes*($salario_bruto*0.03))-($salario_bruto*0.06);

echo "<br>Salário bruto: R$" . number_format($salario_bruto,2,',','.');
echo "<br>Salário adicionado hora extra: R$"  . number_format($valor_hora_extra,2,',','.');
echo "<br>Salário adicionado por quantidade de dependentes R$"  . number_format($valor_dependente,2,',','.');
echo "<br>Valor descontado vale transporte: R$"  . number_format($vl_transporte,2,',','.');
echo "<br><br><br>Salário final total: R$"  . number_format($sal_final,2,',','.');
}


?>