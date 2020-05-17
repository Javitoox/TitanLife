package aiss.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import com.fatsecret.platform.model.Food;

import aiss.model.titan.Objetivo;
import aiss.model.titan.TipoDesgasteCalorico;
import aiss.model.titan.User;

import static java.time.temporal.ChronoUnit.WEEKS;

public class CalculatorFatSecret {
	private static final Logger log = Logger.getLogger(CalculatorFatSecret.class.getName());
	
	public static Integer userBaseCalories(User u) {
		Double result=0.;
		if(u.getDatosBMI().getSex().equals("m")){
			result=66+(13.7*Double.parseDouble(u.getDatosBMI().getWeight().getValue()))
					+(5*Double.parseDouble(u.getDatosBMI().getHeight().getValue()))
					-(6.75*Integer.parseInt(u.getDatosBMI().getAge()));
		}else {
			result=655+(9.6*Double.parseDouble(u.getDatosBMI().getWeight().getValue()))
					+(1.8*Double.parseDouble(u.getDatosBMI().getHeight().getValue()))
					-(4.7*Integer.parseInt(u.getDatosBMI().getAge()));
		}
		log.info("TMB para el usuario "+u.getUsername()+": "+result);
		if(u.getObjetivos()!=null)
			result=objetivesCalories(u.getObjetivos(),result);
		log.info("TMB para el usuario "+u.getUsername()+" aplicando objetivos deportivos: "+result);
		if(u.getPesoObj()!=null && !u.getPesoObj().equals(""))
			result=goalCalories(u,result);
		log.info("TMB para el usuario "+u.getUsername()+" aplicando objetivos corporales: "+result);
		return result.intValue();
	}
	
	private static Double objetivesCalories(List<Objetivo> obj,Double actualCalories) {
		Integer bajo=0;
		Integer medio=0;
		Integer alto=0;
		Integer total=0;
		for(Objetivo o: obj) {
			if(o.getTipo().equals(TipoDesgasteCalorico.BAJO))
				bajo++;
			else if(o.getTipo().equals(TipoDesgasteCalorico.MEDIO))
				medio++;
			else
				alto++;
			total++;
		}
		return actualCalories*((1.2*bajo+1.55*medio+1.9*alto)/total);
	}
	
	private static Double goalCalories(User u,Double actualCalories) {
		Double pesoGanarPerder=Double.parseDouble(u.getPesoObj())-Double.parseDouble(u.getDatosBMI().getWeight().getValue());
		Double kilosPorSemana=pesoGanarPerder*500;
		LocalDate fin=LocalDate.parse(u.getFechaObj());
		LocalDate inicio=LocalDate.now();
		return actualCalories+(kilosPorSemana/WEEKS.between(inicio, fin));
	}
	
	public static Integer caloriesPer100(Food f) {
		Integer gr=f.getServings().get(0).getMetricServingAmount().intValue();
		Integer cl=f.getServings().get(0).getCalories().intValue();
		return (100*cl)/gr;
	}

}
