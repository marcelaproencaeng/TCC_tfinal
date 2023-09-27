package fundatec.org.bluerecycling.service;

import fundatec.org.bluerecycling.dto.CriarResiduoDTO;
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

    public Residuo adicionarResiduo(CriarResiduoDTO criarResiduoDTO) {

        Residuo residuoASerAdicionado = new Residuo();
        residuoASerAdicionado.setNome(criarResiduoDTO.getNome());
        residuoASerAdicionado.setDescricao(criarResiduoDTO.getDescricao());
        residuoASerAdicionado.setLocal(criarResiduoDTO.getLocal());
        residuoASerAdicionado.setDataCriacao(criarResiduoDTO.getDataCriacao());
        residuoASerAdicionado.setClassificacao(criarResiduoDTO.getClassificacao());
        residuoASerAdicionado.setNicho(criarResiduoDTO.getNicho());
        residuoASerAdicionado.setQuantidade(criarResiduoDTO.getQuantidade());
        residuoASerAdicionado.setValor(criarResiduoDTO.getValor());
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
