package com.example.test.serviceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Result<T> {
    private  int code;
    private  String message=" ";
    private T data;
    public  void setCode(int code){
        this.code=code;
    }
    public  int getCode(){
        return code;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
    public  void setData(T data){
        this.data=data;
    }
    public  T getData(){
        return data;
    }

    public void modfiy(){

        switch (this.code){
            case 0:this.message="No have ";break;
            case 1:this.message="have";break;

            default:this.message="this name not only one!";
        }
    }

}
