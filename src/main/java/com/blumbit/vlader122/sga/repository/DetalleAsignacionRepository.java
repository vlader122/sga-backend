package com.blumbit.vlader122.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blumbit.vlader122.sga.models.DetalleAsignacion;

@Repository
public interface DetalleAsignacionRepository extends JpaRepository<DetalleAsignacion, Long> {

}
