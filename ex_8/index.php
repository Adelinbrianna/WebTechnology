<!DOCTYPE html> 
<html lang="en"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <title>Document</title> 
</head> 
<body> 
<?php 
// Start php code 
// Load xml file into xml_data variable 
$xml_data = simplexml_load_file("xml.xml") or 
die("Error: Object Creation failure"); 
// Use foreach loop to display data and for sub elements access, // We will use children() function 
foreach ($xml_data->children() as $data) 
{ 
//display each sub element in xml file 
echo "First name : ", $data->first_name . "<br> "; 
echo "Last name : ", $data->last_name . "<br> "; 
echo " age : ", $data->age . "<br> "; 
echo "Height : ", $data->salary . "<br>"; 
echo "Weight : ", $data->gender . "<br>"; 
echo "------------------------------------"; 
echo "<br>"; 
} 
?> 
</body>
</html> 
