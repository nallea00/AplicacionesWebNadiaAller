<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Employees</h3>
    <c:forEach items="${model.employees}" var="empl">
      <c:out value="${empl.name}"/><br><br>
    </c:forEach>
    
    <br>
    <a href="<c:url value="addemployee.htm"/>">Add Employee</a>
    <br>
    
  </body>
</html>