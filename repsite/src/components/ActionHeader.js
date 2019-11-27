import React from "react";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form";
import FormControl from "react-bootstrap/FormControl";
import Button from "react-bootstrap/Button";
import {Link} from "react-router-dom";

const ActionHeader = () => {
    return (
        <Navbar bg="dark" variant="dark" expand="lg">
            <Container>
                <Navbar.Brand href="#home">Real Estate Portal</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link as={Link} to ={"/properties"}>Home</Nav.Link>
                    </Nav>
                    <Form className="mt-1" inline>
                        <FormControl type="text"
                                     placeholder="Search in city" className="mr-sm-2"/>
                    </Form>}
                    <Link to={"/properties/new"}>
                        <Button variant="warning" className="ml-md-4 mt-1">Add new property</Button>
                    </Link>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default ActionHeader;