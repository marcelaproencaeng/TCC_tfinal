package com.bluerecycling.bluerecycling.service;

import com.bluerecycling.bluerecycling.dto.ResiduoDTO;
import com.bluerecycling.bluerecycling.model.Cadastro;
import com.bluerecycling.bluerecycling.model.Residuo;
import com.bluerecycling.bluerecycling.repository.LoginRepository;
import com.bluerecycling.bluerecycling.repository.ResiduoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ResiduoService {
    private final ResiduoRepository residuoRepository;

    public ResiduoService(ResiduoRepository residuoRepository) {
        this.residuoRepository = residuoRepository;
    }

    public Residuo adicionarResiduo(ResiduoDTO residuoDTO) {

        Residuo residuoASerAdicionado = new Residuo();
        residuoASerAdicionado.setIdResiduo(residuoDTO.getIdResiduo());
        residuoASerAdicionado.setNome(residuoDTO.getNome());
        residuoASerAdicionado.setCadastro(residuoDTO.getCadastro());
        residuoASerAdicionado.setNicho(residuoDTO.getNicho());
        residuoASerAdicionado.setValor(residuoDTO.getValor());
        residuoASerAdicionado.setQuantidade(residuoDTO.getQuantidade());
        residuoASerAdicionado.setClassificacao(residuoDTO.getClassificacao());

        Residuo residuo = findByName(residuoASerAdicionado.getNome());
        if (residuo != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Resíduo" + residuo.getNome() + "Já existe");
        }
        return residuoRepository.save(residuoASerAdicionado);
    }

    public Residuo findByName(String nome) {
        return residuoRepository.findByName(nome);
    }

    public List<Residuo> buscarTodos() {
        return residuoRepository.findAll();
    }

    public void deletar(String nome) {
        Residuo residuoParaRemover = findByName(nome);
        if (residuoParaRemover == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover resíduo inexistente");
        }
        residuoRepository.delete(residuoParaRemover);
    }


    public Residuo atualizarQuantidadePorId(Double novaQuantidade, Long idResiduo) {

        Optional<Residuo> residuoOptional = residuoRepository.findById(idResiduo);
        if (residuoOptional.isPresent()) {
            Residuo residuo = residuoOptional.get();
            residuo.setQuantidade(novaQuantidade);
            return residuoRepository.save(residuo);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Resíduo não encontrado com o id" + idResiduo);
        }
    }
}

