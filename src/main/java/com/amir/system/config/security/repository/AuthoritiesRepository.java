package com.amir.system.config.security.repository;

import com.amir.system.config.security.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

    public Authorities save(Authorities entity);
}
