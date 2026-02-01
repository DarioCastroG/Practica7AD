package es.transportesamartin.assembler;

import es.transportesamartin.domain.Transportista;
import es.transportesamartin.dto.TransportistaDTO;
import org.springframework.stereotype.Component;

@Component
public class TransportistaAssembler {
    public TransportistaDTO toDTO(Transportista transportista){
        if(transportista == null) return null;

        TransportistaDTO dto = new TransportistaDTO();

        dto.setId(transportista.getId());
        dto.setNombre(transportista.getNombre());
        dto.setApellidos(transportista.getApellidos());
        dto.setDni(transportista.getDni());

        return dto;
    }

    public Transportista toEntity(TransportistaDTO dto) {
        if (dto == null) return null;

        Transportista transportista = new Transportista();
        mapCommonFields(dto, transportista);

        return transportista;
    }

    public void updateEntity(TransportistaDTO dto, Transportista transportista) {
        if (dto == null) return;

        mapCommonFields(dto,transportista);
    }
    public void mapCommonFields(TransportistaDTO dto, Transportista transportista) {
        transportista.setId(dto.getId());
        transportista.setNombre(dto.getNombre());
        transportista.setApellidos(dto.getApellidos());
        transportista.setDni(dto.getDni());
    }

}
