package com.upc.pc2backend.repositories;

import com.upc.pc2backend.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepositorie extends JpaRepository<Mascota, Long> {

}
