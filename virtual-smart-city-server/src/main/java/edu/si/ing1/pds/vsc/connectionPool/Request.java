package edu.si.ing1.pds.vsc.connectionPool;

public class Request {

    private String name_request;
    private Object data;

    public String getName_request() {
        return name_request;
    }

    public void setName_request(String name_request) {
        this.name_request = name_request;
    }

    public Object getData() {
        return data;
    }

    public Request() {

    }

    public void setData(Object data) {
        this.data = data;
    }
}
