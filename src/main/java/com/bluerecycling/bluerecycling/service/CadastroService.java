//package com.bluerecycling.bluerecycling.service;
//
//import com.bluerecycling.bluerecycling.dto.CadastroDTO;
//import com.bluerecycling.bluerecycling.model.Cadastro;
//import com.bluerecycling.bluerecycling.repository.CadastroRepository;
//import com.bluerecycling.bluerecycling.repository.LoginRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CadastroService {
//    private final CadastroRepository cadastroRepository;
//
//    public CadastroService(CadastroRepository cadastroRepository) {
//
//        this.cadastroRepository = cadastroRepository;
//    }
//
//    public Cadastro adicionarCadastro(CadastroDTO cadastroDTO) {
//        Cadastro cadastroASerAdicionado = new Cadastro();
//        cadastroASerAdicionado.setCnpj(cadastroDTO.getCnpj());
//        cadastroASerAdicionado.setIdCadastro(cadastroDTO.getIdCadastro());
//        cadastroASerAdicionado.setSenha(cadastroDTO.getSenha());
//
//        Cadastro cadastro = findByCnpj(cadastroASerAdicionado.getCnpj());
//        if (cadastro != null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Cadastro" + cadastro.getCnpj() + "Já existe");
//        }
//        return cadastroRepository.save(cadastroASerAdicionado);
//    }
//
//    public Cadastro findByCnpj(String cnpj) {
//        return cadastroRepository.findByCnpj(cnpj);
//    }
//
//    public List<Cadastro> buscarTodos() {
//        return cadastroRepository.findAll();
//    }
//
//    public void deletar(String cnpj) {
//        Cadastro cadastroParaRemover = findByCnpj(cnpj);
//        if (cadastroParaRemover == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Não é possível remover cadastro inexistente");
//        }
//        cadastroRepository.delete(cadastroParaRemover);
//    }
//
//    public Cadastro atualizarSenhaPorId(String novaSenha, Long idCadastro) {
//
//        Optional<Cadastro> cadastroOptional = cadastroRepository.findById(idCadastro);
//        if (cadastroOptional.isPresent()) {
//            Cadastro cadastro = cadastroOptional.get();
//            cadastro.setSenha(novaSenha);
//            return cadastroRepository.save(cadastro);
//        } else {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Cadastro não encontrado com o id" + idCadastro);
//        }
//    }
//}

