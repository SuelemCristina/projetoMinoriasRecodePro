package br.com.squad.pindorama.domain.pindorama.service.impl;

import br.com.squad.pindorama.domain.pindorama.model.Cliente;
import br.com.squad.pindorama.domain.pindorama.repository.ClienteRepository;
import br.com.squad.pindorama.domain.pindorama.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> find(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> update(String id, Cliente cliente) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
        clienteEncontrado.get().setNome(cliente.getNome());
        clienteEncontrado.get().setCpf(cliente.getCpf());
        clienteEncontrado.get().setEndereco(cliente.getEndereco());
        clienteEncontrado.get().setTelefone(cliente.getTelefone());
        clienteEncontrado.get().setDataNascimento(cliente.getDataNascimento());
        clienteEncontrado.get().setArtesanatos(cliente.getArtesanatos());
        clienteEncontrado.get().setPacotes(cliente.getPacotes());
        clienteRepository.save(clienteEncontrado.get());

        return clienteEncontrado;
    }

    @Override
    public void delete(String id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> findByUserId(String userId) {
        return Optional.ofNullable(clienteRepository.findByUserId(userId));
    }
}
