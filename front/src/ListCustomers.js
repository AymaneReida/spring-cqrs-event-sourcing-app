import React, {useEffect, useState} from 'react';
import {Card, Col, Row, Table} from 'react-bootstrap';

const axios = require('axios');

const instance = axios.create({
  baseURL: 'http://localhost:8888',
});

function ListCustomers() {
  const [data, setData] = useState()

  useEffect(() => {
    instance.get('/CUSTOMER-QUERY-SIDE/customers/query/all')
      .then(function (response) {
        setData(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, []);

  function getProductItems() {
    return data.map((item) => {
      return (
        <tr>
          <th>{item.id}</th>
          <th>{item.name}</th>
          <th>{item.email}</th>
        </tr>
      )
    });
  }

  return (
    <>
      <Row className='mt-5'>
        <Col>
          <Card className='text-center fs-1 mb-3' body>
            List Customers
          </Card>
        </Col>
      </Row>
      <Row>
        <Col>
          <Table striped bordered hover>
            <thead>
            <tr>
              <th>#</th>
              <th>Customer Name</th>
              <th>Customer Email</th>
            </tr>
            </thead>
            <tbody>
            {data && getProductItems()}
            </tbody>
          </Table>
        </Col>
      </Row>
    </>
  );
}

export default ListCustomers;