<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title>Self Diagnosis</title>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>    
</head>
<body>
<div id="header">
    <tiles:insertAttribute name="header" />
</div>
<div id="menu">
    <tiles:insertAttribute name="menu" />
</div>
<div id="content">
    <tiles:insertAttribute name="body" />
</div>
<div id="footer" >
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>