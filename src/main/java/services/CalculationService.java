package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Calculation;
import query.CalculationQ;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class CalculationService {
	@Inject
	private CalculationQ calculationq;
	@Path("calc")
	@POST
	public Helper calculate(Calculation calculation) {
        int res;
        switch (calculation.getOperation()) {
            case "+":
                res = calculation.getNumber1() + calculation.getNumber2();
                break;
            case "-":
                res = calculation.getNumber1() - calculation.getNumber2();
                break;
            case "*":
                res = calculation.getNumber1() * calculation.getNumber2();
                break;
            case "/": {
                if (calculation.getNumber2() == 0)
                    throw new IllegalArgumentException("Can't divide by zero");
                res = calculation.getNumber1() / calculation.getNumber2();
                break;
            }
            default:
                throw new IllegalArgumentException("Errroooor");
        }
        calculationq.insert(calculation);
        return new Helper(res);
    }
		
	 @Path("calculations")
	 @GET
	 public List<Calculation> getAllCalculations() {
             return calculationq.selectAll();
		    }
		
		
		
	}
	
	