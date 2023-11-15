package com.example;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoorController {
	
	DoorDao doorDao = new DoorDao();
	
	@GetMapping("/doors/{id}")
	public ModelAndView watchPageById(@PathVariable int id) throws SQLException {

		ModelAndView mav = new ModelAndView("singleDoor");
		// get the watch from db
		Door door = doorDao.getById(id);
		System.out.println(door.getHeight() + " " + door.getWidth());
		
		// set it in the page
		
		mav.addObject ("do", door);
		
		
		return mav;
	}
	
}