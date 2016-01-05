package InfoNode.nodeinfoservice;

import InfoNode.nodeinfoservice.model.Employee;
import java.util.concurrent.CopyOnWriteArrayList;


public class InfoService {

    private CopyOnWriteArrayList<Employee> employees = new CopyOnWriteArrayList<Employee>();
    private CopyOnWriteArrayList<Employee> updatedEmployees = new CopyOnWriteArrayList<Employee>();

    public CopyOnWriteArrayList<Employee> getEmployees() {
        return employees;
    }

    public CopyOnWriteArrayList<Employee> getUpdatedEmployees() {
        return updatedEmployees;
    }

    public void setEmployees(CopyOnWriteArrayList<Employee> employees) {
        this.employees = employees;
    }

    public boolean add(Employee e) {
        return employees.add(e);
    }

    public boolean remove(Employee e) {
        return employees.remove(e);
    }

    public Employee getEmployee(int index){
        return employees.get(index);
    }

    public Employee setEmployee(int index, Employee e){
        updatedEmployees.add(e);
        return employees.set(index,e);
    }

}
