package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiis.model.resource.BMIResource;
import aiss.model.BMI.BMIResult;
import aiss.model.repository.UserRepository;
import aiss.model.titan.User;
import aiss.utility.Validacion;

public class ObjetivosCorporalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ObjetivosCorporalesController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesoObj=request.getParameter("pesoObj");
		String fechaObj=request.getParameter("fechaObj");
		User u=UserRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u.getImc()==null || u.getImc().equals("")) {
			log.info("IMC no generado, debe ser generado por el usuario "+u.getUsername());
			request.setAttribute("validaciones", "Debe de generar su IMC primero");
			request.getRequestDispatcher("/objetivos.jsp").forward(request, response);
		}else {
			String validaciones=Validacion.validacionObjCorp(pesoObj, fechaObj);
			if(!validaciones.equals("")) {
				log.info("Formato incorrecto de los campos en objetivos corporales");
				request.setAttribute("validaciones", validaciones);
				request.getRequestDispatcher("/objetivos.jsp").forward(request, response);
			}else {
				u.setPesoObj(pesoObj);
				u.setFechaObj(fechaObj);
				log.info("Peso y fecha objetivos cargados para el usuario "+u.getUsername());
				String pesoOriginal=u.getDatosBMI().getWeight().getValue();
				u.getDatosBMI().getWeight().setValue(pesoObj);
				BMIResult bmires=BMIResource.getBMI(u.getDatosBMI());
				String bmi= bmires.getBmi().getValue() + " | " + bmires.getBmi().getStatus();
				u.setImcObj(bmi);
				u.getDatosBMI().getWeight().setValue(pesoOriginal);
				log.info("Cálculo del imc objetivo realizado");
				request.getRequestDispatcher("/objetivos.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
