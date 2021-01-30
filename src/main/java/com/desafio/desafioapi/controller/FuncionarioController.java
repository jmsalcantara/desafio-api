package com.desafio.desafioapi.controller;

import com.desafio.desafioapi.models.Funcionario;
import com.desafio.desafioapi.models.FuncionarioRequest;
import com.desafio.desafioapi.repository.FuncionarioRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @ApiOperation(value = "Obter um funcionário a partir do código")
    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET, produces="application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> obterFuncionarioById (@PathVariable Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findByIdFuncionarioAndInAtivo(id, "S");

        return optionalFuncionario
                .map(funcionario -> new ResponseEntity<>(funcionario, HttpStatus.FOUND))
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Obtém uma lista de funcionários")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/funcionarios")
    public List<FuncionarioRequest> obterFuncionarios() {
        List<Funcionario> listFuncionarios = funcionarioRepository.findAll();
        List<FuncionarioRequest> listFuncionariosRequest = new ArrayList<>();
        if (listFuncionarios != null && listFuncionarios.size() > 0) {
            for (Funcionario funcionario : listFuncionarios) {
                FuncionarioRequest funcionarioRequest = new FuncionarioRequest();
                if ("S".equals(funcionario.getInAtivo())) {
                    funcionarioRequest.setIdFuncionario(funcionario.getIdFuncionario());
                    funcionarioRequest.setNmFuncionario(funcionario.getNmFuncionario());
                    funcionarioRequest.setDsDescricao(funcionario.getDsDescricao());
                    funcionarioRequest.setDsDepartamento(funcionario.getDsDepartamento());
                    funcionarioRequest.setDsFuncao(funcionario.getDsFuncao());
                    listFuncionariosRequest.add(funcionarioRequest);
                }
            }
        }
        return listFuncionariosRequest;
    }

    @ApiOperation(value = "Cadastrar um funcionário")
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/funcionario")
    @Transactional
    void cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCadastrado = funcionarioRepository.save(funcionario);
    }

    @ApiOperation(value = "Atualizar nome e descrição de um funcionário")
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/funcionario")
    @Transactional
    public ResponseEntity<Funcionario> atualizarFuncionario(@RequestBody Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionarioAtualizar = funcionarioRepository.findById(funcionario.getIdFuncionario());
        if (optionalFuncionarioAtualizar.isPresent()) {
            optionalFuncionarioAtualizar.get().setNmFuncionario(funcionario.getNmFuncionario());
            optionalFuncionarioAtualizar.get().setDsDescricao(funcionario.getDsDescricao());
            funcionarioRepository.save(optionalFuncionarioAtualizar.get());
        }

        return optionalFuncionarioAtualizar.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @ApiOperation(value = "Deletar um funcionário a partir do código")
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/funcionario/{id}")
    void deletarFuncionarioById (@PathVariable Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findByIdFuncionario(id);
        if (optionalFuncionario.isPresent()) {
            optionalFuncionario.get().setInAtivo("N");
            funcionarioRepository.save(optionalFuncionario.get());
        }
    }
}
