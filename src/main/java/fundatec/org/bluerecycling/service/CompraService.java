//package fundatec.org.bluerecycling.service;
//
//import fundatec.org.bluerecycling.dto.CriarCompraDTO;
//import fundatec.org.bluerecycling.dto.CriarResiduoDTO;
//import fundatec.org.bluerecycling.model.Compra;
//import fundatec.org.bluerecycling.model.Residuo;
//import fundatec.org.bluerecycling.model.Usuario;
//import fundatec.org.bluerecycling.repository.CompraRepository;
//import fundatec.org.bluerecycling.repository.ResiduoRepository;
//import fundatec.org.bluerecycling.repository.UsuarioRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CompraService {
//    private final CompraRepository compraRepository;
//    private final ResiduoRepository residuoRepository;
//    private final UsuarioRepository usuarioRepository;
//
//    public CompraService(CompraRepository compraRepository,
//                         ResiduoRepository residuoRepository,
//                         UsuarioRepository usuarioRepository) {
//        this.compraRepository = compraRepository;
//        this.residuoRepository = residuoRepository;
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    public BigDecimal adicionarCompra(CriarCompraDTO criarCompraDTO) {
//        Usuario usuario = usuarioRepository.findByCnpj(criarCompraDTO.getUsername());
//        if (usuario == null || !usuario.usuarioExists(usuario) || !usuario.userNameValue(usuario)) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Compra inválida" + usuario.getIdUsuario() +
//                            "usuário não corresponde aos requisitos necessários para compra.");
//        }
//        Compra novaCompra = new Compra();
//        novaCompra.setUsuarios((List<Usuario>) usuario);
//
//        List<Residuo> residuosDaCompra = new ArrayList<Residuo>();
//        List<CriarResiduoDTO> listaResiduosDTO = criarCompraDTO.getResiduos();
//        for (CriarResiduoDTO criarResiduoDTO : listaResiduosDTO) {
//            Residuo residuo = new Residuo();
//            residuo.setQuantidade(criarResiduoDTO.getQuantidade());
//            residuo.setValor(criarResiduoDTO.getValor());
//            residuosDaCompra.add(residuo);
//            residuoRepository.save(residuo);
//        }
//        novaCompra.setResiduos(residuosDaCompra);
//
//        compraRepository.save(novaCompra);
//
//
//        if (novaCompra.getResiduos().size() < 10.000) {
//            BigDecimal valorTotalDaCompra = calcularValorTotal(novaCompra);
//            compraRepository.save(novaCompra);
//            return valorTotalDaCompra;
//        }
//
//        if (novaCompra.getResiduos().size() >= 10.000) {
//            BigDecimal valorTotalDaCompra = calcularValorTotal(novaCompra);
//            BigDecimal valorTotalDaCompraComDesconto = BigDecimal.ZERO;
//            BigDecimal valorTotalDaCompraEmGrupo = BigDecimal.ZERO;
//            valorTotalDaCompraComDesconto = valorTotalDaCompra
//                    .subtract(valorTotalDaCompra.multiply(new BigDecimal(0.1)));
//            compraRepository.save(novaCompra);
//            return valorTotalDaCompra;
//
//        }
//        return null;
//    }
//
//    private BigDecimal calcularValorTotal(Compra compra) {
//        // Percorrer a Lista de Cervejas e somar todos os valores
//        // A soma desses valores deve ser retornada, representando o valor total do Pedido
//        BigDecimal valorTotalPedido = BigDecimal.ZERO;
//        BigDecimal valorTotalPedidoComQtdadeMaior = BigDecimal.ZERO;
//        for (Residuo residuo : compra.getResiduos()) {
//            // BigDecimal big1 = new BigDecimal("1078");
//            // BigDecimal big2 = new BigDecimal("1928");
//            // BigDecimal bigResult = big1.add(big2);
//            System.out.println(residuo.getNome());
//            // Somar todas as cervejas
//            valorTotalPedido = valorTotalPedido.add(residuo.getValor()).
//                    divide(valorTotalPedidoComQtdadeMaior);
//
//
//        }
//        return valorTotalPedido;
//    }
//
//    public ResponseEntity<Compra> arrecadarResiduosEmGrupo() {
//        int toneladasDesejadas = 10000;
//        int totalArrecadado = 0;
//        for (Usuario usuario : usuarios) {
//            int residuosRestantes = residuos.getResiduos();
//
//        }
//    }
//
//    private Integer calcularQtdadeTotalDoPedidoComQtdadeMaior(Compra compra, Usuario usuario) {
//        qtdadeTotalDoPedidoComQtdadeMaior = qtdadeTotalDoPedidoComQtdadeMaior + i;
//        for (Usuario usuario1 : compra.getUsuarios()) {
//            System.out.println(usuario.getCnpj());
//            qtdadeTotalDoPedidoComQtdadeMaior = qtdadeTotalDoPedidoComQtdadeMaior * (qtdadeTotalDoPedidoComQtdadeMaior);
//        }
//    }
//}
