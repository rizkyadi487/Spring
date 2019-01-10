package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import service.MstCustomerSvc;
import dao.*;
import dto.MstCustomerDto;
import entity.MstCustomer;
import entity.MstCustomerPK;

public class tes {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");

		
		
		
		
		
		// System.out.println("Tes Database");

		// MstBarangDao mstBarangDao = ctx.getBean(MstBarangDao.class);
		 MstCustomerDao mstCustomerDao = ctx.getBean(MstCustomerDao.class);
		 
		 Sort sorting = new Sort(Sort.Direction.ASC, "namaCustomer");
		 
		 List<MstCustomer> list = mstCustomerDao.findDataBySearchAndSort("%hi%",sorting);
		 for(MstCustomer m : list){
			 System.out.println(m.getKodeCustomer()+" - "+m.getNamaCustomer());
		 }
		 
		// MstKaryawanDao mstKaryawanDao = ctx.getBean(MstKaryawanDao.class);
		// MstKotaDao mstKotaDao = ctx.getBean(MstKotaDao.class);
		// MstProvinsiDao mstProvinsiDao = ctx.getBean(MstProvinsiDao.class);
		// MstSupplierDao mstSupplierDao = ctx.getBean(MstSupplierDao.class);
		// TrDetailPenjualanDao trDetailPenjualanDao = ctx
		// .getBean(TrDetailPenjualanDao.class);
		// TrHeaderPenjualanDao trHeaderPenjualanDao = ctx
		// .getBean(TrHeaderPenjualanDao.class);
		//
		// // ini select from
		// List<MstBarang> list = mstBarangDao.findAll();
		// for (MstBarang m : list) {
		// System.out.println("KodeBarang : " + m.getKodeBarang());
		// System.out.println("KodeSupplier : " + m.getKodeSupplier());
		// System.out.println("NamaBarang : " + m.getNamaBarang());
		// System.out.println("StokBarang : " + m.getStokBarang());
		// }

		// List<Object[]> list = mstCustomerDao.findAllDataCustomer();
		// for (Object[] m : list) {
		// MstCustomer customer = (MstCustomer) m[0];
		// String namaKota = (String) m[1];
		// System.out.println("Kode Customer : " + customer.getKodeCustomer());
		// System.out.println("Nama Kota : " + namaKota);
		// }
		//
		// List<Object[]> list2 = mstCustomerDao.findAllDataCustumberNative();
		// for (Object[] m : list2) {
		// String customer = (String) m[0];
		// String namaKota = (String) m[1];
		// System.out.println("Kode Customer : " + customer);
		// System.out.println("Nama Kota : " + namaKota);
		// }
		//
		// List<MstCustomer> list3 = mstCustomerDao.findDataBySearch("C002");
		// for (MstCustomer m : list3) {
		// System.out.println("Nama Customer : " + m.getNamaCustomer());
		// System.out.println("Alamat : " + m.getAlamatCustomer());
		//
		// }

		// //Find One
		// MstCustomerPK mstCustomerPK = new MstCustomerPK();
		// mstCustomerPK.setKodeCustomer("C002");
		// MstCustomer mstCustomer = mstCustomerDao.findOne(mstCustomerPK);
		// System.out.println("Nama : "+mstCustomer.getNamaCustomer());

		MstCustomerSvc svc = ctx.getBean(MstCustomerSvc.class);

		// List<MstCustomerDto> dtos = svc.findAllCustomer();
		// for (MstCustomerDto m : dtos) {
		// System.out.println("Kode Customer : " + m.getKodeCustomer());
		// System.out.println("Nama Customer : " + m.getNamaCustomer());
		// System.out.println("Email : " + m.getKodeKota());
		// }
		//
		//
		// MstCustomerDto customer = new MstCustomerDto();
		// customer.setKodeCustomer("C004");
		// customer.setNamaCustomer("Nama Baru");
		// customer.setAlamatCustomer("Alamat Baru");
		// customer.setEmailCustomer("Email@Email.Email");
		// customer.setJenisKelamin("Pria");
		// customer.setKodeKota("K001");
		//
		// svc.save(customer);
		//
		//

		// MstCustomerDto customer = new MstCustomerDto();
		// customer.setKodeCustomer("C004");
		//
		// svc.delete(customer);

		
		
		
//		 List<MstCustomerDto> dtos = svc.findAllCustomerBySearch("H");
//		 for (MstCustomerDto m : dtos) {
//		 System.out.println("Kode Customer : " + m.getKodeCustomer());
//		 System.out.println("Nama Customer : " + m.getNamaCustomer());
//		 System.out.println("Email : " + m.getKodeKota());
//		 }
		

		MstCustomerDto dtos = svc.findOneCustomer("C004");
		System.out.println("Kode Customer : " + dtos.getKodeCustomer());
		System.out.println("Nama Customer : " + dtos.getNamaCustomer());
		System.out.println("Email : " + dtos.getKodeKota());

	}
}
