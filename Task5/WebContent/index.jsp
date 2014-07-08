<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table>
		<tr>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="command" value="parse_command" />
					<input type="hidden" name="parser" value="sax" /> <input
						type="hidden" name="filename" value="planes.xml" /> <input
						type="submit" value="SAX" />
				</form>
			</td>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="command" value="parse_command" />
					<input type="hidden" name="filename" value="Task5/planes.xml" /> <input
						type="hidden" name="parser" value="stax" /> <input type="submit"
						value="StAX" />
				</form>
			</td>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="command" value="parse_command" />
					<input type="hidden" name="filename" value="planes.xml" /> 
					<input type="hidden" name="parser" value="dom" /> 
						<input type="submit"
						value="DOM" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>