package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MstKota;
import entity.MstKotaPK;

public interface MstKotaDao extends JpaRepository<MstKota, MstKotaPK>{

}