import logo from './logo.svg';
import './App.css';
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';

function App() {
  return (
    /*   <Router>
               <Routes> 
                  <Route path='/'  element={<ListEmployeeComponent />}></Route>
                 <Route path='/employees'  element={<ListEmployeeComponent />}></Route> 
                 
               </Routes>
        </Router>*/

    <div>

      <Router>
        
          <HeaderComponent />
          <div className="container">

            <Routes>
              <Route path='/' exact element={<ListEmployeeComponent />}></Route>
              <Route path='/employees' exact element={<ListEmployeeComponent />}></Route>
              <Route path='/add-employee' exact element={<CreateEmployeeComponent />}></Route>

            </Routes>
          </div>
          
        
        <FooterComponent />
      </Router>
    </div>
  );
}


export default App;
