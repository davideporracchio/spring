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
@Table(value = "subscriber")
public class Subscriber {

	@PrimaryKey(value = "id")
	private String id;
	@Column(value = "chargingid")
	private String chargingId;
	@Column(value = "username")
	private String username;
	@Column(value = "password")
	private String password;

	/**
	 * 
	 */
	public Subscriber() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param chargingId
	 * @param username
	 * @param password
	 */
	Subscriber(String id, String chargingId, String username, String password) {
		this.id = id;
		this.chargingId = chargingId;
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the chargingId
	 */
	public String getChargingId() {
		return chargingId;
	}

	/**
	 * @param chargingId
	 *            the chargingId to set
	 */
	public void setChargingId(String chargingId) {
		this.chargingId = chargingId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
