package com.upc.pc2backend.controllers;

import com.upc.pc2backend.dtos.MascotaDTO;
import com.upc.pc2backend.entities.Mascota;
import com.upc.pc2backend.services.MascotaService;
import com.upc.pc2backend.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MascotaController {
    @Autowired
    public MascotaService mascotaService;
    @Autowired
    public DTOConverter dtoConverter;

    @GetMapping("/mascotas")
    public ResponseEntity<List<MascotaDTO>> obtenerMascotas(){
        List<Mascota> mascotas = mascotaService.listado();
        List<MascotaDTO> mascotaDTOS = mascotas.stream().map(mascota -> dtoConverter.convertToDto(mascota, MascotaDTO.class)).toList();
        return ResponseEntity.ok(mascotaDTOS);
    }

    @PostMapping("/mascota")
    public ResponseEntity<MascotaDTO> registrarMascota(@RequestBody MascotaDTO mascotaDTO){
        Mascota mascota = dtoConverter.convertToEntity(mascotaDTO, Mascota.class);
        try{
            mascota = mascotaService.registrar(mascota);
            mascotaDTO = dtoConverter.convertToDto(mascota, MascotaDTO.class);
            return ResponseEntity.ok(mascotaDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/mascota")
    public ResponseEntity<MascotaDTO> actualizarMascota(@RequestBody MascotaDTO mascotaDTO){
        Mascota mascota = dtoConverter.convertToEntity(mascotaDTO, Mascota.class);
        try {
            mascota = mascotaService.actualizaarMascota(mascota);
            mascotaDTO = dtoConverter.convertToDto(mascota, MascotaDTO.class);
            return ResponseEntity.ok(mascotaDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/mascota/{id}")
    public ResponseEntity<MascotaDTO> borrarMascota(@PathVariable Long id){
        try {
            Mascota mascota = mascotaService.borrarMascota(id);
            MascotaDTO mascotaDTO = dtoConverter.convertToDto(mascota, MascotaDTO.class);
            return ResponseEntity.ok(mascotaDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/mascota/{id}")
    public ResponseEntity<MascotaDTO> obtenerMascotaPorId(@PathVariable Long id){
        try {
            Mascota mascota = mascotaService.buscar(id);
            MascotaDTO mascotaDTO = dtoConverter.convertToDto(mascota, MascotaDTO.class);
            return ResponseEntity.ok(mascotaDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
