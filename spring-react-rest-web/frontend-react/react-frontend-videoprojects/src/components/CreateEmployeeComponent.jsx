import React, { Component } from 'react';
import { Link} from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

class CreateEmployeeComponent extends Component {
    
    constructor(props){
        super(props);

        this.state = {
           name: '',
           offerDate:'2023-01-01',
           salary: 0 
        }

        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeOfferDateHandler = this.changeOfferDateHandler.bind(this);
        this.changeSalaryHandler = this.changeSalaryHandler.bind(this);
        this.saveEmployee = this.saveEmployee.bind(this);
        this.cancelCreation = this.cancelCreation.bind(this);
    }

    saveEmployee = (e)=>{
        e.preventDefault();
        let employee = {name: this.state.name, offerDate: this.state.offerDate,
        salary: this.state.salary};
        console.log('employee => '+JSON.stringify(employee));
        EmployeeService.createEmployee(employee).then(res =>{
            this.props.to('/employees');
        });
        // this.props.history.push('/employees');
    }

    cancelCreation(){
        // this.props.history.push('/employees');  
    }
    
    changeNameHandler=(event)=>{
        this.setState({name: event.target.value});
    }

    changeOfferDateHandler=(event)=>{
        this.setState({offerDate: event.target.value});
    }

    changeSalaryHandler=(event)=>{
        this.setState({salary: event.target.value});
    }

    render() {
        return (
            <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card-col-md-6 offset-md-3 '>
                            <h3 className='text-center'>Add Employee</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label> Name </label>
                                        <input placeholder='Name' name='name'
                                        className='form-control' value={this.state.name}
                                        onChange={this.changeNameHandler}/>
                                    </div>

                                    <div className='form-group'>
                                        <label> OfferDate </label>
                                        <input placeholder='offerDate' name='offerDate' 
                                        className='form-control' value={this.state.offerDate}
                                        onChange={this.changeOfferDateHandler}/>
                                    </div>

                                    <div className='form-group'>
                                        <label> Salary </label>
                                        <input placeholder='salary' name='salary' 
                                        className='form-control' value={this.state.salary}
                                        onChange={this.changeSalaryHandler}/>
                                    </div>

                                    <Link className='btn btn-success' to="/employees" onClick={this.saveEmployee}  >Save</Link>
                                    <Link className='btn btn-danger' onClick={this.cancelCreation} to="/employees"
                                    style={{marginLeft:'10px'}}>Cancel</Link>
                                </form>
                            </div>
                        </div>

                    </div>
                 </div>
            </div>
        );
    }
}

export default CreateEmployeeComponent;