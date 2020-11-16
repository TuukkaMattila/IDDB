import React, { useState, useEffect, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react'
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-material.css';
import Button from '@material-ui/core/Button';



function Disclist() {
    const[discs, setDiscs] = useState([]);

    const gridRef = useRef();

    useEffect(() => {
        getDiscs();
    }, [])

    const getDiscs = () => {

        fetch('https://iddb.herokuapp.com/api/discs')
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
        { headerName: 'Manufacturer', field: 'manufacturer.name', sortable: true, filter: true },
    

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
            <Button variant="contained" color="primary" href="https://iddb.herokuapp.com/index">Log in as admin</Button>
            
 
            </div>
            </div>
    );

}

export default Disclist;