package com.uce.pa2_u4_p4_al_mp.serviice;

import java.util.List;

import com.uce.pa2_u4_p4_al_mp.repository.modelo.Propietario;

public interface IPropietarioService {
    public void agregar(Propietario propietario);
    public void actulizar(Propietario propietario);
    public void remover(Integer id);
    public Propietario buscarPorId(Integer id);
    public List<Propietario> buscarTodos();

}
