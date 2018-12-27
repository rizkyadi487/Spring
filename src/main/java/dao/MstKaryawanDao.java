package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MstKaryawan;
import entity.MstKaryawanPK;


public interface MstKaryawanDao extends JpaRepository<MstKaryawan, MstKaryawanPK>{

}