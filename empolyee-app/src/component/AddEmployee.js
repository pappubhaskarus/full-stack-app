import React, { useState } from 'react';

const AddEmployee = () => {
    const [employee,setEmplyee]=useState({

    })
    return <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                <h1>Add New Empolyee</h1>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>First Name</label>
                <input type="text" className='h-10 mt-2 px-2 py-2 w-96 border'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>Last Name</label>
                <input type="text" className='h-10 mt-2 px-2 py-2 w-96 border'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>Email</label>
                <input type="text" className='h-10 mt-2 px-2 py-2 w-96 border'></input>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 space-x-4 '>
                <button className='rounded text-white font-semibold bg-green-400 hover:bg-green-700 px-6 py-2'>
                    Save
                </button>
                <button className='rounded text-white font-semibold bg-red-400 hover:bg-red-700 px-6 py-2'>
                    Clear
                </button>
            </div>
        </div>;
    </div>
};

export default AddEmployee;
