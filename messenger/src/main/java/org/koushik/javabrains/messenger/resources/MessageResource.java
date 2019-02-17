package org.koushik.javabrains.messenger.resources;

import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.koushik.javabrains.messenger.ElasticsearchClient;
import org.koushik.javabrains.messenger.model.ErrorRequest;
import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Result addMessage(ErrorRequest err) throws UnknownHostException {
		// TODO CALL THE METHOD WHICH WILL SAVE DATA TO ELASTICSEARCH
		ElasticsearchClient obj = new ElasticsearchClient();
		return obj.saveToES(err);
		

	}
/*
	public void callingElasticSearch() {
		Client client = new PreBuiltTransportClient(
				Settings.builder().put("client.transport.sniff", true).put("cluster.name", "elasticsearch").build())
						.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
	}*/

	

	/*
	 * @GET
	 * 
	 * @Path("/{messageId}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Message
	 * getMessage(@PathParam("messageId") long id) { return
	 * messageService.getMessage(id);
	 * 
	 * }
	 */
}
