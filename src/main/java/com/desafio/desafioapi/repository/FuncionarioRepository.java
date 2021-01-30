package com.desafio.desafioapi.repository;

import com.desafio.desafioapi.models.Funcionario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    Optional<Funcionario> findByIdFuncionario(long id);

    Optional<Funcionario> findByIdFuncionarioAndInAtivo(long id, String inAtivo);

    List<Funcionario> findAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE tb_funcionario " +
            "SET nm_funcionario =?1, ds_descricao =?2 " +
            "WHERE id_funcionario = ?3", nativeQuery = true)
    void atualizarFuncionario(String nmFuncionario, String dsDescricao, Long id);
}
