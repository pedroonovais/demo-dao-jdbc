package applicantion;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = depDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDep = new Department(null, "Food");
		//depDao.insert(newDep);
		System.out.println("Done! Id = " + newDep.getId() + " inserted!");
		
		System.out.println("\n=== TEST 4: department update ===");
		dep.setName("FixComputers");
		depDao.update(dep);
		System.out.println("Done! Id = " + dep.getId() + " Updated!");
		
		System.out.println("\n=== TEST 5: department delete ===");
		depDao.deleteById(8);
		System.out.println("Deleted!");
	}

}
