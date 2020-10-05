<%
    for( Trainer trainer : trainers ) {
%>
<div class="trainer">

    <span class="name"><%= trainer.getName() %></span>

    <%
        for( Pokemon pokemon : trainer.getTeam() ) {
    %>
        <div class="pokemon">
            <p><%=pokemon.getName()%></p> <span class="label"><%=pokemon.getLevel()%></span>
            <img src="<%=pokemon.getType().getSprite()%>"/>
        </div>
    <%
        }
    %>

</div>
<%
    }
%>