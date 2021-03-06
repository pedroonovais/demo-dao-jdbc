package applicantion;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartmentId ===");
		Department dep = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Teste", "teste@teste.com", new Date(), 0.0, dep);
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(11);
		seller.setBaseSalary(88888.0);
		sellerDao.update(seller);
		System.out.println("Done! Updated id = " + seller.getId());
		
		System.out.println("\n=== TEST 6: seller delete ===");
		int idDelete = sellerDao.findById(10).getId();
		sellerDao.deleteById(20);
		System.out.println("Done! Id deleted = " + idDelete);
	}

}
