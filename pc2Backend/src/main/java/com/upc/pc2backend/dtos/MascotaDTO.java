package com.upc.pc2backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {
    private Long idMascota;
    private String direccion;
    private Date fechaNacimiento;
    private Integer tamano;
    private String status;
}
