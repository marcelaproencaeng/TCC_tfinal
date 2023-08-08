package com.bluerecycling.bluerecycling.service;

import com.bluerecycling.bluerecycling.dto.PlanoDTO;
import com.bluerecycling.bluerecycling.model.Plano;
import com.bluerecycling.bluerecycling.model.Usuario;
import com.bluerecycling.bluerecycling.repository.PlanoRepository;
import com.bluerecycling.bluerecycling.repository.ResiduoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public Plano adicionarPlano(PlanoDTO planoDTO) {
        Plano planoASerAdicionado = new Plano();

        planoASerAdicionado.setIdPlano(planoDTO.getIdPlano());
        planoASerAdicionado.setRenovarPlano(planoDTO.getRenovarPlano());
        planoASerAdicionado.setValor(planoDTO.getValor());
        planoASerAdicionado.setCredito(planoDTO.getCredito());
        planoASerAdicionado.setDataCriacao(planoDTO.getDataCriacao());

        Optional<Plano> plano = findById(planoASerAdicionado.getIdPlano());
        if (plano.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Plano" + plano.get().getIdPlano() + "Já existe");
        }
        return planoRepository.save(planoASerAdicionado);
    }

    private Optional<Plano> findById(Long idPlano) {

        return planoRepository.findById(idPlano);

    }

    public List<Plano> buscarTodos() {

        return planoRepository.findAll();
    }

    public void deletar(Usuario assinante) {
        Optional<Plano> planoParaRemover = findByAssinante(assinante);
        if (planoParaRemover.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover plano de usuário inexistente");
        }
        planoRepository.delete(planoParaRemover);
    }

    private Optional<Plano> findByAssinante(Usuario assinante) {
        return planoRepository.findByAssinante(assinante);

    }

    public Plano atualizarPlanoPorValor(Long idPlano, Double novoValor) {
        Optional<Plano> planoOptional = planoRepository.findById(idPlano);
        if (planoOptional.isPresent()) {
            Plano plano = planoOptional.get();
            plano.setValor(novoValor);
            return planoRepository.save(plano);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Plano não encontrado com o id" + idPlano);
        }
    }
}



