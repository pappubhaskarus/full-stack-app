import React, { useState } from 'react';

const AddEmployee = () => {
    const [employee,setEmployee]=useState({
        id:"",
        firstName:"",
        lastName:"",
        emailId:""

    })
    const handleChange=(e)=>{
        setEmployee({
            ...employee,
            [e.target.name]:e.target.value
        })

    }
    const saveEmployee=(e)=>{
        e.preventDefault()
    }
    return <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                <h1>Add New Employee</h1>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>First Name</label>
                <input type="text" className='h-10 mt-2 px-2 py-2 w-96 border' value={employee.firstName} onChange={handleChange} name="firstName"></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>Last Name</label>
                <input type="text" className='h-10 mt-2 px-2 py-2 w-96 border' value={employee.lastName} onChange={handleChange} name="lastName"></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>Email</label>
                <input type="text" className='h-10 mt-2 px-2 py-2 w-96 border' value={employee.emailId} onChange={handleChange} name="emailId"></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 space-x-4 '>
                <button onClick={saveEmployee} className='rounded text-white font-semibold bg-green-400 hover:bg-green-700 px-6 py-2'>
                    Save
                </button>
                <button className='rounded text-white font-semibold bg-red-400 hover:bg-red-700 px-6 py-2'>
                    Clear
                </button>
            </div>
        </div>
    </div>
};

export default AddEmployee;
