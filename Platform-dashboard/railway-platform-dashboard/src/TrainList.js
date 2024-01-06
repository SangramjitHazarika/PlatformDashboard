import React, { useState, useEffect } from 'react';
import axios from 'axios';

const TrainList = () => {
    const [trains, setTrains] = useState([]);

    useEffect(() => {
        axios.get('/api/trains')
            .then(response => setTrains(response.data))
            .catch(error => console.error(error));
    }, []);

    return (
        <div>
            <h2>Train List</h2>
            <table>
                <thead>
                    <tr>
                        <th>Train Name</th>
                        <th>Platform</th>
                        <th>Arrival Time</th>
                    </tr>
                </thead>
                <tbody>
                    {trains.map(train => (
                        <tr key={train.id}>
                            <td>{train.trainName}</td>
                            <td>{train.platform}</td>
                            <td>{train.arrivalTime}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default TrainList;
