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
}
