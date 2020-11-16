import React, { useState, useEffect, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react'
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-material.css';
import Button from '@material-ui/core/Button';
import Snackbar from '@material-ui/core/Snackbar';

function Disclist() {
    const[discs, setDiscs] = useState([]);

    useEffect(() => {
        getDiscs();
    }, [])

    const getDiscs = () => {
        
    }

}