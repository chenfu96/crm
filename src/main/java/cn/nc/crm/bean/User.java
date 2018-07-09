package cn.nc.crm.bean;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable {
	
       private Integer id;
       private String name;
       private String password;
       private int age;
       private String[] hobby;
       
	   public User(String name, String password) {
		  super();
		  this.name = name;
		  this.password = password;
	   }
	   
		public User() {
		super();
	}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String[] getHobby() {
			return hobby;
		}

		public void setHobby(String[] hobby) {
			this.hobby = hobby;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", hobby="
					+ Arrays.toString(hobby) + "]";
		}

		
	  
}
