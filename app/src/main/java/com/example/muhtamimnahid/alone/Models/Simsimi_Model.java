package com.example.muhtamimnahid.alone.Models;

public class Simsimi_Model {
    public String response;
    public String id;
    public int result;
    public String msg;

    public Simsimi_Model(String response, String id, int result, String msg) {

        this.response = response;
        this.id = id;
        this.result = result;
        this.msg = msg;
    }
    public Simsimi_Model(){

        }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
