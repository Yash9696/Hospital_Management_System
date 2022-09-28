package com.app.services;
import static com.app.dtos.MedicineAssignedDataBackinBean.*;
import static com.app.dtos.WardDataBackinBean.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.IDoctorDao;
import com.app.daos.IEmployeeDao;
import com.app.daos.IMedicineAssignedDao;
import com.app.daos.IMedicineDao;
import com.app.daos.IUserDao;
import com.app.daos.IWardDao;
import com.app.dtos.DoctorDataBackinBean;
import com.app.dtos.MedicineAssignedDataBackinBean;
import com.app.dtos.WardDataBackinBean;
import com.app.entities.Medicine;
import com.app.entities.User;
import com.app.entities.Ward;

@Service @Transactional
public class MedicineServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IWardDao wardDao;
	@Autowired
	IMedicineDao medicineDao;
	@Autowired
	IMedicineAssignedDao medicineAssingedDao;
	
	public List<MedicineAssignedDataBackinBean> getAllMedicines(){
		List<Medicine> medicine=medicineDao.findAll();
		List<MedicineAssignedDataBackinBean> medicinesTosend=createAllMedicineList(medicine);
		return medicinesTosend;
		
	}

	public int addMedicine(MedicineAssignedDataBackinBean medicineData) {
		return  medicineDao.insertIntoMedicineTable(0, medicineData.getMedicineName(), medicineData.getMedicinePrice());
		
	}

	public void removeMedicine(int medicineId) {
		medicineDao.deleteById(medicineId);
		
	}
	
	
	
	
	

}
