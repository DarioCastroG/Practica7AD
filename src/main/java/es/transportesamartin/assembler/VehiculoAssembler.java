package es.transportesamartin.assembler;


import es.transportesamartin.domain.Vehiculo;
import es.transportesamartin.dto.VehiculoDTO;

public class VehiculoAssembler {
    public VehiculoDTO toDTO(Vehiculo vehiculo){
        if(vehiculo == null) return null;

        VehiculoDTO dto = new VehiculoDTO();

        dto.setId(vehiculo.getId());
        dto.setMatricula(vehiculo.getMatricula());
        dto.setMarca(vehiculo.getMarca());
        dto.setModelo(vehiculo.getModelo());
        dto.setKilometraje(vehiculo.getKilometraje());

        return dto;
    }

    public Vehiculo toEntity(VehiculoDTO dto) {
        if (dto == null) return null;

        Vehiculo vehiculo = new Vehiculo();
        mapCommonFields(dto, vehiculo);

        return vehiculo;
    }

    public void updateEntity(VehiculoDTO dto, Vehiculo vehiculo) {
        if (dto == null) return;

        mapCommonFields(dto,vehiculo);
    }
    public void mapCommonFields(VehiculoDTO dto, Vehiculo vehiculo) {
        dto.setId(vehiculo.getId());
        dto.setMatricula(vehiculo.getMatricula());
        dto.setMarca(vehiculo.getMarca());
        dto.setModelo(vehiculo.getModelo());
        dto.setKilometraje(vehiculo.getKilometraje());
    }
}
