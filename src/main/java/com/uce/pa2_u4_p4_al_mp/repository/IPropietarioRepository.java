package com.uce.pa2_u4_p4_al_mp.repository;

import java.util.List;

import com.uce.pa2_u4_p4_al_mp.repository.modelo.Propietario;

public interface IPropietarioRepository {
    public void insertar(Propietario propietario);
    public void actulizar(Propietario propietario);
    public void eliminar(Integer id);
    public Propietario seleccionarPorId(Integer id);
    public List<Propietario> seleccionarTodos();
}
