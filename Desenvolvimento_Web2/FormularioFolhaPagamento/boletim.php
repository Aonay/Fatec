    <?php

$nome= $_POST['txtNome'];
$p1= $_POST['txtp1'];
$p2= $_POST['txtp2'];
$trabalho= $_POST['txtTrabalho'];

echo"<br>Nome: ".$nome;
echo"<br>P1  : ".$p1;
echo"<br>P2  : ".$p2;
echo"<br>Trablho: ".$trabalho;

$media = ($p1+$p2+$trabalho)/3;

echo "<br>Média: ".$media;
?>