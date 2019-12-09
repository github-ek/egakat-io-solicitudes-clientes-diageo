package com.egakat.io.clientes.diageo.service.impl;

import org.springframework.stereotype.Service;

import com.egakat.integration.dto.ActualizacionDto;
import com.egakat.io.clientes.diageo.service.api.DiageoSolicitudDespachoCrudService;
import com.egakat.io.commons.solicitudes.dto.SolicitudDespachoDto;
import com.egakat.io.commons.solicitudes.service.impl.SolicitudDespachoCrudServiceImpl;

import lombok.val;

@Service
public class DiageoSolicitudDespachoCrudServiceImpl extends SolicitudDespachoCrudServiceImpl
		implements DiageoSolicitudDespachoCrudService {

	@Override
	public void save(ActualizacionDto actualizacion, SolicitudDespachoDto solicitud) {
		try {
			val exists = getActualizacionesService().exists(actualizacion.getIntegracion(),
					actualizacion.getIdExterno());
			if (!exists) {
				create(solicitud);
			}
			getActualizacionesService().enqueue(actualizacion);
		} catch (Exception e) {
			getErroresService().create(actualizacion.getIntegracion(), actualizacion.getCorrelacion(), "", e);
		}
	}
}
