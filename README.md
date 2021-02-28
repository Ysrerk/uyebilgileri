# uyebilgileri

created two web servis 
birinci web serviste kullanici adi ve password alinip id,username ve password bilgisini donduyoruz.sonra donen bu id bilgisi ile ikinci  servisten uyeid si ile esleyp uye detaylarini aliyoruz

uye servisi
**************
<?php

include("baglan5.php");
$username=$_POST["username"];
$password=$_POST["password"];

class Uyeler{
    public $id="";
    public $username="";
    public $password="";
}

$uye=new Uyeler();
$kayitlar=mysqli_query($baglan,"select * from uyeler where username='$username' and password='$password'");
 while ($goster=mysqli_fetch_assoc($kayitlar)){
     $uye->id=$goster["id"];
     $uye->username=$goster["username"];
     $uye->password=$goster["password"];
     echo(json_encode($uye));
    
     
 }

?>

uye detay servisi
****************************
<?php

include("baglan5.php");

$id=$_POST["id"];

class uyebilgiler{
    
    public $id="";
    public $uyeid="";
    public $uyeadi="";
    public $uyeemail="";
    public $uyeresim="";
}

$uyebilgi=new uyebilgiler();
$uyebilgisi=mysqli_query($baglan,"select * from uyebilgiler where uyeid='$id'");
while($gozat=mysqli_fetch_assoc($uyebilgisi)){
    $uyebilgi->id=$gozat["id"];
    $uyebilgi->uyeid=$gozat["uyeid"];
    $uyebilgi->uyeadi=$gozat["uyeadi"];
    $uyebilgi->uyeemail=$gozat["uyeemail"];
    $uyebilgi->uyeresim=$gozat["uyeresim"];
    
    echo(json_encode($uyebilgi));
}



?>


sonra uye detay bilgilerini ikinci bir aktivitede gosterdik.uye resmi ile birlikte 
