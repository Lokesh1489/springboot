package entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 30)
	private String name;
	
	@Column(name = "accno", length = 15)
	private Long accno;
	@Column(name = "balance", length = 10)
	private Long balance;
	
	public Account() {
		
	}
	
	public Account(String name,Long accno, Long balance) {
		this.name = name;
		this.setAccno(accno);
		this.balance = balance;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accno, balance, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accno, other.accno) && Objects.equals(balance, other.balance)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	
	
}
