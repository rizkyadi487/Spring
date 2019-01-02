package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MstCustomerDao;
import dto.MstCustomerDto;
import entity.MstCustomer;
import entity.MstCustomerPK;
import service.MstCustomerSvc;

@Service("mstCustomerSvc")
@Transactional
public class MstCustumerSvcImpl implements MstCustomerSvc {

	@Autowired
	private MstCustomerDao mstCustomerDao;

	@Override
	public List<MstCustomerDto> findAllCustomer() {
		// TODO Auto-generated method stub
		List<Object[]> list = mstCustomerDao.findAllDataCustomer();
		List<MstCustomerDto> mstCustomerDtos = new ArrayList<>();
		for (Object[] o : list) {
			MstCustomerDto dto = new MstCustomerDto();
			MstCustomer customer = (MstCustomer) o[0];
			String namaKota = (String) o[1];
			dto.setKodeCustomer(customer.getKodeCustomer());
			dto.setNamaCustomer(customer.getNamaCustomer());
			dto.setAlamatCustomer(customer.getAlamatCustomer());
			dto.setEmailCustomer(customer.getEmailCustomer());
			dto.setJenisKelamin(customer.getJenisKelamin());
			dto.setKodeKota(customer.getKodeKota());
			dto.setNamaKota(namaKota);
			mstCustomerDtos.add(dto);
		}
		return mstCustomerDtos;
	}

	@Override
	public void save(MstCustomerDto mstCustomerDto) {
		// TODO Auto-generated method stub
		MstCustomer customer = new MstCustomer();
		customer.setKodeCustomer(mstCustomerDto.getKodeCustomer());
		customer.setNamaCustomer(mstCustomerDto.getNamaCustomer());
		customer.setAlamatCustomer(mstCustomerDto.getAlamatCustomer());
		customer.setEmailCustomer(mstCustomerDto.getEmailCustomer());
		customer.setJenisKelamin(mstCustomerDto.getJenisKelamin());
		customer.setKodeKota(mstCustomerDto.getKodeKota());
		mstCustomerDao.save(customer);
	}

	@Override
	public void update(MstCustomerDto mstCustomerDto) {
		// TODO Auto-generated method stub

		MstCustomerPK customerPK = new MstCustomerPK();
		customerPK.setKodeCustomer(mstCustomerDto.getKodeCustomer());
		MstCustomer customer = mstCustomerDao.findOne(customerPK);
		customer.setKodeCustomer(mstCustomerDto.getKodeCustomer());
		customer.setNamaCustomer(mstCustomerDto.getNamaCustomer());
		customer.setAlamatCustomer(mstCustomerDto.getAlamatCustomer());
		customer.setEmailCustomer(mstCustomerDto.getEmailCustomer());
		customer.setJenisKelamin(mstCustomerDto.getJenisKelamin());
		customer.setKodeKota(mstCustomerDto.getKodeKota());
		mstCustomerDao.save(customer);

	}

	@Override
	public void delete(MstCustomerDto mstCustomerDto) {
		// TODO Auto-generated method stub
		MstCustomerPK customerPK = new MstCustomerPK();
		customerPK.setKodeCustomer(mstCustomerDto.getKodeCustomer());
		MstCustomer customer = mstCustomerDao.findOne(customerPK);
		mstCustomerDao.delete(customer);

	}

	@Override
	public List<MstCustomerDto> findAllCustomerBySearch(String cari) {
		// TODO Auto-generated method stub
		List<MstCustomer> list = mstCustomerDao.findDataBySearch("%" + cari
				+ "%");
		List<MstCustomerDto> mstCustomerDtos = new ArrayList<>();
		for (MstCustomer o : list) {
			MstCustomerDto dto = new MstCustomerDto();
			MstCustomer customer = o;
			dto.setKodeCustomer(customer.getKodeCustomer());
			dto.setNamaCustomer(customer.getNamaCustomer());
			dto.setAlamatCustomer(customer.getAlamatCustomer());
			dto.setEmailCustomer(customer.getEmailCustomer());
			dto.setJenisKelamin(customer.getJenisKelamin());
			dto.setKodeKota(customer.getKodeKota());
			mstCustomerDtos.add(dto);
		}
		return mstCustomerDtos;
	}

//	@Override
//	public MstCustomerDto findOneCustomer(String kodeCustomer) {
//		MstCustomerDto dto = new MstCustomerDto();
//		dto.setKodeCustomer(kodeCustomer);
//		MstCustomerPK customerPK = new MstCustomerPK();
//		customerPK.setKodeCustomer(dto.getKodeCustomer());
//		MstCustomer customer = mstCustomerDao.findOne(customerPK);
//		dto.setKodeCustomer(customer.getKodeCustomer());
//		dto.setNamaCustomer(customer.getNamaCustomer());
//		dto.setAlamatCustomer(customer.getAlamatCustomer());
//		dto.setEmailCustomer(customer.getEmailCustomer());
//		dto.setJenisKelamin(customer.getJenisKelamin());
//		dto.setKodeKota(customer.getKodeKota());
//		return dto;
//	}
	
	@Override
	public MstCustomerDto findOneCustomer(String kodeCustomer) {
		MstCustomerDto dto = new MstCustomerDto();
		MstCustomer customer = mstCustomerDao.findOneku(kodeCustomer);
		dto.setKodeCustomer(customer.getKodeCustomer());
		dto.setNamaCustomer(customer.getNamaCustomer());
		dto.setAlamatCustomer(customer.getAlamatCustomer());
		dto.setEmailCustomer(customer.getEmailCustomer());
		dto.setJenisKelamin(customer.getJenisKelamin());
		dto.setKodeKota(customer.getKodeKota());
		return dto;
	}

	

}
