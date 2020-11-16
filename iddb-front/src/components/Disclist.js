import React, { useState, useEffect, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react'
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-material.css';
import Button from '@material-ui/core/Button';
import Snackbar from '@material-ui/core/Snackbar';


function Disclist() {
    const[discs, setDiscs] = useState([]);

    const gridRef = useRef();

    useEffect(() => {
        getDiscs();
    }, [])

    const getDiscs = () => {

        fetch('https://iddb.herokuapp.com/discs')
        .then ((response) => response.json())
        .then((data) => {
            console.log(data);
            setDiscs(data)})
        .catch((err) => console.error(err));

    }

    const columns = [
        { headerName: 'Model', field: 'model', sortable: true, filter: true },
        { headerName: 'Speed', field: 'speed', sortable: true, filter: true },
        { headerName: 'Glide', field: 'glide', sortable: true, filter: true },
        { headerName: 'Turn', field: 'turn', sortable: true, filter: true },
        { headerName: 'Fade', field: 'fade', sortable: true, filter: true },
        { headerName: 'Manufacturer', field: 'manufacturer', sortable: true, filter: true },
    

    ]

    return(
        <div>
        <div className="ag-theme-material" style={{height: '700px', width: '70%', margin: 'auto'}}>
            <AgGridReact
            ref={gridRef}
            suppressCellSelection={true}
            onGridReady={ params => {
                gridRef.current = params.api
            }}
            columnDefs={columns}
            rowData={discs}
            pagination="true"
            paginationPageSize="10"
            >
            </AgGridReact>
            
 
            </div>
            </div>
    );

}

export default Disclist;