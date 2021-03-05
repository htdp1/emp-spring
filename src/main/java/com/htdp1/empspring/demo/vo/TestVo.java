package com.htdp1.empspring.demo.vo;

public class TestVo {
    private String empNo;
    private String firstName;
    private String lastName;

	public TestVo(String empNo, String firstName, String lastName) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

    public String getEmpNo() {
        return empNo;
    }
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
