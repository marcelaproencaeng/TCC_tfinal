//package com.bluerecycling.bluerecycling.service;
//
//import com.bluerecycling.bluerecycling.dto.TransporteDTO;
//import com.bluerecycling.bluerecycling.model.Login;
//import com.bluerecycling.bluerecycling.model.Transporte;
//import com.bluerecycling.bluerecycling.model.Usuario;
//import com.bluerecycling.bluerecycling.repository.ResiduoRepository;
//import com.bluerecycling.bluerecycling.repository.TransacaoRepository;
//import com.bluerecycling.bluerecycling.repository.TransporteRepository;
//import com.bluerecycling.bluerecycling.repository.UsuarioRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Optional;
//
//@Service
//public class TransporteService {
//    private final TransporteRepository transporteRepository;
//
//    private final ResiduoRepository residuoRepository;
//
//    public TransporteService(TransporteRepository transporteRepository,
//                             ResiduoRepository residuoRepository) {
//        this.transporteRepository = transporteRepository;
//        this.residuoRepository = residuoRepository;
//    }
//
//    public Transporte adicionarTransporte(TransporteDTO transporteDTO) {
//
//        Transporte transporteASerAdicionado = new Transporte();
//        transporteASerAdicionado.setHasLicença(transporteDTO.getHasLicença());
//        transporteASerAdicionado.setIdTransporte(transporteDTO.getIdTransporte());
//
//        Optional<Transporte> transporte = findById(transporteASerAdicionado.getIdTransporte());
//        if (transporte.isPresent()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Transporte" + transporte.get().getIdTransporte()
//                    + "já existe!");
//        }
//        transporteRepository.save(transporteASerAdicionado);
//        return transporteASerAdicionado;
//    }
//
//    private Optional<Transporte> findById(Long idTransporte) {
//        return transporteRepository.findById(idTransporte);
//    }
//
//
//}
