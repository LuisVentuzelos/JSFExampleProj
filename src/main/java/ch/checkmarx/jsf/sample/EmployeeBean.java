package ch.checkmarx.jsf.sample;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private  List<Employee> employees;
    private EmployeeBean.Employee tempEmployee = new Employee();

       public EmployeeBean () {
           employees    = new ArrayList<EmployeeBean.Employee>();

           employees.add( new EmployeeBean.Employee("Alan Decker", "CEO",
                    27,new BigDecimal("21700.00") ));
           employees.add(  new EmployeeBean.Employee("Jonah Presley", "Human Resources",
                    45,new BigDecimal("11500.00")));
           employees.add( new EmployeeBean.Employee("Luna Goodwin", "Sales",
                   57, new BigDecimal("11600.00")));
           employees.add(  new EmployeeBean.Employee("Jerald Gerard", "Trainee Program",
                    20,new BigDecimal("5200.00")));
           employees.add(  new EmployeeBean.Employee("Billie Pie", "Interns",
                    17,new BigDecimal("100.00")));
    }


    public List<Employee> getEmployees() {

        return employees;

    }



    public void  addEmployee(){
        employees.add((tempEmployee));
        tempEmployee = new Employee();
    }

    public Employee getTempEmployee() {
        return tempEmployee;
    }

    public void setTempEmployee(Employee tempEmployee) {
        this.tempEmployee = tempEmployee;
    }


    public String editEmployee() {

        for (Employee emp : employees){
          if( emp.equals(tempEmployee)){
              emp.setCanEdit(true);
          }
        }
        tempEmployee = new Employee();
        return null;
    }

    public String saveEmployees() {

        for (Employee order : employees){
            order.setCanEdit(false);
        }
        tempEmployee = new Employee();
        return null;

    }
    public String deleteEmployee() {

        employees.remove(tempEmployee);
        tempEmployee = new Employee();
        return null;
    }
    public static class Employee{
        private String name;
        private String department;
        private int age;
        private BigDecimal salary;
        private boolean canEdit = false;
        public Employee(String name, String department, int age, BigDecimal salary) {
            this.name = name;
            this.department = department;
            this.age = age;
            this.salary = salary;
        }

        public Employee() {
            this.name = "";
            this.department = "";
            this.age = 0;
            this.salary = new BigDecimal(0.0);
        }

        public Employee(String name, String department, int age, BigDecimal salary, boolean canEdit) {
            this.name = name;
            this.department = department;
            this.age = age;
            this.salary = salary;
            this.canEdit = canEdit;
        }

        public boolean isCanEdit() {
            return canEdit;
        }

        public void setCanEdit(boolean canEdit) {
            this.canEdit = canEdit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee)) return false;
            Employee employee = (Employee) o;
            return age == employee.age && name.equals(employee.name) && department.equals(employee.department) && salary.equals(employee.salary);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, department, age, salary);
        }
    }

}
