<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <%for (Category categorie : categories) {%>
      <a class="navbar-brand" id="categorie" href="afficherProduitsCategory?idCategory=<%=categorie.getId()%>"><%=categorie.getName()%></a>
      <%}%>
</nav>
