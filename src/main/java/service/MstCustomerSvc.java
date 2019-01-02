package service;

import java.util.List;

import dto.MstCustomerDto;

public interface MstCustomerSvc {
	public List<MstCustomerDto> findAllCustomer();

	public void save(MstCustomerDto mst);

	public void update(MstCustomerDto mst);

	public void delete(MstCustomerDto mst);

	public List<MstCustomerDto> findAllCustomerBySearch(String cari);

	MstCustomerDto findOneCustomer(String kodeCustomer);
}
