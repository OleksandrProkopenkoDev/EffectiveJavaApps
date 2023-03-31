import logo from './logo.svg';
import './App.css';
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Route, Routes, useNavigate } from 'react-router-dom';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';

function App() {
  return (
    <div>
         
          <HeaderComponent />
          <div className="container">
            <Routes>
              <Route path='/' exact element={<ListEmployeeComponent />}></Route>
              <Route path='/employees' exact element={<ListEmployeeComponent />}></Route>
              <Route path='/add-employee' exact element={<CreateEmployeeComponent />}></Route>
              <Route path='/update-employee/:id' exact element={<UpdateEmployeeComponent />}></Route>

            </Routes>
          </div>
          
        
        <FooterComponent />
      
    </div>
  );
}

export function AppWithRouter(props){
  const navigate = useNavigate();
  return (<App navigate={navigate}></App>)
}

export default App;
