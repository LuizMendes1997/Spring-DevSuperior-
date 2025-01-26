package com.devsuperior.dslist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.Services.GameListService;
import com.devsuperior.dslist.dto.GameListDTO;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gamelistService;

	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gamelistService.findAll();
		return result;
	}
}
