package br.unifor.progweb.agenda.rest;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RESTCorsRequestFilter implements ContainerResponseFilter, ContainerRequestFilter {

	private final static Logger log = Logger.getLogger(RESTCorsRequestFilter.class.getName());

	@Override
	public void filter(ContainerRequestContext requestCtx) throws IOException {
		log.info("Executing REST request filter");

		String path = requestCtx.getUriInfo().getPath();
		log.info(path);

		// When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
		if (requestCtx.getRequest().getMethod().equals("OPTIONS")) {
			log.info("HTTP Method (OPTIONS) - Detected!");

			// Just send a OK signal back to the browser
			requestCtx.abortWith(Response.status(Response.Status.OK).build());
		}
	}

	@Override
	public void filter(ContainerRequestContext requestCtx, ContainerResponseContext responseCtx) throws IOException {
		log.info("Executing REST response filter");

		responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseCtx.getHeaders().add("Access-Control-Allow-Credentials", "true");
		responseCtx.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
	}

}