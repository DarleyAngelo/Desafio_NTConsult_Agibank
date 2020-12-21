package br.com.desafio.simulacao.service;

import br.com.desafio.simulacao.entity.Restricao;

import java.util.Optional;

public interface RestricaoService {

    Restricao save(Restricao restricao);
    Optional<Restricao> findByCpf(String cpf);

}
