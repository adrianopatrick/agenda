package br.unifor.progweb.agenda.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unifor.progweb.agenda.bo.ContatosBO;
import br.unifor.progweb.agenda.entitys.Contatos;

@RequestScoped
@Path("/agenda/contatos")
public class AgendaResource {

	@Inject
	private ContatosBO contatoBO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarContatos() {
		List<Contatos> contatos = contatoBO.lerAgenda();
		if (contatos == null || contatos.isEmpty()) {
			return Response.status(Status.NO_CONTENT).build();
		}
		contatos.sort((Contatos o1, Contatos o2) -> o1.getNome().compareTo(o2.getNome()));

		return Response.ok(contatos).build();
	}

	@GET
	@Path("/contato/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarContato(@PathParam("id") Long id) {
		Contatos contato = contatoBO.buscarPorId(id);
		if (contato == null) {
			return Response.status(Status.NO_CONTENT).build();
		}
		return Response.ok(contato).build();
	}

	@POST
	@Path("/contato/{nome}/{telefone}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response novoContato(@PathParam("nome") String nome, @PathParam("telefone") String telefone) {
		Contatos contato = new Contatos();
		contato.setNome(nome);
		contato.setTelefone(telefone);
		contatoBO.inserirNovoContato(contato);
		return Response.ok().build();
	}

	@PUT
	@Path("/contato/{id}/{nome}/{telefone}")
	public Response atualizarContato(@PathParam("id") Long id, @PathParam("nome") String nome,
			@PathParam("telefone") String telefone) {

		Contatos contato = contatoBO.buscarPorId(id);
		contato.setNome(nome);
		contato.setTelefone(telefone);
		contatoBO.atualizarContato(contato);

		return Response.ok().build();
	}

	@PUT
	@Path("/contato/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarContato(@PathParam("id") Long id, Contatos contato) {
		Contatos contatoExistente = contatoBO.buscarPorId(id);
		if (contatoExistente == null) {
			throw new WebApplicationException(Status.NOT_MODIFIED);
		}
		contatoExistente.setNome(contato.getNome());
		contatoExistente.setTelefone(contato.getTelefone());
		contatoBO.atualizarContato(contatoExistente);
		return Response.ok().build();
	}

	@DELETE
	@Path("/contato/{id}")
	public Response deletarContato(@PathParam("id") Long id) {

		Contatos contato = contatoBO.buscarPorId(id);
		if (contato == null) {
			throw new WebApplicationException(Status.NOT_MODIFIED);
		}
		contatoBO.removerContato(contato);

		return Response.ok().build();
	}

}
