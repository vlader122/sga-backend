package com.blumbit.vlader122.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blumbit.vlader122.sga.models.Activo;

@Repository
public interface ActivoRepository extends JpaRepository<Activo, Long> {

}
