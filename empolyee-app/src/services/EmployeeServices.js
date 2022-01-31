const EMPLOYEE_API_BASE_URL=""
class EmployeeServices {
  saveEmployee(employee){
      return axios.post(EMPLOYEE_API_BASE_URL,employee)
  }

}
export default new EmployeeServices();