package com.car.center.payload;

import lombok.Data;

@Data
public class Estado {

    public static final Integer MANTENIMIENTO_EN_PROGRESO = 1;
    public static final Integer MANTENIMIENTO_TERMINADO = 2;

    private Estado() {
 
    }
	
}
