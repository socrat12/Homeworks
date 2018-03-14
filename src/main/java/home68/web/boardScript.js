function printChessBoard() {
	document.writeln("<table id='table'>");
	var black = 0;
	for (var i = 0; i < 8; i++) {
		document.writeln("<tr>");
		for (var j = 0; j < 8; j++) {
			if (black % 2 == 0) document.writeln('<td>');
			else document.writeln('<td class="black">');
			document.writeln("</td>");
			black++;
		}
		document.writeln("</tr>");
		black++;
	}
	document.writeln("</table>");
} 
