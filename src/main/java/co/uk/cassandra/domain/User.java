/**
 * 
 */
package co.uk.cassandra.domain;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * @author arpan
 *
 */
@Table(value="users")
public class User {

	@PrimaryKey(value="id")
	@Column(value="id")
	private int id;
	@Column(value="fname")
	private String fname;
	@Column(value="lname")
	private String lname;
	@Column(value="address")
	private String address;
	@Column(value="sal")
	private double sal;
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param fname
	 * @param lname
	 * @param address
	 * @param sal
	 */
	public User(int id, String fname, String lname, String address, double sal) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.sal = sal;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the sal
	 */
	public double getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(double sal) {
		this.sal = sal;
	}
	
		
}
