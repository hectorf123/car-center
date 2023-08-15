package com.car.center.controller;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.car.center.model.ServicioMantenimiento;
import com.car.center.payload.Estado;
import com.car.center.repository.ServiciosMantenimientosRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MecanicoControllerTest {

	@Autowired
	private ServiciosMantenimientosRepository serviciosMantenimientosRepository;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Test
	public void testBuscarServiciosPorDocumentoFechaEstado() {
		
		Long documento = 1014L;
        LocalDate fecha = LocalDate.now();
        Integer estado = Estado.MANTENIMIENTO_EN_PROGRESO;

        // Crear una lista de ServicioMantenimiento ficticia
        List<ServicioMantenimiento> resultadosEsperados = new ArrayList<>();
        // Agregar objetos ServicioMantenimiento a resultadosEsperados

        // Simular el comportamiento de EntityManager

        /*TypedQuery<ServicioMantenimiento> query = mock(TypedQuery.class);
        when(entityManager.createNativeQuery(anyString(), eq(ServicioMantenimiento.class))).thenReturn(query);
        lenient().when(query.setParameter(eq("documento"), anyLong())).thenReturn(query);
        lenient().when(query.setParameter(eq("fecha"), anyString())).thenReturn(query);
        lenient().when(query.setParameter(eq("estado"), anyInt())).thenReturn(query);
        when(query.getResultList()).thenReturn(resultadosEsperados);*/

        // Llamar al método del repositorio y verificar los resultados
        List<ServicioMantenimiento> resultados = serviciosMantenimientosRepository
                .buscarServiciosPorDocumentoFechaEstado(documento, fecha, estado);
        
        
        System.out.println("RESUL"+resultados.size());
        assertThat(resultados).isNotEmpty();
        // Realizar las verificaciones necesarias en los resultados
        // ...

        // Verificar que los métodos de EntityManager se llamen correctamente
        /*verify(entityManager).createNativeQuery(anyString(), eq(ServicioMantenimiento.class));
        verify(query).setParameter("documento", documento);
        verify(query).setParameter("fecha", fecha.toString()); // Convierte LocalDate a String en el formato adecuado
        verify(query).setParameter("estado", estado);
        verify(query).getResultList();*/
		
		
	}
	
	
	
}
