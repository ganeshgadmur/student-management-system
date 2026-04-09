
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial;
            text-align: center;
            margin-top: 100px;
            background: #f4f4f4;
        }
        .error-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            display: inline-block;
            box-shadow: 0 0 10px #ddd;
        }
        h1 { color: red; }
        a {
            color: white;
            background: #4CAF50;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="error-box">
        <h1>⚠️ Error!</h1>
        <h3>${error}</h3>
        <br/>
        <a href="/student">Go Back</a>
    </div>
</body>
</html>
