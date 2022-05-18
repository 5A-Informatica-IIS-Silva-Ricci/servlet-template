    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!doctype html>
        <html lang="it">
        <head>
        <meta charset="UTF-8">

        <title>Titolo</title>

        </head>
        <body>
            <%= request.getParameter("beanRisposta"); %>
        </body>
        </html>
