package com.library.binding;

public class Search {

	private String searchTerm , searchCriteria ;

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	public void print() {
		System.out.println(searchTerm);
		System.out.println(searchCriteria);
	}
	
}
