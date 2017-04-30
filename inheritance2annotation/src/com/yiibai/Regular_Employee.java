package com.yiibai;

/**
 * 
 * @author by maxsu
 * @copyright http://www.yiibai.com
 * @link download at: http://www.yiibai.com/siteinfo/download.html
 */
import javax.persistence.*;

@Entity
@Table(name = "regularemployee102")
@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "id")),
		@AttributeOverride(name = "name", column = @Column(name = "name")) })
public class Regular_Employee extends Employee {

	@Column(name = "salary")
	private float salary;

	@Column(name = "bonus")
	private int bonus;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	// setters and getters
	
}