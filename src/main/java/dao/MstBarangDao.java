package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MstBarang;
import entity.MstBarangPK;

public interface MstBarangDao extends JpaRepository<MstBarang, MstBarangPK>{
	@Query("select a, b.namaSupplier from MstBarang a, MstSupplier b where a.kodeSupplier = b.kodeSupplier")
	public List<Object[]> findAllDataBarang();
	
	@Query(value ="select KODE_BARANG,NAMA_SUPPLIER from MST_BARANG join MST_SUPPLIER on MST_SUPPLIER.KODE_SUPPLIER = MST_KOTA.KODE_SUPPLIER",nativeQuery=true)
	public List<Object[]> findAllDataCustumberNative();
	
	@Query(value ="select a from MstBarang a where a.kodeBarang like :cari or a.namaBarang like :cari")
	public List<MstBarang> findDataBySearch(@Param("cari")String cari);
	
	@Query(value ="select a from MstBarang a where a.kodeBarang =:cari")
	public MstBarang findOneku(@Param("cari")String cari);
}
