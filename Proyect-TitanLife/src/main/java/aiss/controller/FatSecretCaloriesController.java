package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fatsecret.platform.model.CompactFood;

import aiis.model.resource.FatSecretResource;

public class FatSecretCaloriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(FatSecretCaloriesController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search");
		if(search!=null && !search.equals("")) {
			List<CompactFood> lc=FatSecretResource.searchFood(search);
			List<String> l=new ArrayList<>(); 
			for(Integer i=0;i<=4;i++) {
				l.add(lc.get(i).getName()+", "+lc.get(i).getDescription());
			}
			log.info("Listing searchs of "+search);
			request.setAttribute("foods", l);
			request.getRequestDispatcher("/misComidas.jsp").forward(request, response);
		}else{
			log.info("Acces without a food search");
			request.getRequestDispatcher("/misComidas.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
