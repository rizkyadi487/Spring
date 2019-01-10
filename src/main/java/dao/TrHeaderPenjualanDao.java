package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.TrHeaderPenjualan;
import entity.TrHeaderPenjualanPK;

public interface TrHeaderPenjualanDao extends JpaRepository<TrHeaderPenjualan, TrHeaderPenjualanPK>{
	@Query("select a, b.namaKota from MstCustomer a, MstKota b where a.kodeKota = b.kodeKota")
	public List<Object[]> findAllDataCustomer();
	
	@Query(value ="select KODE_CUSTOMER,NAMA_KOTA from MST_CUSTOMER join MST_KOTA on MST_CUSTOMER.KODE_KOTA = MST_KOTA.KODE_KOTA",nativeQuery=true)
	public List<Object[]> findAllDataCustumberNative();
	
	@Query(value ="select a from TrHeaderPenjualan a where a.kodeCustomer like :cari or a.namaCustomer like :cari")
	public List<TrHeaderPenjualan> findDataBySearch(@Param("cari")String cari);
	
	@Query(value ="select a from TrHeaderPenjualan a where a.kodeCustomer =:cari")
	public TrHeaderPenjualan findOneku(@Param("cari")String cari);
}
