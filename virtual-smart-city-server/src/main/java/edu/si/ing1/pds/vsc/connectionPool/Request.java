package edu.si.ing1.pds.vsc.connectionPool;

public class Request {

    private String nameRequest;
    private Object data;

    public String getNameRequest() {
        return nameRequest;
    }

    public void setNameRequest(String nameRequest) {
        this.nameRequest = nameRequest;
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
