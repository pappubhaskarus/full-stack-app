import React, { useEffect, useState } from 'react';
import EmployeeServices from '../services/EmployeeServices';

import { useNavigate } from 'react-router-dom';
import Employee from './Employee';

const EmployeeList = () => {
    const [loading,setLoading]=useState(true)
    const [employees,setEmployees]=useState(null);
    const navigate=useNavigate();

    const fetchData= async()=>{
        setLoading(true);
        try {
          const response= await EmployeeServices.getEmployees();
          setEmployees(response.data)
        }catch(error){
            console.log(error)
        }
        setLoading(false)
    }
    
    useEffect(()=>{
      
       fetchData();
    },[])

    const deleteEmployee=(e,id)=>{
        console.log(id)
        e.preventDefault();
        EmployeeServices.deleteEmployees(id).then((res)=>{
            fetchData();
        })

    }
    return (
        <div className='container mx-auto my-8'>
            <div className='h-12'>
                <button onClick={()=>navigate("/addemployee")} className='rounded bg-slate-600 text-white px-6 py-2 font-semibold'>Add Employee</button>
            </div>
            <div className='flex shadow border-b'>
                <table className='min-w-full'>
                    <thead className='bg-gray-50'>
                        <tr>
                            <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>First Name</th>
                            <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Last Name</th>
                            <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Email Id</th>
                            <th className='text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Action</th>

                        </tr>
                    </thead>
                    {!loading &&(
                    <tbody className='bg-white'>
                        {employees.map((employee)=>{
                            return (
                            <Employee deleteEmployee={deleteEmployee} employee={employee} key={employee.id}></Employee> 
                            )
                        })}
                       
                    </tbody>
                    ) }
                </table>
            </div>
        </div>
    )

};

export default EmployeeList;
