package com.xc3fff0e.xmanager;

import com.google.gson.Gson;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestNetworkController {
public static final String GET      = "GET";
public static final String POST     = "POST";
public static final String PUT      = "PUT";
public static final String DELETE   = "DELETE";

public static final int REQUEST_PARAM = 0;
public static final int REQUEST_BODY  = 1;

private static final int SOCKET_TIMEOUT = 15000;
private static final int READ_TIMEOUT   = 25000;

protected OkHttpClient client;

private static RequestNetworkController mInstance;

public static synchronized RequestNetworkController getInstance() {
if(mInstance == null) {
mInstance = new RequestNetworkController();
}
return mInstance;
}

private OkHttpClient getClient() {
if (client == null) {
OkHttpClient.Builder builder = new OkHttpClient.Builder();

try {
final TrustManager[] trustAllCerts = new TrustManager[]{
new X509TrustManager() {
@Override
public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
throws CertificateException {
}

@Override
public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
throws CertificateException {
}

@Override
public java.security.cert.X509Certificate[] getAcceptedIssuers() {
return new java.security.cert.X509Certificate[]{};
}
}
};

final SSLContext sslContext = SSLContext.getInstance("TLS");
sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
builder.connectTimeout(SOCKET_TIMEOUT, TimeUnit.MILLISECONDS);
builder.readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);
builder.writeTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);
builder.hostnameVerifier(new HostnameVerifier() {
@Override
public boolean verify(String hostname, SSLSession session) {
return true;
}
});
} catch (Exception e) {
}

client = builder.build();
}

return client;
}

public void execute(final RequestNetwork requestNetwork, String method, String url, final String tag, final RequestNetwork.RequestListener requestListener) {
Request.Builder reqBuilder = new Request.Builder();
Headers.Builder headerBuilder = new Headers.Builder();

if(requestNetwork.getHeaders().size() > 0) {
HashMap<String, Object> headers = requestNetwork.getHeaders();

for(HashMap.Entry<String, Object> header : headers.entrySet()) {
headerBuilder.add(header.getKey(), String.valueOf(header.getValue()));
}
}

try {
if (requestNetwork.getRequestType() == REQUEST_PARAM) {
if (method.equals(GET)) {
HttpUrl.Builder httpBuilder;

try {
httpBuilder = HttpUrl.parse(url).newBuilder();
} catch (NullPointerException ne) {
throw new NullPointerException("unexpected url: " + url);
}

if (requestNetwork.getParams().size() > 0) {
HashMap<String, Object> params = requestNetwork.getParams();

for (HashMap.Entry<String, Object> param : params.entrySet()) {
httpBuilder.addQueryParameter(param.getKey(), String.valueOf(param.getValue()));
}
}

reqBuilder.url(httpBuilder.build()).headers(headerBuilder.build()).get();
} else {
FormBody.Builder formBuilder = new FormBody.Builder();
if (requestNetwork.getParams().size() > 0) {
HashMap<String, Object> params = requestNetwork.getParams();

for (HashMap.Entry<String, Object> param : params.entrySet()) {
formBuilder.add(param.getKey(), String.valueOf(param.getValue()));
}
}

RequestBody reqBody = formBuilder.build();

reqBuilder.url(url).headers(headerBuilder.build()).method(method, reqBody);
}
} else {
RequestBody reqBody = RequestBody.create(okhttp3.MediaType.parse("application/json"), new Gson().toJson(requestNetwork.getParams()));

if (method.equals(GET)) {
reqBuilder.url(url).headers(headerBuilder.build()).get();
} else {
reqBuilder.url(url).headers(headerBuilder.build()).method(method, reqBody);
}
}

Request req = reqBuilder.build();

getClient().newCall(req).enqueue(new Callback() {
@Override
public void onFailure(Call call, final IOException e) {
requestNetwork.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
requestListener.onErrorResponse(tag, e.getMessage());
}
});
}

@Override
public void onResponse(Call call, final Response response) throws IOException {
final String responseBody = response.body().string().trim();
requestNetwork.getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
requestListener.onResponse(tag, responseBody);
}
});
}
});
} catch (Exception e) {
requestListener.onErrorResponse(tag, e.getMessage());
}
}
}