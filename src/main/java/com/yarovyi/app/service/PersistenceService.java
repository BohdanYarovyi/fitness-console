package com.yarovyi.app.service;

import com.yarovyi.app.repository.PersistenceRepository;

import java.util.ArrayList;
import java.util.List;

public class PersistenceService {
    private final List<PersistenceRepository> persistenceRepositories;

    public PersistenceService() {
        this.persistenceRepositories = new ArrayList<>();
    }

    public PersistenceService(List<PersistenceRepository> persistenceRepositories) {
        this.persistenceRepositories = persistenceRepositories;
    }

    public void addPersistenceRepository(PersistenceRepository persistenceRepository) {
        this.persistenceRepositories.add(persistenceRepository);
    }

    public void saveAll() {
        this.persistenceRepositories.forEach(PersistenceRepository::save);
    }

    public void loadAll() {
        this.persistenceRepositories.forEach(PersistenceRepository::load);
    }

}
