<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>

<t:genericpage>
	<h1>Testausführung</h1>
	<stripes:form beanclass="de.fuberlin.chaostesting.ExecuteAllTestsAction">
		OSST URL: <stripes:text name="url"/><br>
		<stripes:submit name="executeAllTests"/>
	</stripes:form>
</t:genericpage>
