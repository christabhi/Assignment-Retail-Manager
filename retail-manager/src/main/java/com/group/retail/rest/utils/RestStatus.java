package com.group.retail.rest.utils;

public class RestStatus<T> {

	public String RequestID= ThreadLocalClass.getID();
	
	public int status;
	
	public String message;
	
	public String id;
	
	public String value;
	
	public T data;
	
	public RestStatus(int status, String message, String id, T data)
	{
		this.status = status;
		this.message = message;
		this.id = id;
		
		if (data!= null && data.getClass() == String.class )
		{
			this.value = (String) data;
			
		} else {
			
			this.data = data;
		}
	}
	
    public RestStatus(int status, String message)
    {
        this(status, message, null,null);
    }
    
    public RestStatus(int status, String message, T data)
    {
        this(status, message, null,data);
    }
    
    public String toJsonString()
    {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("{");
    	stringBuilder.append("\"RequestID\"");
    	stringBuilder.append(":");
    	stringBuilder.append(RequestID);
    	stringBuilder.append(",");
    	
    	stringBuilder.append("\"status\"");
    	stringBuilder.append(":");
    	stringBuilder.append(status);
    	stringBuilder.append(",");
    	stringBuilder.append("\"data\"");
    	stringBuilder.append(":");
    	stringBuilder.append(value);
    	stringBuilder.append("}");
    	
    	return stringBuilder.toString();
    }
}
