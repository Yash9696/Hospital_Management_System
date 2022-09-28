package com.app.services;
import static com.app.dtos.WardDataBackinBean.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.NoSuchMedicineExistsException;
import com.app.daos.IDoctorDao;
import com.app.daos.IEmployeeDao;
import com.app.daos.IMedicineAssignedDao;
import com.app.daos.IMedicineDao;
import com.app.daos.IUserDao;
import com.app.daos.IWardDao;
import com.app.dtos.DoctorDataBackinBean;
import com.app.dtos.MedicineAssignedDataBackinBean;
import com.app.dtos.WardDataBackinBean;
import com.app.entities.User;
import com.app.entities.Ward;

@Service @Transactional
public class MedicineAssignedServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IWardDao wardDao;
	@Autowired
	IMedicineAssignedDao medicineAssingedDao;
	@Autowired
	IMedicineDao medicineDao;
	
	public void addMedicineToPatient(MedicineAssignedDataBackinBean medicineData) throws NoSuchMedicineExistsException {
		
			medicineAssingedDao.addIntoMedicineAssigned(medicineData.getPatId(), medicineData.getMedicineId(), medicineData.getMedicinePrescription(), medicineData.getMedicineQty());
		
		
		
	}
	
	public void removeMedicineOfPatient(int medicineAssignId) {
		medicineAssingedDao.deleteById(medicineAssignId);
	}
	
	
	
	

}
