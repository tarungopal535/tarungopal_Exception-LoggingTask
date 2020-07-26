package com.epam.loggingdemo2;


/**
 * @author TARUN GOPAL
 *
 */
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/*
 * Estimator class
 * which estimates the cost based on 
 * the chosen material and standard 
 * and for the given area of the land
 */
class Estimate{
	int material;
	double area;
	// default rates per square feet for different materials
	private static final Logger LOGGER = LogManager.getLogger(Estimate.class);
	int []rate = new int[] {1200,1500,1800,2500};
	/* 1200 -->Standard material
	 * 1500 --->above standard
	 * 1800---->high standard
	 * 2500---->high standard with automation
	 */
	Estimate(int m,double a){
		
		material =m;
		area=a;
		LOGGER.debug("Estimator Received the user choice ---->Material and area of the house....");
	}
	/*
	 * calculateCost method
	 * returns cost required for construction 
	 */
	double calculateCost() {
		LOGGER.debug("Cost Estimation Started...");
		LOGGER.debug("Cost Estimation Done!!!");
		return area*rate[material-1];
		
	}
}
public class CostEstimation {

	/**
	 * @param args
	 */
	private static final Logger LOGGER = LogManager.getLogger(CostEstimation.class);
	public static void main(String[] args)throws IOException
	{
		
		LOGGER.info("Program Execution Started........");
		
		//importing Scanner class
		Scanner sc = new Scanner(System.in);
		LOGGER.debug("Scanner class object is created......");
		//ask the client the type of material to be used for construction
		LOGGER.debug("Get the Type of Material from the client");
		LOGGER.info("Choose one from the given standards\n1.Standard material\n2.Above Standard material\n3.High Standard material\n");
		//int material = sc.nextInt();
		int material = 2;
		LOGGER.debug("User Selected the Required Material...");
		LOGGER.info("Enter the area ofland(in sq feet : )");
		
		//Give the Area of the land
		//double area = sc.nextDouble();
		double area = 200;
		LOGGER.debug("User gave the Area of the land...");
		
		if(material==3) {
			/*if chosen material is of high standard
			 * we again provide two choices for client
			 * -->client choice may be 
			 * fully automated house 
			 * or not automated house 
			 * 
			 */
			LOGGER.info("User Selected the Type3 Material....");
			LOGGER.info("Do you want fully automated home?[y/n]");
			char choice = sc.next().charAt(0);
			LOGGER.debug("User can select automated or non automated house");
			if(choice=='Y'||choice=='y') {
				material = 4;
				LOGGER.debug("User Selected fully automated house....");
			}
			
		}
		//Estimate the cost for construction of house
		LOGGER.debug("Cost Estimator is called....");
		Estimate estimatecost = new Estimate(material,area);
		//get the cost from estimator 
		LOGGER.info("Estimator calculated the cost required for house construction.....");
		double cost = estimatecost.calculateCost();
		
		LOGGER.info("Your House Construction Estimation cost is :");
		//output the cost estimation to the client rounded up to 2 decimals
		System.out.format("%.2f\n", cost);
		LOGGER.info("==============Program Terminated Successfully===============");
	}

}

