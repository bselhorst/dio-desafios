package one.digitalinnovation.gof.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Funcionario;
import one.digitalinnovation.gof.model.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Iterable<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.get();
    }

    public void inserir(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public void atualizar(Long id, Funcionario funcionario){
        Optional<Funcionario> funcionarioBd = funcionarioRepository.findById(id);
        if (funcionarioBd.isPresent()){
            funcionarioRepository.save(funcionario);
        }
    }

    public void delete(Long id){
        funcionarioRepository.deleteById(id);
    }
}
