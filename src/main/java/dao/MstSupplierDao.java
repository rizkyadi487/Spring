package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MstSupplier;
import entity.MstSupplierPK;

public interface MstSupplierDao extends JpaRepository<MstSupplier, MstSupplierPK>{

}