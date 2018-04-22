/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.ClienteDao;
import com.edutech.javaee.finaltest.dao.MunicipioDao;
import com.edutech.javaee.finaltest.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class ClienteBll {

    @Inject
    private ClienteDao cliDao;
    @Inject
    private MunicipioDao munDao;

    public List<Cliente> listar() {

        List<Cliente> lista = new ArrayList<>();
        this.cliDao.listar().forEach((cliente) -> {
            cliente.setListaCuentas(null);
            lista.add(cliente);
        });

        return lista;
    }

    public Cliente buscarId(Integer idCliente) {
        Cliente cliente = this.cliDao.buscarId(idCliente);

        if (cliente != null) {
            cliente.getListaCuentas().forEach((cuenta) -> {
                cuenta.setListaTransacciones(null);
            });
        }

        return cliente;
    }

    public Cliente guardar(Cliente entity) {
        Cliente cliente = new Cliente(
                entity.getNombre(),
                entity.getDireccion(),
                entity.getNit(),
                this.munDao.buscar(entity.getMuni().getId()),
                entity.getFechaNacimiento(),
                entity.getTarjetaDebito()
        );

        return this.cliDao.guardar(entity);
    }

    public Cliente editar(Cliente entity) {
        Cliente cliente = this.buscarId(entity.getId());

        if (cliente != null) {
            cliente.setDireccion(entity.getDireccion());
            cliente.setFechaNacimiento(entity.getFechaNacimiento());
            cliente.setMuni(entity.getMuni());
            cliente.setNit(entity.getNit());
            cliente.setNombre(entity.getNombre());
            cliente.setMuni(this.munDao.buscar(entity.getMuni().getId()));
            this.cliDao.editar(cliente);
        }

        return cliente;
    }

    public Cliente eliminarRegistro(Integer idCliente) {
        Cliente cliente = this.buscarId(idCliente);
        if (cliente != null) {
            return this.cliDao.eliminar(cliente);
        } else {
            return null;
        }
    }
}
