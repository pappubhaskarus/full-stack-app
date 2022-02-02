import React from 'react';
import { useNavigate } from 'react-router-dom';

const Employee = ({employee,deleteEmployee}) => {
    const navigate=useNavigate()
    const editEmployee=(id)=>{
        navigate(`/editemployee/${id}`)
    }
    
  return (
    <>
    <tr key={employee.id}>
    <td data-firstName={`firstName_${employee.id}`}  className='text-left px-6 py-4 whitespace-nowrap'>{employee.firstName}</td>
    <td className='text-left px-6 py-4 whitespace-nowrap'>{employee.lastName}</td>
    <td className='text-left px-6 py-4 whitespace-nowrap'>{employee.emailId}</td>
    <td className='text-right px-6 py-4 whitespace-nowrap font-medium text-sm'>
        <button  onClick={(e)=>deleteEmployee(e,employee.id)} className='text-indego-600 hover:text-indigo-800 px-4 hover:corsor-pointer'>Delete</button>
        <button  onClick={(id)=> editEmployee(employee.id)} className='text-indego-600 hover:text-indigo-800 hover:corsor-pointer'>Edit</button>
        {/* <Link className='text-indego-600 hover:text-indigo-800 hover:corsor-pointer' to={`/editemployee/${employee.id}`}>Edit</Link> */}

    </td>
  </tr>
  </>
  )
 
};

export default Employee;
