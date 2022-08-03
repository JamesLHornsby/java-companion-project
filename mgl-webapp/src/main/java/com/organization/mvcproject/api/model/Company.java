package com.organization.mvcproject.api.model;

import java.util.List;

public interface Company {

	public Long getId();

	public void setId(Long id);

	public String getName();

	public void setName(String name);

	public void setGamesMade(List<Game> gamesMade);
	
	List<Game> getGamesMade();

}
