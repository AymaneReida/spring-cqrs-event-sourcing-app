import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import React, {Suspense, lazy} from 'react';
import './App.css';
import {Container} from 'react-bootstrap';

const ListCustomers = lazy(() => import('./ListCustomers'));

function App() {
  return (
    <Container fluid>
      <Router>
        <Suspense fallback={<div>Loading...</div>}>
          <Routes>
            <Route path="/" element={<ListCustomers/>}/>
          </Routes>
        </Suspense>
      </Router>
    </Container>
  );
}

export default App;
