package es.iespuertodelacruz.cc.institutorest.entity;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
/**
 * Clase User
 * @author dama
 *
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {
	
	/* CONSTANTES GLOBALES ESTATICAS */
	public static final int ACCESSLEVEL_ADMINISTRATOR = 1;
	public static final int ACCESSLEVEL_STANDARD = 0;
	
	/**
	 * Variables de clase User
	 */
	@Id
	private String user;
	private String email;
	@JsonIgnore
	private String hash;
	private boolean active;
	@Column
	private int type;
	
	/**
	 * Constructor por defecto
	 */
	public User() {
		
	}
	
	/**
	 * Constructor que importa un objeto del mismo tipo
	 * @param u Objeto usuario que se duplica
	 */
	public User(User u) {
		this.user = u.getUser();
		this.email = u.getEmail();
		this.active = u.isActive();
		this.type = u.getAccessLevel();
		this.hash = u.getHashPwd();
	}
	
	/**
	 * Constructor completo
	 * @param user Nombre de usuario
	 * @param email Email del usuario
	 * @param plainPwd Contraseña del usuario en texto plano
	 * @param active Valor que indica si la cuenta esta activa o no
	 * @param hashPwd Determina si plainPwd será encriptado o no
	 */
	public User(String user, String email, String plainPwd, boolean active, boolean hashPwd, int type) {
		super();
		this.user = user;
		this.email = email;
		this.active = active;
		this.type = type;
		if (hashPwd)
			this.hash = BCrypt.hashpw(plainPwd, BCrypt.gensalt(10));
		else
			this.hash = plainPwd;
	}

	/**
	 * Funcion que determina si la contraseña es correcta
	 * @param plainPwd Contraseña en forma de texto plano
	 * @return Devuelve true y solo true si la contraseña es correcta.
	 */
	public boolean checkPwd(String plainPwd) {
		return BCrypt.checkpw(plainPwd, hash);
	}
	
	// Getters and Setters
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashPwd() {
		return hash;
	}

	public void setHashPwd(String hashPwd) {
		this.hash = hashPwd;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAccessLevelStr() {
		switch (type) {
		case ACCESSLEVEL_ADMINISTRATOR:
			return "ROLE_ADMIN";
		case ACCESSLEVEL_STANDARD:
			return "ROLE_USER";
		default:
			return "Unknown";
		}
	}
	
	public int getAccessLevel() {
		return type;
	}

	public void setAccessLevel(int accessLevel) {
		this.type = accessLevel;
	}
	
	
	
}