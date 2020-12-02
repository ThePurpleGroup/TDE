package br.com.senac.dao;

import java.util.List;

public interface DAO {

    void insert(Object o);

    void update(Object o);

    void delete(Object o);

    Object select(int i);

    List select();
}
