<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Formularios</title>
</head>
<body>
  

    <h1>Boletim</h1>

  
    <form method="post" action="#"> 
        Nome    : <input type="text" name="txtNome"><br>
        Prova 01: <input  type="text" name="txtp1"><br>
        Prova 02: <input  type="text" name="txtp2"><br>
        Trabalho: <input  type="text" name="txtTrabalho"><br>
        <input type="submit" value="Calcular">
        
    </form>
    
</body>
</html>

<?php
if($_POST){


$nome= $_POST['txtNome'];
$p1= $_POST['txtp1'];
$p2= $_POST['txtp2'];
$trabalho= $_POST['txtTrabalho'];

echo"<br>Nome: ".$nome;
echo"<br>P1  : ".$p1;
echo"<br>P2  : ".$p2;
echo"<br>Trablho: ".$trabalho;

$media = ($p1+$p2+$trabalho)/3;

echo "<br>Média: ".number_format($media,2,',','.');
}
?> 

