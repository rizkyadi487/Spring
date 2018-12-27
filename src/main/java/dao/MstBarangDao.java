package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MstBarang;
import entity.MstBarangPK;

public interface MstBarangDao extends JpaRepository<MstBarang, MstBarangPK>{

}
