package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.ResiduoDTO;
import fundatec.org.bluerecycling.model.Residuo;
import fundatec.org.bluerecycling.repository.ResiduoRepository;
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
        residuoASerAdicionado.setClassificacao(residuoDTO.getClassificacao());
        residuoASerAdicionado.setNicho(residuoDTO.getNicho());
        residuoASerAdicionado.setQuantidade(residuoDTO.getQuantidade());
        residuoASerAdicionado.setValor(residuoDTO.getValor());
        Residuo residuo = findByNome(residuoASerAdicionado.getNome());

        if (residuo != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Resíduo" + residuo.getNome() + "Já existe");
        }
        return residuoRepository.save(residuoASerAdicionado);
    }

    public Residuo findByNome(String nome) {
        return residuoRepository.findByNome(nome);
    }

    public List<Residuo> buscarTodos() {
        return residuoRepository.findAll();
    }

    public void deletar(String nome) {
        Residuo residuoParaRemover = findByNome(nome);
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
