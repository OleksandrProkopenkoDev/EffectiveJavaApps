import React, { Component } from 'react';
import { Link} from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';


class ListEmployeeComponent extends Component {

    
    constructor(props){
        super(props);

        this.state = {
            employees: []
        }

        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
    }

    editEmployee(id){
        // this.props.navigate(`/update-employee/${id}`);
        this.props.navigate('/update-employee/:id');
    }

    componentDidMount(){
        EmployeeService.getEmployees().then((res)=>{
            this.setState({employees: res.data});
        });
    }

     addEmployee(){
        // const navigate = useNavigate();
        // navigate('/add-employee');
        // this.props.navigate('/add-employee');
        //  this.props.navigate('/add-employee');
       
        
    }



    render() {
        return (
            // here we write java script X code - this is like html+JS
            <div> 
                <h2 className="text-center">Employees List</h2>
                <div className='row'>
                    {/* <button className='btn btn-primary' onClick={this.addEmployee} to="/add-employee"> 
                        Add Employee </button>*/}
                        <Link to="/add-employee" className='btn btn-primary'
                         onClick={this.addEmployee}>Link to add employee</Link>
                </div>

                <div className = "row">
                    <table className='table table-striped table bordered'>
                        <thead>
                            <tr>
                                <th>Employee Name</th>
                                <th>Offer Date</th>
                                <th>Salary</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        {/* here is the JS code to dynamicly get info */}
                        <tbody>
                            {
                                this.state.employees.map(
                                    employee => 
                                    <tr key = {employee.id}>
                                        <td>{employee.name}</td>
                                        <td>{employee.offerDate}</td>
                                        <td>{employee.salary}</td>
                                        <td>
                                            <button onClick={()=>this.editEmployee(employee.id)} className='btn btn-info'>Update</button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>

                    </table>

                </div>
            </div>
        );
    }
}

export default ListEmployeeComponent;