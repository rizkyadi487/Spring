package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.*;
import entity.MstCustomer;

public class tes {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		System.out.println("Tes Database");

		MstBarangDao mstBarangDao = ctx.getBean(MstBarangDao.class);
		MstCustomerDao mstCustomerDao = ctx.getBean(MstCustomerDao.class);
		MstKaryawanDao mstKaryawanDao = ctx.getBean(MstKaryawanDao.class);
		MstKotaDao mstKotaDao = ctx.getBean(MstKotaDao.class);
		MstProvinsiDao mstProvinsiDao = ctx.getBean(MstProvinsiDao.class);
		MstSupplierDao mstSupplierDao = ctx.getBean(MstSupplierDao.class);
		TrDetailPenjualanDao trDetailPenjualanDao = ctx.getBean(TrDetailPenjualanDao.class);
		TrHeaderPenjualanDao trHeaderPenjualanDao = ctx.getBean(TrHeaderPenjualanDao.class);

//		 // ini select from
//		 List<MstBarang> list = mstBarangDao.findAll();
//		 for (MstBarang m : list) {
//		 System.out.println("KodeBarang : " + m.getKodeBarang());
//		 System.out.println("KodeSupplier : " + m.getKodeSupplier());
//		 System.out.println("NamaBarang : " + m.getNamaBarang());
//		 System.out.println("StokBarang : " + m.getStokBarang());
//		 }
		
		List<Object[]> list = mstCustomerDao.findAllDataCustomer();
		for (Object[] m : list) {
			MstCustomer customer = (MstCustomer) m[0];
			String namaKota = (String) m[1];
			System.out.println("Kode Customer : " + customer.getKodeCustomer());
			System.out.println("Nama Kota : " + namaKota);
		}
		
		List<Object[]> list2 = mstCustomerDao.findAllDataCustumberNative();
		for (Object[] m : list2) {
			String customer = (String) m[0];
			String namaKota = (String) m[1];
			System.out.println("Kode Customer : " + customer);
			System.out.println("Nama Kota : " + namaKota);
		}
		
		List<MstCustomer> list3 = mstCustomerDao.findDataBySearch("C002");
		for (MstCustomer m : list3) {
			System.out.println("Nama Customer : " + m.getNamaCustomer());
			System.out.println("Alamat : " + m.getAlamatCustomer());
			
		}
		
		
	}
}
