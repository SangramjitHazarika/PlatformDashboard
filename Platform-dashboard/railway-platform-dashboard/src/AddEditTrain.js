import React, { useState } from 'react';
import axios from 'axios';

const AddEditTrain = () => {
    const [train, setTrain] = useState({
        trainName: '',
        platform: '',
        arrivalTime: '',
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setTrain({ ...train, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('/api/trains', train)
            .then(response => console.log(response.data))
            .catch(error => console.error(error));
    };

    return (
        <div>
            <h2>Add/Edit Train</h2>
            <form onSubmit={handleSubmit}>
                {/* Input fields for train information */}
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default AddEditTrain;
