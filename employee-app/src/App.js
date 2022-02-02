import AddEmployee from "./component/AddEmployee";
import Navbar from "./component/Navbar";
import { BrowserRouter, Route, Routes } from "react-router-dom"
import EmployeeList from "./component/EmployeeList";
import UpdateEmployee from "./component/UpdateEmployee";
function App() {
  return (
    < div className="App">

      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route index element={<EmployeeList/>}></Route>
          <Route path="/" element={<EmployeeList/>}></Route>
          <Route path="/employeelist" element={<EmployeeList/>}></Route>
          <Route path="/addemployee" element={<AddEmployee/>}></Route>
           <Route path="/editemployee/:id" element={<UpdateEmployee/>}></Route>
        </Routes>
      </BrowserRouter>

    </div>
  );
}

export default App;
