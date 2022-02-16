package com.esprit.travel.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

	@Table
	public class Reclamation  {

		@PrimaryKey
		private int id;

		
		private String subject;

	
		private String description;

		
		public Reclamation() {

		}


		public Reclamation(int id, String subject, String description) {
			super();
			this.id = id;
			this.subject = subject;
			this.description = description;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getSubject() {
			return subject;
		}


		public void setSubject(String subject) {
			this.subject = subject;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		@Override
		public String toString() {
			return "Reclamation [id=" + id + ", subject=" + subject + ", description=" + description + "]";
		}






		
		

	}



