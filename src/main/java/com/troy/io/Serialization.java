package com.troy.io;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Date;

public class Serialization
{
	public static void main(String[] arg) throws Exception
	{
		ObjectOutputStream objectOutputStream1 = null;
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
				"Serialization.txt"));
			 ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(
					 "Serialization.txt"))
		)
		{
			objectOutputStream.writeObject(new SerializationObject().setA("11"));
			objectOutputStream.close();
			objectOutputStream.close();
			SerializationObject b = (SerializationObject) objectInputStream.readObject();
			System.out.println(b);
			System.out.println(Inet4Address.getLocalHost());

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class SerializationObject implements Serializable
{

	private String a;
	private String b;

	public String getB()
	{
		return b;
	}

	public SerializationObject setB(String b)
	{
		this.b = b;
		return this;
	}

	public String getA()
	{
		return a;
	}

	public SerializationObject setA(String a)
	{
		this.a = a;
		return this;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"a\":\"")
				.append(a).append('\"');
		sb.append(",\"b\":\"")
				.append(b).append('\"');
		sb.append('}');
		return sb.toString();
	}
}
