﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<jsp:useBean id="now" class="java.util.Date" />

<t:genericpage>
	<h1>Antwort-Liste</h1>
	<table style="border: 1px solid grey; background-color: #F8F8F8">
		<tr>
			<th>Zeitpunkt</th>
			<th>Test-Definition-ID</th>
			<th>Aktionen</th>
		</tr>
		<c:forEach items="${actionBean.responses}" var="response">
			<tr>
				<td>${response.timestamp}</td>
				<td>${response.test_id}</td>
				<td><stripes:link
						beanclass="de.fuberlin.chaostesting.ShowResponseXMLAction">
						<stripes:param name="id" value="${response.id}" />
				Anzeigen
			</stripes:link></td>
			</tr>
		</c:forEach>
	</table>
	<fmt:formatDate value="${now}" pattern="dd-MM-yyyy" />
</t:genericpage>
