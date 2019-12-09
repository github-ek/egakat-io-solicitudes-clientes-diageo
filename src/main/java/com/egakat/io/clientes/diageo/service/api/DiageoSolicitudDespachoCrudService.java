package com.egakat.io.clientes.diageo.service.api;

import org.springframework.transaction.annotation.Transactional;

import com.egakat.integration.dto.ActualizacionDto;
import com.egakat.io.commons.solicitudes.dto.SolicitudDespachoDto;
import com.egakat.io.commons.solicitudes.service.api.SolicitudDespachoCrudService;

public interface DiageoSolicitudDespachoCrudService extends SolicitudDespachoCrudService {

	@Transactional
	void save(ActualizacionDto actualizacion, SolicitudDespachoDto solicitud);
}
