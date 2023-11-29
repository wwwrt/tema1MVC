package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		ArrayList<Door> doors = DoorDao.getAllDoors();
		mav.addObject("doors", doors);
		System.out.println("Doors size is:" + doors.size());
		
		return mav;
	}
	
	@GetMapping("/doors/create")
	
	public ModelAndView create() {
		return new ModelAndView("createDoor");
	}
	
	@PostMapping("/doors/create")
	public ModelAndView createNewDoor(@RequestParam String material, @RequestParam double height, @RequestParam double width) throws SQLException, IOException {
	ModelAndView mav=new ModelAndView("doors");
	Door door = new Door(0, material, height, width, null);
	doorDao.insertDoor(door);
	ArrayList<Door> doors = DoorDao.getAllDoors();
	mav.addObject("doors", doors);
		return mav;
	
	}
	
}