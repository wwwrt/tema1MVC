package com.example;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoorController {
	
	DoorDao doorDao = new DoorDao();
	
	@GetMapping("/doors/{id}")
	public ModelAndView watchPageById(@PathVariable int id) throws SQLException {

		ModelAndView mav = new ModelAndView("single-door");
		// get the watch from db
		Door door = doorDao.getById(id);	
		// set it in the page	
		mav.addObject ("do", door);
		
		
		return mav;
	}
	
	@GetMapping("/doors")
	public ModelAndView getAllDoors() throws SQLException {
		ModelAndView mav = new ModelAndView("doors");
		
		ArrayList<Door> doors = doorDao.getAllDoors();
		mav.addObject("doors", doors);
		System.out.println("Doors size is:" + doors.size());
		
		return mav;
	}
	
}