package com.upc.pc2backend.services;

import com.upc.pc2backend.entities.Mascota;
import com.upc.pc2backend.repositories.MascotaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepositorie mascotaRepositorie;

    public Mascota registrar(Mascota mascota){
        return mascotaRepositorie.save(mascota);
    }
    public List<Mascota> listado(){
        return mascotaRepositorie.findAll();
    }

    public Mascota buscar(Long id) throws Exception {
        return mascotaRepositorie.findById(id).orElseThrow(() -> new Exception("No se encontro la mascota"));
    }

    public Mascota actualizaarMascota(Mascota mascota) throws Exception {
        mascotaRepositorie.findById(mascota.getIdMascota()).orElseThrow(() -> new Exception("No se encontro la mascota"));
        return mascotaRepositorie.save(mascota);
    }

    public Mascota borrarMascota(Long id) throws Exception {
        Mascota mascota = mascotaRepositorie.findById(id).orElseThrow(() -> new Exception("No se encontro la mascota"));
        mascotaRepositorie.delete(mascota);
        return mascota;
    }

}
