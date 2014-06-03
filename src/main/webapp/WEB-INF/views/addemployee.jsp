<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="addemployee.heading"/></h1>
<form:form method="post" commandName="addEmployee">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Name:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
        <td width="60%">
          <form:errors path="name" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Surname:</td>
        <td width="20%">
          <form:input path="surname"/>
        </td>
        <td width="60%">
          <form:errors path="surname" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Address:</td>
        <td width="20%">
          <form:input path="address"/>
        </td>
        <td width="60%">
          <form:errors path="address" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Salary:</td>
        <td width="20%">
          <form:input path="salary"/>
        </td>
        <td width="60%">
          <form:errors path="salary" cssClass="error"/>
        </td>
    </tr>    
    <tr>
      <td align="right" width="20%">DNI:</td>
        <td width="20%">
          <form:input path="dni"/>
        </td>
        <td width="60%">
          <form:errors path="dni" cssClass="error"/>
        </td>
    </tr> 
     <tr>
      <td align="right" width="20%">Id Office:</td>
        <td width="20%">
          <form:input path="idenOffice"/>
        </td>
        <td width="60%">
          <form:errors path="idenOffice" cssClass="error"/>
        </td>
    </tr> 
  </table>
  <br>
  <input type="submit" value="Execute">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>