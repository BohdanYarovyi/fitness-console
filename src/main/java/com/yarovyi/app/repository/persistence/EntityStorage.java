package com.yarovyi.app.repository.persistence;

import com.yarovyi.app.exception.ObjectLoadingException;
import com.yarovyi.app.exception.ObjectSavingException;

import java.util.List;

public interface EntityStorage<T> {

    List<T> load() throws ObjectLoadingException;
    void save(List<T> entities) throws ObjectSavingException;

}
