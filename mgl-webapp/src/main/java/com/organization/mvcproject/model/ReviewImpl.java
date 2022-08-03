package com.organization.mvcproject.model;

import com.organization.mvcproject.api.model.Review;

public class ReviewImpl implements Review{
	
	private String body;
	private String author;
	private Integer rating;

	@Override
	public String getAuthor() {
		return author;
	}
	@Override
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public Integer getRating() {
		return rating;
	}
	@Override
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@Override
	public String getReviewBody() {
		return body;
	}
	@Override
	public void setReviewBody(String reviewBody) {
		this.body = reviewBody;
	}
}
