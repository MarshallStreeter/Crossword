package core;


import java.awt.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class HtmlCreator {

	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS");
	File file = new File("Crossword_" + dateFormat.format(date) + ".html");
	PrintWriter out = new PrintWriter(file, "UTF-8");

	/**
	 * HtmlCreator constructor.
	 *
	 * @throws IOException
	 */
	public HtmlCreator(String puzzleHtml) throws IOException {
		createHtml(puzzleHtml);
		out.close();
		Desktop.getDesktop().browse(file.toURI());
	}

	/*
	 * Adds the header and beginning elements to the HTML.
	 */
	private void createHtml(String puzzleHtml) throws IOException {

		out.write("<!DOCTYPE html><html><head><meta charset='UTF-8'><title></title><style type='text/css'> body { font-family: 'Courier New'; font-size: 30px; margin: 0px; } .tile { padding:5px; background-color: white; color:white; display: inline-block; border:1px #ccc solid; width:40px; height:40px;text-align: center } .tileComplete {color:black} .ltr {  position: relative; left: -3px} .blacktile { padding:5px; background-color: black;display: inline-block;border: 1px black solid; width:40px; height:40px;text-align: center } #gameContainer { background-color:#eaeaea; padding:40px} #clueTable {width: 100%; background-color: white; padding-left: 20px; padding-bottom: 20px;} #settings:hover{transform: rotate(180deg);transition: all 300ms ease-in-out} #settings{transition: all 300ms ease-in-out; cursor:pointer} #options {display:none} .sm {  font-size: 16px;  position: relative;  right: 9px;  bottom: 12px; color:black} .theSolutionIsHere {display:none;}</style> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.6.1/spectrum.js'></script><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.6.1/spectrum.css' /></head><body> <form id='DefaultForm'> <div id='options' style='background-color:#f4f4f4; border-bottom:1px #ccc solid;padding:20px;font-size:18px'><div style='margin-bottom:10px'>Show Solution<input type='checkbox' id='showSolution' name='showSolution' value='1'></div><div style='margin-bottom:10px'>Show Clue Topics<input type='checkbox' id='showTopics' name='showTopics' value='1' checked=''></div><div style='margin-bottom:10px'>Show Blank Tiles<input type='checkbox' id='showBlanks' name='showBlanks' value='1' checked=''></div><div>Blank Tile Color <input type='text' id='colorPicker' /></div></div></div> <div id='gameContainer'> <div style='margin-left: auto;inline-block;margin-right: auto; display: table; overflow:auto; margin-bottom:20px'><img src='http://oi61.tinypic.com/2vv019j.jpg' style='float:left'><span style='margin-left: 10px;font-weight: bold;font-style: italic;'>Generated by Crosswords Admin</span><img id='settings' src='http://oi57.tinypic.com/2rrbb0x.jpg' style='float:right; margin-left:10px'></div> <div style='display:table;margin-left:auto;margin-right:auto; -webkit-box-shadow: 3px 3px 20px 3px #878787;box-shadow: 3px 3px 20px 3px #878787; padding:20px'>");

		out.write(puzzleHtml);

		out.write("</div></div></form>");

		out.write("<script>");

		//default color
		out.write("var activeColor = '#000';");

		//options toggle
		out.write("$(function(){");
		out.write("$('#settings').click(function(){");
		out.write("$('#options').slideToggle();");
		out.write("});");
		out.write("});");

		//toggle show solution
		out.write("$('#showSolution').change(function(){");
		out.write("if($(this).is(':checked')) {");
		out.write("$('.theSolutionIsHere').show();");
		out.write("}");
		out.write("else{");
		out.write("$('.theSolutionIsHere').hide();");
		out.write("}");
		out.write("});");

	    //toggle show topics
        out.write("$('#showTopics').change(function(){");
        out.write("if($(this).is(':checked')) {");
        out.write("$('.clueTopicsDisplay').show();");
        out.write("}");
        out.write("else{");
        out.write("$('.clueTopicsDisplay').hide();");
        out.write("}");
        out.write("});");

		//show blanks checkbox
		out.write("$('#showBlanks').change(function() {");
		out.write("if($(this).is(':checked')) {");
		out.write("$('.blacktile').css('background-color', activeColor);");
		out.write("$('.blacktile').css('color', activeColor);");
		out.write("$('.blacktile').css('border', '1px ' + activeColor + ' solid');");
		out.write("}");
		out.write("else {");
		out.write("$('.blacktile').css('background-color', '#eaeaea');");
		out.write("$('.blacktile').css('color', '#eaeaea');");
		out.write("$('.blacktile').css('border', '1px #eaeaea solid');");
		out.write("}");
		out.write("});");

		//colorpicker
		out.write("$('#colorPicker').spectrum({");
		out.write("showButtons: false,");
		out.write("color: '#000',");
		out.write("move: function(color){");
		out.write("activeColor = color.toHexString();");
		out.write("$('.blacktile').css('background-color', color.toHexString());");
		out.write("$('.blacktile').css('color', color.toHexString());");
		out.write("$('.blacktile').css('border', '1px ' + color.toHexString() + ' solid');");
		out.write("}");
		out.write("});");

		out.write("</script>");

		out.write("</body></html>");

	}
}
