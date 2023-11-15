package com.osm.in.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Customer;
import com.onlinesweetmart.entity.SweetItem;
import com.onlinesweetmart.exception.CustomException;
import com.onlinesweetmart.repository.SweetItemRepository;


@Service
public class SweetItemServiceImpl implements SweetItemService {

	@Autowired
	private SweetItemRepository sweetItemRepository;

	@Autowired
	private CustomerService customerService;

	/**
	 * method: addSweetOrder() -This method will add SweetOrder in its repository
	 * 
	 * @param: It will take SweetOrder object as a parameter
	 * @return: It will return persisted entity in database
	 * 
	 */
	@Override
	public SweetItem addSweetItem(SweetItem sweetItem) {

		List<Customer> customerList = customerService.showAllCustomers();
		boolean customerFound = false;
		for (Customer customer : customerList) {
			if (customer.getUserId() == sweetItem.getCustomer().getUserId()) {
				customerFound = true;
				

			}
		}
		if (customerFound == false) {
			throw new CustomException(
					"Customer with customerId: " + sweetItem.getCustomer().getUserId() + " not found");
		} else {
			return sweetItemRepository.save(sweetItem);
		}

	}

	/**
	 * method: updateSweetOrder() - This method will update SweetOrder in its
	 * repository
	 * 
	 * @param: It will take SweetOrder object as a parameter
	 * @return: It will return updated entity in a database
	 * 
	 */

	@Override
	public SweetItem updateSweetItem(SweetItem sweetItem) {
		SweetItem sweetItem2 = new SweetItem();

		if (sweetItemRepository.existsById(sweetItem.getSweetItemId())) {
			
			sweetItem2.setCustomer(sweetItem.getCustomer());

			return sweetItem2;
		} else {
			throw new CustomException("sweet item not found");
		}

	}

	/**
	 * method: cancelSweetOrder() - this method will delete SweetOrder from its
	 * database
	 * 
	 * @param: It will take integer value as a parameter
	 * @return: It will return deleted SweetOrder object from a database
	 * 
	 */

	@Override
	public SweetItem cancelSweetItem(int sweetItemId) {
		SweetItem sweetItem = new SweetItem();
		if (sweetItemRepository.existsById(sweetItemId)) {
			sweetItem = sweetItemRepository.findById(sweetItemId).get();
			sweetItemRepository.deleteById(sweetItemId);
		} else {
			throw new CustomException("sweet item with id:" + sweetItemId + " not found");
		}
		return sweetItem;
	}

	/**
	 * method: showAllSweetOrders() - This method will show all SweetOrder present
	 * in its customer
	 * 
	 * @param: It will not take any parameter
	 * @return: It will return list of entities present in a SweetOrder database
	 * 
	 */
	@Override
	public List<SweetItem> showAllSweetItems() {
		List<SweetItem> listSweetItems = sweetItemRepository.findAll();
		if (listSweetItems.isEmpty()) {
			throw new CustomException("list of sweet Item is empty");
		}
		return listSweetItems;
	}

	/**
	 * method: calculateTotalCost() - This method will calculate total cost of
	 * SweetOrder
	 * 
	 * @param: It will take integer value as a parameter
	 * @return: It will return deleted SweetOrder object from a database
	 * 
	 */
//
//	@Override
//	public double calculateTotalCost(int sweetItemId) {
//
//		return 0;
//	}

}

	
	
	
	

