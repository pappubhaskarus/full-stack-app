import axios from "axios"
const EMPLOYEE_API_BASE_URL="http://localhost:8080/api/v1/employees"
class EmployeeServices {
  saveEmployee(employee){
      return axios.post(EMPLOYEE_API_BASE_URL,employee)
  }
  getEmployees(employee){
    return axios.get(EMPLOYEE_API_BASE_URL,employee)

  }
  deleteEmployees(id){
    console.log(id)
    return axios.delete(EMPLOYEE_API_BASE_URL+ "/" +id)

  }
  getEmployeesById(id){
    return axios.get(EMPLOYEE_API_BASE_URL+ "/" +id)
  }

  updateEmployeeById(employee,id){
    return axios.patch(EMPLOYEE_API_BASE_URL+ "/" +id,employee)
  }


}
export default new EmployeeServices();