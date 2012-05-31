        <%@page import="java.util.*" %>
        <%@page import="objetos.*" %>
        <%@page import="org.hibernate.*" %>
<%
String cp = request.getParameter("codigoPostal");
String estado = "";
Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
Transaction tx = s.beginTransaction();
Query q = s.createQuery("from CodPos as cp where cp.codPosId='"+cp+"'");
List lista = (List) q.list();
if(lista.size()>0)
{
    CodPos codPos = (CodPos) lista.get(0);
    q = s.createQuery("from Edo as edo where edo.edoId="+codPos.getEdo().getEdoId());
    List lista2 = (List) q.list();
    estado = ((Edo) lista2.get(0)).getEdoDes();
    s.close();
}
%>
<input type="text" name="estado" disabled value="<%=estado%>"/>
