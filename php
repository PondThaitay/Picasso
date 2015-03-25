<?php

$con=mysql_connect("localhost","Username","Password")or die("cannot connect");
mysql_select_db("Database Name")or die("cannot select DB");

$strWhere = $_POST["ID"];

$sql = "select * from TableName WHERE ColumnsName = '".$strWhere."' ";

$objQuery = mysql_query($sql);
$obResult = mysql_fetch_array($objQuery);

if($objQuery)
{
    $arr['Name'] = $obResult["Username"];
}

mysql_close($con);
echo json_encode($arr);
?>
