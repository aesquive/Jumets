        <%@page import="java.util.*" %>
        <%@page import="objetos.*" %>
        <%@page import="org.hibernate.*" %>
<%
int tipoActividad = Integer.parseInt(request.getParameter("tipoActividad"));
Session s = null;
Transaction tx = null;
Query q = null;

%>
<select name="sector" disabled onchange="onChangeSector()">
 <option>-Seleccione-</option>
  <%
    s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
    tx = s.beginTransaction();
    q = s.createQuery("from Srv  as srv where srv.calId = '6'");
    List it = (List) q.list();
    int limInf =-1;
    int limSup=-1;
    if(tipoActividad ==1)
    {
        limInf=0;
        limSup=4;
    }else if(tipoActividad ==2)
    {
        limInf=4;
        limSup=6;
    }

    if(tipoActividad <3){
    for(int i=limInf; i<limSup;i++){
        Srv srv = (Srv) it.get(i);
 %>
<option value="<%=srv.getSrvId()%>"><%=srv.getSrvDes()%></option>
 <%}
    }%>

</select>
