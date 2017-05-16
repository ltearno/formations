<%@page import="org.pegdown.PegDownProcessor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col s8 offset-s2">
		<form method="post">
			<c:forEach items="${questions}" var="question">
				<div style="padding: 1em; margin: 2em;" class="z-depth-1">
					<div>${question.texte}</div>
					<div>
						<div style="clear: both;"></div>
						<table>
							<col style="width: 2em;">
							<col>
							<c:forEach items="${question.reponses}" var="reponse">
								<tr>
									<td>
										<p>
											<input id="reponse${reponse.id}" type="checkbox" name="reponse${reponse.id}" /> <label for="reponse${reponse.id}"></label>
										</p>
									</td>
									<td>${reponse.texte}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</c:forEach>

			<div style="padding: 1em; margin: 2em;">
				<button class="waves-effect waves-light btn" role="submit">
					Envoyer et continuer<i class="material-icons right">send</i>
				</button>
			</div>

			<div>${nbRestant} question(s) restante(s)</div>
		</form>
	</div>
</div>