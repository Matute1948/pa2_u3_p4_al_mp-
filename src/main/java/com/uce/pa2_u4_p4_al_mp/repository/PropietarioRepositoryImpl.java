package com.uce.pa2_u4_p4_al_mp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.pa2_u4_p4_al_mp.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{
    //private static final Logger LOG = LoggerFactory.getLogger(PropietarioRepositoryImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Propietario propietario) {
        //LOG.info("hilo rep: "+Thread.currentThread().getName());
        //System.out.println("XDDD");
        this.entityManager.persist(propietario);
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void actulizar(Propietario propietario) {
        this.entityManager.merge(propietario);
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void eliminar(Integer id) {
        Propietario prop = this.seleccionarPorId(id);
        this.entityManager.remove(prop);
    }

    @Override
    @Transactional(value =TxType.NOT_SUPPORTED)
    public Propietario seleccionarPorId(Integer id) {
        return this.entityManager.find(Propietario.class, id);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<Propietario> seleccionarTodos() {
        TypedQuery<Propietario> mTypedQuery = this.entityManager.createQuery("SELECT p FROM Propietario p", Propietario.class);
        return mTypedQuery.getResultList();
    }
    
}
