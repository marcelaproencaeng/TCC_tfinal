package com.bluerecycling.bluerecycling.service;


import com.bluerecycling.bluerecycling.dto.CriarResiduoDTO;
import com.bluerecycling.bluerecycling.dto.CriarTransacaoDTO;
import com.bluerecycling.bluerecycling.dto.CriarUsuarioDTO;
import com.bluerecycling.bluerecycling.model.Residuo;
import com.bluerecycling.bluerecycling.model.Transacao;
import com.bluerecycling.bluerecycling.model.Usuario;
import com.bluerecycling.bluerecycling.repository.ResiduoRepository;
import com.bluerecycling.bluerecycling.repository.TransacaoRepository;
import com.bluerecycling.bluerecycling.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    private final UsuarioRepository usuarioRepository;
    private final ResiduoRepository residuoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository,
                            UsuarioRepository usuarioRepository, ResiduoRepository residuoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.residuoRepository = residuoRepository;
    }


    public BigDecimal adicionarTransacao(CriarTransacaoDTO criarTransacaoDTO) {
        Usuario usuario = usuarioRepository.findByRazaoSocial(criarTransacaoDTO.getRazaoSocial());
        if (usuario.hasCNPJ(usuario) == false | usuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Transacao inválida" + usuario.getIdUsuario() +
                            "usuário não possui cnpj e /ou não é cadastrado");

        }


        Transacao novaTransacao = new Transacao();
        novaTransacao.setUsuarios((List<Usuario>) usuario);
        transacaoRepository.save(novaTransacao);

        List<Residuo> residuosDaTransacao = new ArrayList<Residuo>();
        List<CriarResiduoDTO> listaResiduosDTO = criarTransacaoDTO.getResiduos();
        List<Usuario> usuariosDaTransacao = new ArrayList<Usuario>();
        List<CriarUsuarioDTO> listaUsuariosDTO = criarTransacaoDTO.getUsuarios();
        for (CriarResiduoDTO criarResiduoDTO : listaResiduosDTO) {
            Residuo residuo = new Residuo();
            residuo.setQuantidade(criarResiduoDTO.getQuantidade());
            residuo.setValor(criarResiduoDTO.getValor());
            residuo.setNome(criarResiduoDTO.getNome());
            residuo.setClassificacao(criarResiduoDTO.getClassificacao());
            residuosDaTransacao.add(residuo);
            residuoRepository.save(residuo);
        }
        novaTransacao.setResiduos(residuosDaTransacao);
        transacaoRepository.save(novaTransacao);

        for (CriarUsuarioDTO criarUsuarioDTO : listaUsuariosDTO) {
            Usuario usuario1 = new Usuario();
            usuario1.setIsVendedor(criarUsuarioDTO.getIsVendedor());
            usuario1.setResiduo(criarUsuarioDTO.getResiduo());
            usuario1.setPlano(criarUsuarioDTO.getPlano());
            usuario1.setHasTransporte(criarUsuarioDTO.getHasTransporte());
            usuariosDaTransacao.add(usuario1);
            usuarioRepository.save(usuario1);

        }
        novaTransacao.setUsuarios(usuariosDaTransacao);
        transacaoRepository.save(novaTransacao);

        if (novaTransacao.getResiduos().size() >= 2 | novaTransacao.getHasMaisDeDoisUsuarios()) {
            BigDecimal valorTotalDaTransacao = calcularValorTotal(novaTransacao);
            transacaoRepository.save(novaTransacao);
            return  valorTotalDaTransacao;


        }
        return  null;
    }

    private BigDecimal calcularValorTotal(Transacao transacao) {
        // Percorrer a Lista de Cervejas e somar todos os valores
        // A soma desses valores deve ser retornada, representando o valor total do Pedido
        BigDecimal valorTotalDaTransacao = BigDecimal.ZERO;
        BigDecimal numeroDeUsuariosParticipantesCompradores = BigDecimal.ZERO;
        for (Residuo residuo : transacao.getResiduos()) {
            // BigDecimal big1 = new BigDecimal("1078");
            // BigDecimal big2 = new BigDecimal("1928");
            // BigDecimal bigResult = big1.add(big2);
            System.out.println(residuo.getNome());
            // Somar todas as cervejas
            valorTotalDaTransacao = valorTotalDaTransacao.add(residuo.getValor());

        }
        for (Usuario usuario : transacao.getUsuarios()) {
            System.out.println(usuario.getResiduo().getQuantidade());
            valorTotalDaTransacao = valorTotalDaTransacao.divide(usuario.getResiduo().getValor());
        }


        return valorTotalDaTransacao;
    }

}


