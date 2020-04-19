package com.casino.app.db;

import com.casino.app.exception.ResourceNotFound;

import org.jooq.Record;

public abstract class BaseRepository<T> {
    public T r(Record resource,Class c) throws Exception{
        if(resource == null){
            throw new ResourceNotFound(c.getSimpleName()+ " not found");
        }
        return (T)resource.into(c);
    }
}