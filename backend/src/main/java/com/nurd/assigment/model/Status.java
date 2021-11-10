package com.nurd.assigment.model;

public enum Status {
    Todo(1),
    Done(2),
    Deleted(3);
    private long status;

    Status(long status){
        this.status = status;
    }
    public long getStatus(){return this.status;}
}
