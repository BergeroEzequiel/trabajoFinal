package ar.edu.ucc.trabajoFinal.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PeticionPost {
	
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	OkHttpClient client = new OkHttpClient();

	public Response post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response;
	}
}
