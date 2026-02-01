package es.transportesamartin.controller;

import es.transportesamartin.assembler.TransportistaAssembler;
import es.transportesamartin.domain.Transportista;
import es.transportesamartin.service.TransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transportista")
@CrossOrigin(origins ="*")
public class TransportistaController {
    @Autowired
    private TransportistaService transportistaService;
    private TransportistaAssembler transportistaAssembler;

    public TransportistaController(TransportistaService transportistaService, TransportistaAssembler transportistaAssembler) {
        this.transportistaService = transportistaService;
        this.transportistaAssembler = transportistaAssembler;
    }


    @GetMapping
    public List<Transportista> findAll(){
        return transportistaService.findAll().stream().map(transportistaAssembler::toDTO).collect(Collectors.toList());
    }
}
