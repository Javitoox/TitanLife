package aiss.controlller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.repository.UserRepository;



public class ValidatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());
	
    public ValidatorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO: Read request parameters
		String username =request.getParameter("Usename");
		String email =request.getParameter("Email");
		String password =request.getParameter("Password");
		String retype =request.getParameter("Retype");
		Integer age =Integer.valueOf(request.getParameter("Age"));
		Integer height =Integer.valueOf(request.getParameter("Height"));
		Integer weight =Integer.valueOf(request.getParameter("Weight"));
		Integer hip =Integer.valueOf(request.getParameter("Hip"));
		Integer waist =Integer.valueOf(request.getParameter("Waist"));


		
		if(username==null||email==null||password==null||retype==null||age==null||height==null||weight==null||hip==null||waist==null) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		// TODO: Create contact in the repository
		UserRepository.getInstance().addUser(username, email, password, retype, age, height, weight, hip, waist);
		


		// TODO: Forward to contact list view
		request.setAttribute("message", "Contact created successfully");
		request.getRequestDispatcher("/contactlist").forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
