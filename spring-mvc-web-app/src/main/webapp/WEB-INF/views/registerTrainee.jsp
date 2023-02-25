<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Trainee Page</title>
</head>
<body>
	<div align="center">
		<h2>Save Trainee Details</h2>
		<sform:form method="post" action="addtrainee" commandName="traineeCommand">
			<table border="1px">
				<tr>
					<td><sform:label path="traineeName">Trainee Name</sform:label></td>
					<td><sform:input path="traineeName"/></td>
				</tr>
				<tr>
					<td><sform:label path="marksScored">MarksScored</sform:label></td>
					<td><sform:input path="marksScored"/></td>
				</tr>
				<tr>
					<td><sform:label path="contactNumber">Contact Number</sform:label></td>
					<td><sform:input path="contactNumber"/></td>
				</tr>
				<tr>
					<td><input type="submit"/></td>
				</tr>
			</table>
		</sform:form>
	</div>

</body>
</html>