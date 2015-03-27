package test;


import mysql.BrandMysqlDAO;
import mysql.ConnectionPool;
import mysql.PersonMysqlDAO;
import mysql.ProductMysqlDAO;
import mysql.RoleMysqlDAO;
import mysql.TypeMysqlDAO;
import mysql.UserMysqlDAO;
import service.BrandService;
import service.BrandServiceImpl;
import service.PersonService;
import service.PersonServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import service.RoleService;
import service.RoleServiceImpl;
import service.TypeService;
import service.TypeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import dao.BrandDAO;
import dao.PersonDAO;
import dao.ProductDAO;
import dao.RoleDAO;
import dao.TypeDAO;
import dao.UserDAO;
import domain.Product;
import domain.UserRole;

public class CopyOfTestDAOandService {

	public static void main(String args[]) {
		ConnectionPool.getInstance();
		UserDAO userDao = new UserMysqlDAO();
		RoleDAO roleDao = new RoleMysqlDAO();
		PersonDAO personDao = new PersonMysqlDAO();
		ProductDAO productDao = new ProductMysqlDAO();
		BrandDAO brandDao = new BrandMysqlDAO();
		TypeDAO typeDao = new TypeMysqlDAO();

		UserService userService = new UserServiceImpl(userDao);
		RoleService roleService = new RoleServiceImpl(roleDao);
		PersonService personService = new PersonServiceImpl(personDao);
		ProductService productService = new ProductServiceImpl(productDao);
		BrandService brandService = new BrandServiceImpl(brandDao);
		TypeService typeService = new TypeServiceImpl(typeDao);


			for (UserRole r : roleDao.readAll()){
				System.out.println(r.getRoleName().toUpperCase());
			}
/*		 ¬€¬Œƒ ¬—≈’ ƒ¿ÕÕ€’ »« ” ¿«¿ÕÕŒ… “¿¡À»÷€ ƒŒ »«Ã≈Õ≈Õ»ﬂ
		System.out.println("ƒŒ »«Ã≈Õ≈Õ»ﬂ");
		System.out.println("==============================================");
		=================PERSON========================
		for (Person p : personService.findAll()){
			p.getId();
			p.getName();
			p.getSurname();
			p.getEmail();
			p.getAddress();
			p.getPhone();
			System.out.println(p.getId() + ", " + p);}
		=================BRAND=====================
		for (Brand b : brandService.findAll()){
			b.getId();
			b.getBrandName();
			System.out.println(b.getId() + ", " + b);}
		System.out.println("==============================================");
		
		
		 —Œ«ƒ¿Õ»≈ «¿œ»—» ¬ “¿¡À»÷≈
		===========PERSON==============
		Person person = new Person();
		person.setId(8);
		person.setName("222");
		person.setSurname("222");
		person.setEmail("222");
		person.setAddress("222");
		person.setPhone("222");
		personService.save(person);
		=============BRAND==================
		brand = new Brand();
		brand.setId(6);
		brand.setBrandName("new");
		brandService.save(brand);
		===========USER==============
		User user = new User();
		UserRole role = new UserRole();
		Person person = new Person();
		user.setId(16);
		user.setLogin("666");
		user.setPassword("111");
		role.setId(2);
		person.setId(2);
		user.setRole(role);
		user.setPerson(person);
		userService.save(user);
		System.out.println(user);

		for (User u : userService.findAll()){
			System.out.println(u);
		}
		
		List<Person> person = new ArrayList<Person>();
		person.setType(personService.findById(person.getType().getId()));
		person.setBrand(personService.findById(person.getBrand().getId()));
		
		 œŒÀ”◊≈Õ»≈ œŒ »ƒ
		int id=9;
		=============================
		Brand bdel = brandService.findById(id);
		System.out.println(bdel.getId()+", "+bdel.getBrandName());
		System.out.println("”‰‡ÎÂÌ id#" + id);
		
		Person pdel = personService.findById(id);
		System.out.println(pdel.getId()+", "+pdel.getName());
		System.out.println("”‰‡ÎÂÌ id#" + id);
		============================

		 ”ƒ¿À≈Õ»≈ «¿œ»—» »« “¿¡À»÷€
		========================
		personService.delete(5);
		brandService.delete(id);
		============================
		
		
		 ¬€¬Œƒ ¬—≈’ ƒ¿ÕÕ€’ »« ” ¿«¿ÕÕŒ… “¿¡À»÷€
		================PERSON=========================
		for (Person p : personService.findAll()){
			p.getId();
			p.getName();
			p.getSurname();
			p.getEmail();
			p.getAddress();
			p.getPhone();
			System.out.println(p.getId() + ", " + p);}
		=================BRAND===========================
		for (Brand b2 : brandService.findAll()){
			b2.getId();
			b2.getBrandName();
			System.out.println(b2.getId() + ", " + b2);}
		=================ROLE===========================

		for (UserRole b2 : roleService.findAll()){
			b2.getId();
			b2.getRole();
			System.out.println(b2.getId() + ", " + b2);}

		==========USER=====================================
		for (User u : userService.findAll()){
			System.out.println(u.getId()+" "
					+u.getLogin()+" "
					+u.getPassword()+" "
					+roleService.findById(u.getRole().getId()));
			
			System.out.println(personService.findById(u.getPerson().getId()));
			}
		
		User check = new User("456","ttt");

		System.out.println(userService.checkUser(check));



		System.out.println(roleService.findById(user.getRole().getId()));
		System.out.println(user.getId());
		System.out.println(user.getRole().getId());
		System.out.println(user.getPerson().getId());
		*/

		
		
 
	}  
}  
