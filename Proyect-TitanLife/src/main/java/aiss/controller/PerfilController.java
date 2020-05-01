package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.repository.UserRepository;
import aiss.model.titan.DataBMI;
import aiss.model.titan.Height;
import aiss.model.titan.User;
import aiss.model.titan.Weight;
import aiss.utility.Validacion;

public class PerfilController extends HttpServlet {
	
    private static final Logger log = Logger.getLogger(PerfilController.class.getName());

	
    private static final long serialVersionUID = 1L;

	public PerfilController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	String username=request.getParameter("Username");
            String email=request.getParameter("Email");
            String password=request.getParameter("Password");
            String age=request.getParameter("Age");
            String height=request.getParameter("Height");
            String weight=request.getParameter("Weight");
            String hip=request.getParameter("Hip");
            String waist=request.getParameter("Waist");
            String sex=request.getParameter("Sex");
            
            UserRepository repository=UserRepository.getInstance();
            HttpSession misession= (HttpSession) request.getSession(true);   	 
            User user= (User) misession.getAttribute("user");	
            String validaciones = Validacion.validacion2(user,username, email, password, age, height, weight, hip, waist, sex);
            
            if(!validaciones.equals("")) {            	
            	log.info("La actualizacion del usario " + username + " no se pudo realizar.");
            	request.setAttribute("validaciones", validaciones);
                misession.setAttribute("user", user);

            	
            }else {            	
            	log.info("El perfil del usuario " + username + " fue actualizado correctamente");
            	user.setUsername(username);
            	user.setEmail(email);
            	user.setPassword(password);
            	user.setRetype(password);
            	DataBMI datosBMI = user.getDatosBMI();
            	Weight weight2 = datosBMI.getWeight();
            	Height height2 = datosBMI.getHeight();
            	height2.setUnit(height);
               	weight2.setUnit(weight);
            	datosBMI.setHeight(height2);
            	datosBMI.setWeight(weight2);
            	datosBMI.setHip(hip);
            	datosBMI.setWaist(waist);
            	datosBMI.setAge(age);
            	datosBMI.setSex(sex);
				user.setDatosBMI(datosBMI);            	
            	repository.updateUser(user);  
                misession.setAttribute("user", user);

            }
            
            request.getRequestDispatcher("/perfil.jsp").forward(request, response);
	    
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        doGet(request, response);
	       
	    }
	}	