package es.transportesamartin.assembler;

import es.transportesamartin.domain.Ruta;
import es.transportesamartin.dto.RutaDTO;

public class RutaAssembler {
    public RutaDTO toDTO(Ruta ruta){
        if(ruta == null) return null;

        RutaDTO dto = new RutaDTO();

        dto.setId(ruta.getId());
        dto.setPuntoDeSalida(ruta.getPuntoDeSalida());
        dto.setPuntoDeEntrada(ruta.getPuntoDeDestino());
        dto.setDistancia(ruta.getDistancia());
        dto.setTiempoEstimado(ruta.getTiempoEstimado());

        return dto;
    }

    public Ruta toEntity(RutaDTO dto) {
        if (dto == null) return null;

        Ruta ruta = new Ruta();
        mapCommonFields(dto, ruta);

        return ruta;
    }

    public void updateEntity(RutaDTO dto, Ruta ruta) {
        if (dto == null) return;

        mapCommonFields(dto,ruta);
    }
    public void mapCommonFields(RutaDTO dto, Ruta ruta) {
        dto.setId(ruta.getId());
        dto.setPuntoDeSalida(ruta.getPuntoDeSalida());
        dto.setPuntoDeEntrada(ruta.getPuntoDeDestino());
        dto.setDistancia(ruta.getDistancia());
        dto.setTiempoEstimado(ruta.getTiempoEstimado());
    }
}
