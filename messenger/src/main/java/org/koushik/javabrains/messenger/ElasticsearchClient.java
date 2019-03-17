package org.koushik.javabrains.messenger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.koushik.javabrains.messenger.model.ErrorRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class ElasticsearchClient {
	public static TransportClient getClient() throws UnknownHostException {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

		return client;
	}

	public Result saveToES(ErrorRequest errorObject) throws UnknownHostException, JsonProcessingException {
		TransportClient clientObj = getClient();
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse

		/*Map<String, Object> json = new HashMap<String, Object>();
		json.put("lineNumber",errorObject.getLineNumber());
		json.put("errorType",errorObject.getErrorType());
		json.put("errorMessage",errorObject.getErrorMsg());*/
	
		
		// generate json
		byte[] json = mapper.writeValueAsBytes(errorObject);
		System.out.println("saving in es");
		IndexResponse response = clientObj.prepareIndex("uierror", "_doc").setSource(json, XContentType.JSON).get();
		Result result = response.getResult();
		return result;
	}
}
