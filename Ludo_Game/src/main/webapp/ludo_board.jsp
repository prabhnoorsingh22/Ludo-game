<%@ page import="java.util.* ,dal.asdc.ludo_board_structure.Ludo_board_formation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dal.asdc.model.Game_token_positions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="ludo_board.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ludo Game</title>
</head>
<body>
<%	
	Map<String,String> token_positions_map =(Map)request.getAttribute("token_path");
%>
<h1 style="padding-left:20px">   ${turn}</h1>
<h2 style="color:red">${error}</h2>

<button id="genAddress" onclick="location.href='/roll_dice'">
                Roll Dice
</button>
<div style="padding-left:20px">    ${dice_num}</div>
<div class="get_token_choice">
<form action="/token_select" method="POST">
<input id="text-box" type="text" name="token" value=${token}>
<input type="submit" value="Submit">
</form>
</div>

<div class="game">
    <div class="house green">
        <div class="box">
            <div class="square square-one green"><%=token_positions_map.get("{11,3}")%></div>
            <div class="square square-two green"><%=token_positions_map.get("{12,3}")%></div>
            <div class="square square-three green"><%=token_positions_map.get("{12,2}")%></div>
            <div class="square square-four green"><%=token_positions_map.get("{11,2}")%></div>
        </div>
    </div>

    <div class="house yellow" style="right: 0">
        <div class="box">
            <div class="square square-one yellow"><%=token_positions_map.get("{11,12}")%></div>
            <div class="square square-two yellow"><%=token_positions_map.get("{11,11}")%></div>
            <div class="square square-three yellow"><%=token_positions_map.get("{12,11}")%></div>
            <div class="square square-four yellow"><%=token_positions_map.get("{12,12}")%></div>
        </div>
    </div>

    <div class="house red" style="bottom: 0">
        <div class="box">
            <div class="square square-one red"><%=token_positions_map.get("{2,3}")%></div>
 			<div class="square square-two red"><%=token_positions_map.get("{3,3}")%></div>
 			<div class="square square-three red"><%=token_positions_map.get("{3,2}")%></div>
 			<div class="square square-four red"><%=token_positions_map.get("{2,2}")%></div>
        </div>
    </div>

    <div class="house blue" style="bottom: 0;right: 0">
        <div class="box">
            <div class="square square-one blue"><%=token_positions_map.get("{2,12}")%></div>
            <div class="square square-two blue"><%=token_positions_map.get("{2,11}")%></div>
            <div class="square square-three blue"><%=token_positions_map.get("{3,12}")%></div>
            <div class="square square-four blue"><%=token_positions_map.get("{3,11}")%></div>
        </div>
    </div>


    <div class="home"></div>
    <div class="cells" style="top: 40%;"><%=token_positions_map.get("{8,0}")%></div>
    <div class="cells g-start" style="top: 40%;left:6.66%;"><%=token_positions_map.get("{8,1}")%></div>
    <div class="cells" style="top: 40%;left:13.32%;"><%=token_positions_map.get("{8,2}")%></div>
    <div class="cells" style="top: 40%;left:19.98%;"><%=token_positions_map.get("{8,3}")%></div>
    <div class="cells" style="top: 40%;left:26.64%;"><%=token_positions_map.get("{8,4}")%></div>
    <div class="cells" style="top: 40%;left:33.3%;"><%=token_positions_map.get("{8,5}")%></div>

    <div class="cells" style="top: 0;left:40%;"><%=token_positions_map.get("{14,6}")%></div>
    <div class="cells" style="top: 6.66%;left:40%;"><%=token_positions_map.get("{13,6}")%></div>
    <div class="cells safe" style="top: 13.32%;left:40%;"><%=token_positions_map.get("{12,6}")%></div>
    <div class="cells" style="top: 19.98%;left:40%;"><%=token_positions_map.get("{11,6}")%></div>
    <div class="cells" style="top: 26.64%;left:40%;"><%=token_positions_map.get("{10,6}")%></div>
    <div class="cells" style="top: 33.3%;left:40%;"><%=token_positions_map.get("{9,6}")%></div>

    <div class="cells" style="top: 0;left:46.66%;"><%=token_positions_map.get("{14,7}")%></div>
    <div class="cells yellow" style="top: 6.66%;left:46.66%;"><%=token_positions_map.get("{13,7}")%></div>
    <div class="cells yellow" style="top: 13.32%;left:46.66%;"><%=token_positions_map.get("{12,7}")%></div>
    <div class="cells yellow" style="top: 19.98%;left:46.66%;"><%=token_positions_map.get("{11,7}")%></div>
    <div class="cells yellow" style="top: 26.64%;left:46.66%;"><%=token_positions_map.get("{10,7}")%></div>
    <div class="cells yellow" style="top: 33.3%;left:46.66%;"><%=token_positions_map.get("{9,7}")%></div>

    <div class="cells" style="top: 0;left:53.32%;"><%=token_positions_map.get("{14,8}")%></div>
    <div class="cells y-start" style="top: 6.66%;left:53.32%;"><%=token_positions_map.get("{13,8}")%></div>
    <div class="cells" style="top: 13.32%;left:53.32%;"><%=token_positions_map.get("{12,8}")%></div>
    <div class="cells" style="top: 19.98%;left:53.32%;"><%=token_positions_map.get("{11,8}")%></div>
    <div class="cells" style="top: 26.64%;left:53.32%;"><%=token_positions_map.get("{10,8}")%></div>
    <div class="cells" style="top: 33.3%;left:53.32%;"><%=token_positions_map.get("{9,8}")%></div>

    <div class="cells" style="top: 40%; right: 33.3%"><%=token_positions_map.get("{8,9}")%></div>
    <div class="cells" style="top: 40%;right:26.64%;"><%=token_positions_map.get("{8,10}")%></div>
    <div class="cells" style="top: 40%;right:19.98%;"><%=token_positions_map.get("{8,11}")%></div>
    <div class="cells safe" style="top: 40%;right:13.32%;"><%=token_positions_map.get("{8,12}")%></div>
    <div class="cells" style="top: 40%;right:6.66%;"><%=token_positions_map.get("{8,13}")%></div>
    <div class="cells" style="top: 40%;right:0;"><%=token_positions_map.get("{8,14}")%></div>

    <div class="cells blue" style="top: 46.66%; right: 33.3%"><%=token_positions_map.get("{7,9}")%></div>
    <div class="cells blue" style="top: 46.66%;right:26.64%;"><%=token_positions_map.get("{7,10}")%></div>
    <div class="cells blue" style="top: 46.66%;right:19.98%;"><%=token_positions_map.get("{7,11}")%></div>
    <div class="cells blue" style="top: 46.66%;right:13.32%;"><%=token_positions_map.get("{7,12}")%></div>
    <div class="cells blue" style="top: 46.66%;right:6.66%;"><%=token_positions_map.get("{7,13}")%></div>
    <div class="cells" style="top: 46.66%;right:0;"><%=token_positions_map.get("{7,14}")%></div>

    <div class="cells" style="top: 53.32%; right: 33.3%"><%=token_positions_map.get("{6,9}")%></div>
    <div class="cells" style="top: 53.32%;right:26.64%;"><%=token_positions_map.get("{6,10}")%></div>
    <div class="cells" style="top: 53.32%;right:19.98%;"><%=token_positions_map.get("{6,11}")%></div>
    <div class="cells" style="top: 53.32%;right:13.32%;"><%=token_positions_map.get("{6,12}")%></div>
    <div class="cells b-start" style="top: 53.32%;right:6.66%;"><%=token_positions_map.get("{6,13}")%></div>
    <div class="cells" style="top: 53.32%;right:0;"><%=token_positions_map.get("{6,14}")%></div>

    <div class="cells" style="bottom: 0;left:53.32%;"><%=token_positions_map.get("{0,8}")%></div>
    <div class="cells" style="bottom: 6.66%;left:53.32%;"><%=token_positions_map.get("{1,8}")%></div>
    <div class="cells safe" style="bottom: 13.32%;left:53.32%;"><%=token_positions_map.get("{2,8}")%></div>
    <div class="cells" style="bottom: 19.98%;left:53.32%;"><%=token_positions_map.get("{3,8}")%></div>
    <div class="cells" style="bottom: 26.64%;left:53.32%;"><%=token_positions_map.get("{4,8}")%></div>
    <div class="cells" style="bottom: 33.3%;left:53.32%;"><%=token_positions_map.get("{5,8}")%></div>

    <div class="cells" style="bottom: 0;left:46.66%;"><%=token_positions_map.get("{0,7}")%></div>
    <div class="cells red " style="bottom: 6.66%;left:46.66%;"><%=token_positions_map.get("{1,7}")%></div>
    <div class="cells red" style="bottom: 13.32%;left:46.66%;"><%=token_positions_map.get("{2,7}")%></div>
    <div class="cells red" style="bottom: 19.98%;left:46.66%;"><%=token_positions_map.get("{3,7}")%></div>
    <div class="cells red" style="bottom: 26.64%;left:46.66%;"><%=token_positions_map.get("{4,7}")%></div>
    <div class="cells red" style="bottom: 33.3%;left:46.66%;"><%=token_positions_map.get("{5,7}")%></div>

    <div class="cells" style="bottom: 0;left:40%;"><%=token_positions_map.get("{0,6}")%></div>
    <div class="cells r-start" style="bottom: 6.66%;left:40%;"><%=token_positions_map.get("{1,6}")%></div>
    <div class="cells" style="bottom: 13.32%;left:40%;"><%=token_positions_map.get("{2,6}")%></div>
    <div class="cells" style="bottom: 19.98%;left:40%;"><%=token_positions_map.get("{3,6}")%></div>
    <div class="cells" style="bottom: 26.64%;left:40%;"><%=token_positions_map.get("{4,6}")%></div>
    <div class="cells" style="bottom: 33.3%;left:40%;"><%=token_positions_map.get("{5,6}")%></div>

    <div class="cells" style="top: 53.32%; left: 33.3%"><%=token_positions_map.get("{6,5}")%></div>
    <div class="cells" style="top: 53.32%;left:26.64%;"><%=token_positions_map.get("{6,4}")%></div>
    <div class="cells" style="top: 53.32%;left:19.98%;"><%=token_positions_map.get("{6,3}")%></div>
    <div class="cells safe" style="top: 53.32%;left:13.32%;"><%=token_positions_map.get("{6,2}")%></div>
    <div class="cells" style="top: 53.32%;left:6.66%;"><%=token_positions_map.get("{6,1}")%></div>
    <div class="cells" style="top: 53.32%;left:0;"><%=token_positions_map.get("{6,0}")%></div>

    <div class="cells green" style="top: 46.66%;left: 33.3%"><%=token_positions_map.get("{7,5}")%></div>
    <div class="cells green" style="top: 46.66%;left:26.64%;"><%=token_positions_map.get("{7,4}")%></div>
    <div class="cells green" style="top: 46.66%;left:19.98%;"><%=token_positions_map.get("{7,3}")%></div>
    <div class="cells green" style="top: 46.66%;left:13.32%;"><%=token_positions_map.get("{7,2}")%></div>
    <div class="cells green" style="top: 46.66%;left:6.66%;"><%=token_positions_map.get("{7,1}")%></div>
    <div class="cells" style="top: 46.66%;left:0;"><%=token_positions_map.get("{7,0}")%></div>


</div>
<button id="genAddress" onclick="location.href='/reset_board'" style="padding-left:20px">
                Reset
</button>
<button id="genAddress" onclick="location.href='/back_to_menu'">
                Back To Menu
</button>
</body>
</html>