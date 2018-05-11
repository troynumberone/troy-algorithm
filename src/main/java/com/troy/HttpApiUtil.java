package com.troy;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;



public class HttpApiUtil
{



	private static PoolingHttpClientConnectionManager cm = null;

	static
	{
		LayeredConnectionSocketFactory sslsf = null;
		try
		{
			sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
		}
		catch (NoSuchAlgorithmException e)
		{
			System.out.println("创建SSL连接失败");
		}
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("https", sslsf)
				.register("http", new PlainConnectionSocketFactory())
				.build();
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		cm.setMaxTotal(200);
		cm.setDefaultMaxPerRoute(20);
	}

	public static CloseableHttpClient getHttpClient()
	{
		CloseableHttpClient httpClient = HttpClients.custom()
				.setConnectionManager(cm)
				.build();
		return httpClient;
	}

	public static RequestConfig getRequestConfig()
	{
		return RequestConfig.custom()
				.setConnectionRequestTimeout(20000)
				.setConnectTimeout(5000)
				.setSocketTimeout(5000).build();
	}
}
